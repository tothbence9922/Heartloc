package model;

import java.util.ArrayList;
import java.util.Arrays;

import entity.player.Player;
import tiles.Tile;

public class Game {
	private static Game single_instance = null;
	private static ArrayList<Tile> tiles;
	private static ArrayList<Player> players;

	private Game() {
		
	}
	
	/**
     *  a Singleton tervezesi mintat kovetve visszater egy
	 *  referenciaval
     * 
     * @return  single_instance: Game tipusu valtozo
     */
    public static Game getInstance() { 
        if (single_instance == null) 
            single_instance = new Game(); 
        return single_instance; 
    } 
	
	/**
	 *  A játék megnyerésekor meghívódó metódus, magával vonzza
	 *	az EndGame() metódus meghívását, ekkor a játékos gyõzelmét könyvelhetjük
	 *	el.
	 */
	public void victory(){
		System.out.println("Game\tvoid victory()\tparam: -");
	}
	/**
	 *  A játék végekor meghívódó metódus, mellyel
	 *  véglegesíthetjük a játék állását és lezárhatjuk a játékot.
	 */
	public static void EndGame() {
		System.out.println("Game\tvoid EndGame()\tparam: -");
	}

	public void generateStorm(String string) {
		// TODO Auto-generated method stub	
	}
	
	public void generateStorm() {
		// TODO Auto-generated method stub	
	}
	
	public static ArrayList<Tile> getTiles() {
		return tiles;
	}

	public static void setTiles(ArrayList<Tile> tiles) {
		Game.tiles = tiles;
	}
	
	public static String getTile(String id) {
		if (Arrays.asList(tiles).contains(id)) {
			for (Tile t : tiles) {
				if (t.getId().equals(id)) return t.getId();
			}
		}
		
		return "";
	}
	
	public static String getPlayer(String id) {
		if (Arrays.asList(tiles).contains(id)) {
			for (Player p : players) {
				if (p.getId().equals(id)) return p.getId();
			}
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
		// TODO Auto-generated method stub
		
	}
}
