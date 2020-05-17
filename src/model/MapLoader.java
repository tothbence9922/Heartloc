package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import controller.GameRunner;
import model.org.json.simple.JSONArray;
import model.org.json.simple.JSONObject;
import model.org.json.simple.parser.JSONParser;
import model.org.json.simple.parser.ParseException;
import model.Game;
import model.entity.Building;
import model.entity.Igloo;
import model.entity.PolarBear;
import model.entity.Tent;
import model.entity.item.Item;
import model.entity.item.optionalitem.Food;
import model.entity.item.optionalitem.FragileShovel;
import model.entity.item.optionalitem.Rope;
import model.entity.item.optionalitem.Shovel;
import model.entity.item.optionalitem.TentItem;
import model.entity.item.optionalitem.Wetsuit;
import model.entity.item.targetitem.Beacon;
import model.entity.item.targetitem.Cartridge;
import model.entity.item.targetitem.Gun;
import model.entity.player.Eskimo;
import model.entity.player.Explorer;
import model.entity.player.Player;
import model.tiles.StableTile;
import model.tiles.Tile;
import model.tiles.UnstableTile;
import view.GameView;
import view.entity.EntityView;
import view.entity.EskimoView;
import view.entity.ExplorerView;
import view.entity.PolarBearView;
import view.tiles.StableTileView;

public class MapLoader {

	private static int HEIGHT = 768;
	private static int WIDTH = 1366;

	public static HashMap<String, String> startTileMap = new HashMap<String, String>();

	public static void readMapFromJSON(String path, int eskNum, int expNum) throws FileNotFoundException, IOException {
		try {
			Game.getInstance(GameRunner.baseGameController).ClearMap();

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

			GameView.getInstance(GameRunner.baseGameController).getGamePanel().setLayout(null);

			for (int i = 0; i < tiles.size(); i++) {
				tiles.get(i).view = new StableTileView(GameRunner.baseGameController);
			}

			int n = 1;
			while (n * n < tiles.size())
				n++;

			int curTile = 0;

			int stepX = Math.round(WIDTH / n);
			int stepY = Math.round((HEIGHT * 4) / (n * 5));
			int i = 0;
			int j = 0;

			while (curTile < tiles.size()) {
				tiles.get(curTile++).view.setPos(128 + stepX * j++, 64 + stepY * i);

				if (j % n == 0) {
					j = 0;
					i++;
				}
				if (i % n == 0)
					i = 0;
			}

			for (int tileIter = 0; tileIter < tiles.size(); tileIter++) {
				ArrayList<String> neighArray = tileInfos.get(tileIter).get(0);
				ArrayList<String> entityArray = tileInfos.get(tileIter).get(1);
				ArrayList<String> itemArray = tileInfos.get(tileIter).get(2);

				for (int neighIter = 0; neighIter < neighArray.size(); neighIter++) { // 0. -> szomszedok
					for (int otherTileIter = 0; otherTileIter < tiles.size(); otherTileIter++) {
						if (neighArray.get(neighIter).contentEquals(tiles.get(otherTileIter).getId())) {
							tiles.get(tileIter).addNeighbour(tiles.get(otherTileIter));
						}
					}
				}
				for (int entityIter = 0; entityIter < entityArray.size(); entityIter++) {// 1. -> entity-k

					if (entityArray.get(entityIter).contains("Pol")) {
						PolarBear pb = new PolarBear(entityArray.get(entityIter));

						for (Tile t : tiles) {
							if (startTileMap.get(entityArray.get(entityIter)) == t.getId())
								pb.setCurrentTile(t);
						}
						Game.addPolarBear(pb);

						tiles.get(tileIter).receive(pb);
					} else if (entityArray.get(entityIter).contains("Ten")) {
						Tent t = new Tent(entityArray.get(entityIter));
						tiles.get(tileIter).setHasTent(true);
						tiles.get(tileIter).getBuildings().add(t);
					} else if (entityArray.get(entityIter).contains("Igl")) {
						Igloo ig = new Igloo(entityArray.get(entityIter));
						tiles.get(tileIter).setHasTent(true);
						tiles.get(tileIter).getBuildings().add(ig);
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
			ArrayList<Player> players = new ArrayList<Player>();

			// Creation of players
			for (int esk = 0; esk < eskNum; esk++) {
				String id = "Esk" + String.valueOf(esk + 1);
				Eskimo newEs = new Eskimo(id);
				players.add(newEs);
			}
			for (int exp = 0; exp < expNum; exp++) {
				String id = "Exp" + String.valueOf(exp + 1);

				Explorer newEx = new Explorer(id);
				players.add(newEx);
			}

			// TODO
			// Player(esk, exp), PB, Itemek, minden view-jat letrehozni tileokra illeszkedve
			Random r = new Random();
			int curPlayer = 0;
			while (curPlayer < players.size()) {
				for (Tile t : tiles) {
					// TODO MEGOLDANI H LYUKASRA NE RAKJA
					if (!t.getHasHole() && curPlayer < players.size() && r.nextInt(100) > 35) {
						t.addPlayer(players.get(curPlayer));
						t.receive(players.get(curPlayer));
						players.get(curPlayer).setCurrentTile(t);
						curPlayer++;
					}

					for (int p = 0; p < t.getPlayers().size(); p++) {
						t.getPlayers().get(p).view.setPos(t.view.getX() + r.nextInt(32), t.view.getY());
						GameView.getInstance(GameRunner.baseGameController).addView(t.getPlayers().get(p).view);
					}
					
					for (Item it : t.getItems()) {
						it.view.setLayout(null);
						it.view.setPos(t.view.getX(), t.view.getY() + 45);
						GameView.getInstance(GameRunner.baseGameController).addView(it.view);
					}

					for (Building b : t.getBuildings()) {
						b.view.setLayout(null);
						b.view.setPos(t.view.getX() + 10, t.view.getY() + 60);
						GameView.getInstance(GameRunner.baseGameController).addView(b.view);
					}

					for (PolarBear pb : t.getBears()) {
						pb.view = new PolarBearView(GameRunner.baseGameController);
						pb.view.setLayout(null);
						pb.view.setPos(t.view.getX() + 32, t.view.getY());
						GameView.getInstance(GameRunner.baseGameController).addView(pb.view);
					}
					// TODO hogolyok hozzadasa ertektol fuggoen
					GameView.getInstance(GameRunner.baseGameController).addView(t, t.view);

				}
			}

			Game.getInstance(GameRunner.baseGameController);
			Game.setTiles(tiles);

			Game.setPlayers(players);
			Game.setPlayerID(players.get(0).getId());
			Game.setFirstPlayerID(players.get(0).getId());

			GameView.getInstance(GameRunner.baseGameController).updatePanel();
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

		for (String name : entityNames) {
			startTileMap.put(name, id);
		}

		ArrayList<ArrayList<String>> tileInfo = new ArrayList<ArrayList<String>>();
		tileInfo.add(neighbourNames);
		tileInfo.add(entityNames);
		tileInfo.add(itemNames);

		tileArr.add(tile);

		return tileInfo;
	}

}
