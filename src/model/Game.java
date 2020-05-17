package model;

import java.util.ArrayList;

import controller.GameController;
import model.entity.Building;
import model.entity.PolarBear;
import model.entity.item.Item;
import model.entity.player.Player;
import model.tiles.Tile;
import view.GameView;

public class Game {

	public static String playerID = "LudMan";
	public static String firstPlayerID = "LudMan";

	public static String getFirstPlayerID() {
		return firstPlayerID;
	}

	public static void setFirstPlayerID(String firstPlayerID) {
		Game.firstPlayerID = firstPlayerID;
	}

	private static Game single_instance = null;

	private static ArrayList<Tile> tiles = new ArrayList<Tile>();
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<Item> items = new ArrayList<Item>();
	private static ArrayList<PolarBear> bears = new ArrayList<PolarBear>();
	private static ArrayList<Building> buildings = new ArrayList<Building>();

	public static GameView view;

	private Game(GameController baseGameController) {
		view = GameView.getInstance(baseGameController);
	}

	public String toJSON() {
		String jsonString = "";
		int i;
		for (i = 0; i < tiles.size() - 1; i++) {
			jsonString = jsonString + "\t\t{\n" + tiles.get(i).toJSON() + "\n\t\t},\n";
		}
		jsonString = jsonString + "\t\t{\n" + tiles.get(i).toJSON() + "\n\t\t}";

		return "{\n\t\"tiles\": [\n\t" + jsonString + "\n\t]\n}";
	}

	@Override
	public String toString() {
		String mapString = "";
		String tileStrings = "";
		String playerStrings = "";
		if (tiles.size() == 0)
			return "MAP IS EMPTY";
		else {
			tileStrings = "TILE | CAPACITY | SNOW | HAS HOLE | PLAYER(S) | BUILDING | ITEMS\n";
			for (int i = 0; i < tiles.size(); i++) {
				tileStrings = tileStrings + (tiles.get(i).toString());
			}
		}
		if (Game.players.size() == 0)
			tileStrings = tileStrings + "\n THERE ARE NO PLAYERS ON THE MAP";
		else {
			playerStrings = "PLAYER | BODY TEMPERATURE | WORK CAPABILITY | ITEMS\n";

			for (int i = 0; i < Game.players.size(); i++) {
				playerStrings = playerStrings + (Game.players.get(i).toString());
				;
			}
		}
		mapString = tileStrings + playerStrings;
		return mapString;
	}

	/**
	 * a Singleton tervezesi mintat kovetve visszater egy referenciaval
	 * 
	 * @return single_instance: Game tipusu valtozo
	 */
	public static Game getInstance(GameController baseGameController) {
		if (single_instance == null)
			single_instance = new Game(baseGameController);
		return single_instance;
	}

	public void ClearMap() {
		tiles = new ArrayList<Tile>();
		players = new ArrayList<Player>();
		items = new ArrayList<Item>();
		bears = new ArrayList<PolarBear>();
		buildings = new ArrayList<Building>();
	}

	/**
	 * A játék megnyerésekor meghívódó metódus, magával vonzza az EndGame() metódus
	 * meghívását, ekkor a játékos gyõzelmét könyvelhetjük el.
	 */
	public void victory() {
		boolean losestate = false;
		EndGame(losestate, "Congratulations!");
	}

	/**
	 * A játék végekor meghívódó metódus, mellyel véglegesíthetjük a játék állását
	 * és lezárhatjuk a játékot.
	 */
	public static void EndGame(boolean losestate, String msg) {
		view.EndGame(losestate, msg);
	}

	public static void generateStorm() {
		for (Tile t : tiles) {
			if (t.getPlayers().size() != 0) {
				if (!t.hasIgloo()) {
					if (t.hasTent()) {
						t.setHasTent(false);
						break;
					}
					for (Player p : t.getPlayers()) {
						p.damage(1);
						if (p.getTemperature() < 1) {
							p.die("The storm killed a player...");
						}
					}
				}
			}
			if (Math.random() % 2 == 0) {
				t.addSnow(1);
			}
		}
	}

	public static ArrayList<PolarBear> getPolarBears() {
		return bears;
	}

	public static void addBuilding(Building b) {
		buildings.add(b);
	}

	public static void addPolarBear(PolarBear pb) {
		Game.bears.add(pb);
	}

	public static ArrayList<Tile> getTiles() {
		return Game.tiles;
	}

	public static void setTiles(ArrayList<Tile> tilesArr) {
		for (int i = 0; i < tilesArr.size(); i++)
			Game.tiles.add(tilesArr.get(i));
	}

	public static Tile getTile(String id) {
		for (Tile t : tiles) {
			if (t.getId().equals(id))
				return t;
		}

		return null;
	}

	public static Player getPlayer(String id) {
		for (Player p : players) {
			if (p.getId().equals(id))
				return p;
		}

		return null;
	}

	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public static void setPlayers(ArrayList<Player> players) {
		Game.players = players;
	}

	public static void addPlayer(Player e) {
		Game.players.add(e);
	}

	public static void setItems(ArrayList<Item> itemsArr) {
		for (int i = 0; i < itemsArr.size(); i++)
			Game.items.add(itemsArr.get(i));
	}

	public static String getItem(String id) {
		for (Item i : items) {
			if (i.getId().equals(id))
				return i.getId();
		}

		return "";
	}

	public static ArrayList<Item> getItems() {
		return items;
	}

	public static void addItem(Item item) {
		Game.items.add(item);
	}

	public static String getPlayerID() {
		return playerID;
	}

	public static void setPlayerID(String playerID) {
		Game.playerID = playerID;
	}

	public static void nextRound() {
		for (PolarBear pb : bears)
			pb.step("MOVE");
		view.updatePanel();
		//generateStorm();
		for (Player p : players)
			p.setEnergy(5);
	}

	public static void Defeat(String msg) {
		boolean losestate = true;
		EndGame(losestate, msg);
	}
}
