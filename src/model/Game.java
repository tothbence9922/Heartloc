package model;

import java.util.ArrayList;
import entity.player.Player;
import tiles.Tile;

public class Game {
	private static Game single_instance = null;

	private static ArrayList<Tile> tiles = new ArrayList<Tile>();
	private static ArrayList<Player> players = new ArrayList<Player>();

	private Game() {
	}
	
	public String toJSON() {
		String jsonString = "";
		int i;
		for(i = 0; i < tiles.size()-1; i++) {
			jsonString = jsonString +"\t\t{\n" + tiles.get(i).toJSON() + "\n\t\t},\n";			
		}
		jsonString = jsonString +"\t\t{\n" + tiles.get(i).toJSON() + "\n\t\t}";			

		return "{\n\t\"tiles\": [\n\t" + jsonString + "\n\t]\n}";
	}
	
	public void ClearMap() {
		tiles = new ArrayList<Tile>();
		players = new ArrayList<Player>();
	}
	
	@Override
    public String toString() {
		String mapString = "";
		String tileStrings = "";
		String playerStrings = "";
		if(tiles.size() == 0) return "MAP IS EMPTY";
		else {
			tileStrings = "TILE | CAPACITY | SNOW | HAS HOLE | PLAYER(S) | BUILDING | ITEMS\n";
			for (int i = 0; i < tiles.size(); i++) {
				tileStrings = tileStrings + (tiles.get(i).toString());
			}
		}
		if (players.size() == 0) tileStrings = tileStrings + "\n THERE ARE NO PLAYERS ON THE MAP";
		else {
			playerStrings ="PLAYER | WORK CAPABILITY | BODY TEMPERATURE | ITEMS\n";

			for(int i = 0; i < players.size(); i++) {
				playerStrings = playerStrings + (players.get(i).toString());;
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
	}

	/**
	 * A játék megnyerésekor meghívódó metódus, magával vonzza az EndGame() metódus
	 * meghívását, ekkor a játékos gyõzelmét könyvelhetjük el.
	 */
	public void victory() {
		
	}

	/**
	 * A játék végekor meghívódó metódus, mellyel véglegesíthetjük a játék állását
	 * és lezárhatjuk a játékot.
	 */
	public static void EndGame() {
		
	}

	public void generateStorm(String string) {
		// TODO
	}

	public void generateStorm() {
		// TODO
	}

	public static ArrayList<Tile> getTiles() {
		return tiles;
	}

	public static void setTiles(ArrayList<Tile> tilesArr) {
		for(int i = 0; i < tilesArr.size(); i++)
			Game.tiles.add(tilesArr.get(i));
	}

	public static String getTile(String id) {
		for (Tile t : tiles) {
			if (t.getId().equals(id))
				return t.getId();
		}

		return "";
	}

	public static String getPlayer(String id) {
		for (Player p : players) {
			if (p.getId().equals(id))
				return p.getId();
		}

		return "";
	}

	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public static void setPlayers(ArrayList<Player> players) {
		Game.players = players;
	}

	public static void Defeat() {
		// TODO
	}
}
