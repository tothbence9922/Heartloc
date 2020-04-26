package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import entity.item.optionalitem.Food;
import entity.item.optionalitem.FragileShovel;
import entity.item.optionalitem.Rope;
import entity.item.optionalitem.Shovel;
import entity.item.optionalitem.Wetsuit;
import entity.item.targetitem.Beacon;
import entity.item.targetitem.Cartridge;
import entity.item.targetitem.Gun;
import entity.player.Eskimo;
import entity.player.Explorer;
import entity.player.Player;
import tiles.StableTile;
import tiles.Tile;
import tiles.UnstableTile;

public class MapLoader {

	public static void readMapFromJSON(String path) throws FileNotFoundException, IOException {
		try {
			Game.getInstance().ClearMap();
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(new FileReader(path));
			JSONArray arrays = (JSONArray) obj.get("tiles");

			ArrayList<Tile> tiles = new ArrayList<Tile>();
			ArrayList<Tile> tilesRead = new ArrayList<Tile>();
			ArrayList<ArrayList<ArrayList<String>>> tileInfos = new ArrayList<ArrayList<ArrayList<String>>>();
			
			for (int i = 0; i < arrays.size(); i++) {				
				ArrayList<ArrayList<String>> tileInfo = readTile(tilesRead, (JSONObject) arrays.get(i));
				tiles.add(tilesRead.get(i));
				tileInfos.add(tileInfo);
			}
			
			ArrayList<Player> players = new ArrayList<Player>();

			for (int tileIter = 0; tileIter < tiles.size(); tileIter++) {
				ArrayList<String> neighArray = tileInfos.get(tileIter).get(0);
				ArrayList<String> entityArray = tileInfos.get(tileIter).get(1);
				ArrayList<String> itemArray = tileInfos.get(tileIter).get(2);

			
				for (int neighIter = 0; neighIter < neighArray.size(); neighIter++) { // 0. -> szomszedok
					for (int otherTileIter = 0; otherTileIter < tiles.size(); otherTileIter++) {
						if (neighIter != otherTileIter && neighArray.get(neighIter) == tiles.get(otherTileIter).getId()) {
							tiles.get(tileIter).addNeighbour(tiles.get(otherTileIter));
						}
					}
				}
				for (int entityIter = 0; entityIter < entityArray.size(); entityIter++) {// 1. -> entity-k
					if (entityArray.get(entityIter).contains("Esk")) {
						Eskimo e = new Eskimo(entityArray.get(entityIter));
						tiles.get(tileIter).receive(e);
						tiles.get(tileIter).getPlayers().add(e);
						players.add(e);
					} else if (entityArray.get(entityIter).contains("Exp")) {
						Explorer e = new Explorer(entityArray.get(entityIter));
						tiles.get(tileIter).receive(e);
						tiles.get(tileIter).getPlayers().add(e);
						players.add(e);
					} else if (entityArray.get(entityIter).contains("Pol")) {
						PolarBear pb = new PolarBear(entityArray.get(entityIter));
						tiles.get(tileIter).addPolarBear(pb);
						tiles.get(tileIter).receive(pb);
					}
				}
				for (int itemIter = 0; itemIter < itemArray.size(); itemIter++) {// 2. -> itemek
					if (itemArray.get(itemIter).contains("Sho")) {
						tiles.get(tileIter).getItems().add(new Shovel(itemArray.get(itemIter)));
					} else if (itemArray.get(itemIter).contains("Foo")) {
						tiles.get(tileIter).getItems().add(new Food(itemArray.get(itemIter)));
					} else if (itemArray.get(itemIter).contains("Wet")) {
						tiles.get(tileIter).getItems().add(new Wetsuit(itemArray.get(itemIter)));
					} else if (itemArray.get(itemIter).contains("Rop")) {
						tiles.get(tileIter).getItems().add(new Rope(itemArray.get(itemIter)));
					} else if (itemArray.get(itemIter).contains("iTen")) {
						tiles.get(tileIter).getItems().add(new TentItem(itemArray.get(itemIter)));
					} else if (itemArray.get(itemIter).contains("Fra")) {
						tiles.get(tileIter).getItems().add(new FragileShovel(itemArray.get(itemIter)));
					} else if (itemArray.get(itemIter).contains("Car")) {
						tiles.get(tileIter).getItems().add(Cartridge.getInstance("Car"));
					} else if (itemArray.get(itemIter).contains("Gun")) {
						tiles.get(tileIter).getItems().add(Gun.getInstance("Gun"));
					} else if (itemArray.get(itemIter).contains("Bea")) {
						tiles.get(tileIter).getItems().add(Beacon.getInstance("Bea"));
					}
				}
			}

			// TODO
			// for (tile : tiles) {for (tile : tiles){hozzáadjuk id szerint a hashmapbe}...}
			
			Game.getInstance();
			Game.setTiles(tiles);
			Game.setPlayers(players);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> readEntities(JSONArray array) {
		ArrayList<String> entityIdArray = new ArrayList<String>();
		for (int j = 0; j < array.size(); j++) {
			if (array.size() != 0)
				entityIdArray.add((String) array.get(j));
		}
		return entityIdArray;
	}

	public static ArrayList<String> readNeighbours(JSONArray array) {
		ArrayList<String> neighbourIdArray = new ArrayList<String>();
		for (int j = 0; j < array.size(); j++) {
			if (array.size() != 0)
				neighbourIdArray.add((String) array.get(j));
		}
		return neighbourIdArray;
	}

	public static ArrayList<String> readItems(JSONArray array) {
		ArrayList<String> itemIdArray = new ArrayList<String>();
		for (int j = 0; j < array.size(); j++) {
			if (array.size() != 0)
				itemIdArray.add((String) array.get(j));
		}
		return itemIdArray;
	}

	/**
	 * @param tile       A Tile objektum, amit inicializalunk jelenleg.
	 * @param tileObject A JSONObject objektum, amely alapjan inicializalunk.
	 * @return A jelenleg inicializalt Tile szomszedjainak(0.elem), rajta levo
	 *         Entity-k(1. elem), es rajta levo Item-ek(2. elem) azonositojat
	 *         tartalmazo ArrayList.
	 */
	public static ArrayList<ArrayList<String>> readTile(ArrayList<Tile> tileArr, JSONObject tileObject) {

		String id = (String) tileObject.get("id");
		int snow = Integer.parseInt(tileObject.get("snow").toString());
		int capacity = Integer.parseInt(tileObject.get("capacity").toString());
		int hole = Integer.parseInt(tileObject.get("hole").toString());
		Tile tile = null;
		if (capacity < 0) {
			tile = new StableTile(id);
		} else {
			tile = new UnstableTile(id, 0);
		}
		tile.addSnow(snow);

		boolean val = (hole > 0) ? true : false;
		tile.setHasHole(val);
		tile.setCapacity(capacity);

		JSONArray neighbourArray = (JSONArray) tileObject.get("neighbours");
		JSONArray entityArray = (JSONArray) tileObject.get("entities");
		JSONArray itemArray = (JSONArray) tileObject.get("items");

		ArrayList<String> neighbourNames = readNeighbours(neighbourArray);
		ArrayList<String> entityNames = readNeighbours(entityArray);
		ArrayList<String> itemNames = readItems(itemArray);

		ArrayList<ArrayList<String>> tileInfo = new ArrayList<ArrayList<String>>();
		tileInfo.add(neighbourNames);
		tileInfo.add(entityNames);
		tileInfo.add(itemNames);
		
		tileArr.add(tile);
		
		return tileInfo;
	}

}
