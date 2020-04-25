package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
import tiles.StableTile;
import tiles.Tile;
import tiles.UnstableTile;

/**
 * @author Felhasználó
 *
 */
/**
 * @author Felhasználó
 *
 */
public class MapLoader {

	public static Game readMapFromJSON(String path) throws FileNotFoundException, IOException {
		Game game = Game.getInstance();
		try {
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(new FileReader(path));
			JSONArray arrays = (JSONArray) obj.get("tiles");

			ArrayList<Tile> tiles = new ArrayList<Tile>();
			ArrayList<ArrayList<ArrayList<String>>> tileInfos = new ArrayList<ArrayList<ArrayList<String>>>();
			for (int i = 0; i < arrays.size(); i++) {
				Tile tile = null;
				ArrayList<ArrayList<String>> tileInfo = readTile(tile, (JSONObject) arrays.get(i));
				tiles.add(tile);
				tileInfos.add(tileInfo);
			}

			// for ciklus a szomszedok hashmapbol torteno megbaszasara
			for (int tileIter = 0; tileIter < tiles.size(); tileIter++) {
				ArrayList<String> neighArray = tileInfos.get(tileIter).get(0);
				ArrayList<String> entityArray = tileInfos.get(tileIter).get(1);
				ArrayList<String> itemArray = tileInfos.get(tileIter).get(2);

				for (int neighIter = 0; neighIter < neighArray.size(); neighIter++) { // 0. -> szomszedok
					for (int otherTileIter = 1; otherTileIter < tiles.size(); otherTileIter++) {
						if (neighArray.get(neighIter) == tiles.get(otherTileIter).getId()) {
							tiles.get(tileIter).addNeighbour(tiles.get(otherTileIter));
						}
					}
				}
				for (int entityIter = 0; entityIter < entityArray.size(); entityIter++) {// 1. -> entity-k
					if (entityArray.get(entityIter).contains("Esk")) {
						tiles.get(tileIter).receive(new Eskimo(entityArray.get(entityIter)));
					} else if (entityArray.get(entityIter).contains("Exp")) {
						tiles.get(tileIter).receive(new Explorer(entityArray.get(entityIter)));
					} else if (entityArray.get(entityIter).contains("Pol")) {
						tiles.get(tileIter).receive(new PolarBear(entityArray.get(entityIter)));
					}
				}
				for (int itemIter = 0; itemIter < itemArray.size(); itemIter++) {// 2. -> itemek
					if (entityArray.get(itemIter).contains("Sho")) {
						tiles.get(tileIter).getItems().add(new Shovel(entityArray.get(itemIter)));
					} else if (entityArray.get(itemIter).contains("Foo")) {
						tiles.get(tileIter).getItems().add(new Food(entityArray.get(itemIter)));
					} else if (entityArray.get(itemIter).contains("Wet")) {
						tiles.get(tileIter).getItems().add(new Wetsuit(entityArray.get(itemIter)));
					} else if (entityArray.get(itemIter).contains("Rop")) {
						tiles.get(tileIter).getItems().add(new Rope(entityArray.get(itemIter)));
					} else if (entityArray.get(itemIter).contains("iTen")) {
						tiles.get(tileIter).getItems().add(new TentItem(entityArray.get(itemIter)));
					} else if (entityArray.get(itemIter).contains("Fra")) {
						tiles.get(tileIter).getItems().add(new FragileShovel(entityArray.get(itemIter)));
					} else if (entityArray.get(itemIter).contains("Car")) {
						tiles.get(tileIter).getItems().add(Cartridge.getInstance("Car"));
					} else if (entityArray.get(itemIter).contains("Gun")) {
						tiles.get(tileIter).getItems().add(Gun.getInstance("Gun"));
					} else if (entityArray.get(itemIter).contains("Bea")) {
						tiles.get(tileIter).getItems().add(Beacon.getInstance("Bea"));
					}
				}
			}

			// for (tile : tiles) {for (tile : tiles){hozzáadjuk id szerint a hashmapbe}...}
			
			Game.setTiles(tiles);

		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return game;
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
	public static ArrayList<ArrayList<String>> readTile(Tile tile, JSONObject tileObject) {

		String id = (String) tileObject.get("id");
		int snow = Integer.parseInt(tileObject.get("snow").toString());
		int capacity = Integer.parseInt(tileObject.get("capacity").toString());
		int hole = Integer.parseInt(tileObject.get("hole").toString());

		if (capacity < 0) {
			tile = new StableTile("stableTile");
		} else {
			tile = new UnstableTile("unstableTile", capacity);
		}
		tile.addSnow(snow);

		boolean val = (hole > 0) ? true : false;
		tile.setHasHole(val);

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

		return tileInfo;
	}

}
