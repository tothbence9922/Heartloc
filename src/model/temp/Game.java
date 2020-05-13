package model.temp;

import java.util.ArrayList;

import model.entity.Building;
import model.entity.Entity;
import model.entity.item.Item;
import model.entity.player.Player;
import model.tiles.Tile;
import view.GameView;

public class Game {
	
	public static GameView view;
	
	private static Game single_instance = null;

	private static ArrayList<Tile> tiles = new ArrayList<Tile>();
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<Item> items = new ArrayList<Item>();
	private static ArrayList<PolarBear> bears = new ArrayList<PolarBear>();
	private static ArrayList<Building> buildings = new ArrayList<Building>();

	private Game() {
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
		if (players.size() == 0)
			tileStrings = tileStrings + "\n THERE ARE NO PLAYERS ON THE MAP";
		else {
			playerStrings = "PLAYER | BODY TEMPERATURE | WORK CAPABILITY | ITEMS\n";

			for (int i = 0; i < players.size(); i++) {
				playerStrings = playerStrings + (players.get(i).toString());
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
	public static Game getInstance() {
		if (single_instance == null)
			single_instance = new Game();
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
	 * A j�t�k megnyer�sekor megh�v�d� met�dus, mag�val vonzza az EndGame() met�dus
	 * megh�v�s�t, ekkor a j�t�kos gy�zelm�t k�nyvelhetj�k el.
	 */
	public void victory() {
		// TODO : WINSCREEN
		EndGame();
	}

	/**
	 * A j�t�k v�gekor megh�v�d� met�dus, mellyel v�gleges�thetj�k a j�t�k �ll�s�t
	 * �s lez�rhatjuk a j�t�kot.
	 */
	public static void EndGame() {
		// TODO : ENDING THE GAME? 
	}

	public static void generateStorm(String string) {
		if (string.equals("deterministic")) {
			for (Tile t : tiles) {
				if (t.getPlayers().size() != 0) {
					if (!t.hasIgloo()) {
						if (t.hasTent()) {
							//t.setHasTent(false);
							break;
						}
						for (Player p : t.getPlayers()) {
							p.damage(1);
						}
					}
				}
				t.addSnow(1);
			}
		}
	}

	public static void generateStorm() {
		for (Tile t : tiles) {
			if (t.getPlayers().size() != 0) {
				if (!t.hasIgloo()) {
					if (t.hasTent()) {
						//t.setHasTent(false);
						break;
					}
					for (Player p : t.getPlayers()) {
						p.damage(1);
					}
				}
			}
			if (Math.random() % 2 == 0) {				
				t.addSnow(1);
			}
		}
	}
	
	public static ArrayList<PolarBear> getPolarBears(){
		return bears;
	}

	public static void addPolarBear(PolarBear pb) {
		Game.bears.add(pb);
	}

	public static ArrayList<Tile> getTiles() {
		return tiles;
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

	public static void Defeat() {
		// TODO
	}
}
