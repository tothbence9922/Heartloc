package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import entity.Hole;
import entity.Igloo;
import entity.Snow;
import entity.item.optionalitem.Food;
import entity.item.optionalitem.Rope;
import entity.item.optionalitem.Shovel;
import entity.player.Eskimo;
import entity.player.Explorer;

public class Commands {
	public static String currentMap = "";
	
	public static void loadMap(String[] cmd) throws ParseException {
		String[] maps = { "map01", "map02" };

		if (cmd.length > 1) {
			try {
				if (Arrays.asList(maps).contains(cmd[1])) {
					createCurrentMap(cmd[1]);
					currentMap = cmd[1];
					
					// relative to root: ./folderName
					MapLoader.readMapFromJSON("./assets/maps/" + cmd[1] + ".json");
				}
				else {
					System.out.println("That map does not exist - try another one!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				MapLoader.readMapFromJSON("./assets/maps/temp.json");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void writeMap(String[] cmd) {
		
	}
	
	public static boolean createCurrentMap(String path) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader("./assets/maps/" + path + ".json"));
		
		PrintWriter pw = new PrintWriter("./assets/maps/temp.json"); 
        pw.write(obj.toJSONString()); 
        pw.flush(); 
        pw.close(); 
        
		return false;
	}
	
	public static void addEskimo(String[] cmd) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		// Eskimo nevét mégse lehessen megadni, autoincrement miatt
		// > tolja be a kövi helyre
		if (cmd.length > 2)
			tiles.get(cmd[1]).addPlayer(new Eskimo(Integer.parseInt(players.getPlayers.size())));
		
		String[] w = {"save"};
		writeMap(w);
	}
	
	public static void addExplorer(String[] cmd) {
		String[] t = {"loadMap"};
		loadMap(t);
		
		// Explorer nevét mégse lehessen megadni, autoincrement miatt
		// > tolja be a kövi helyre
		if (cmd.length > 2)
			tiles.get(cmd[1]).addPlayer(new Explorer(Integer.parseInt(players.getPlayers.size())));
		
		String[] w = {"save"};
		writeMap(w);
	}
	
	public static void addPolarBear(String[] cmd) {
		String[] t = {"loadMap"};
		loadMap(t);
		
		if (cmd.length > 2)
			if (!tiles.get(cmd[1]).getPolarBear())
				tiles.get(cmd[1]).addPolarBear(new PolarBear());
		
		String[] w = {"save"};
		writeMap(w);
	}
	
	public static void addIgloo(String[] cmd) {
		String[] t = {"loadMap"};
		loadMap(t);
		
		if (cmd.length > 2)
			if (!tiles.get(cmd[1]).getIgloo())
				tiles.get(cmd[1]).addIgloo(new Igloo());
		
		String[] w = {"save"};
		writeMap(w);
	}
	
	public static void addTent(String[] cmd) {
		String[] t = {"loadMap"};
		loadMap(t);
		
		if (cmd.length > 2)
			if (!tiles.get(cmd[1]).getTent())
				tiles.get(cmd[1]).addTent(new Tent());
		
		String[] w = {"save"};
		writeMap(w);
	}
	
	public static void addHole(String[] cmd) {
		String[] t = {"loadMap"};
		loadMap(t);
		
		if (cmd.length > 2)
			if (!tiles.get(cmd[1]).getHasHole())
				tiles.get(cmd[1]).addHole(new Hole());
		
		String[] w = {"save"};
		writeMap(w);
	}
	
	public static void addSnow(String[] cmd) {
		String[] t = {"loadMap"};
		loadMap(t);
		
		if (cmd.length > 2)
			if (tiles.get(cmd[1]).getAmountOfSnow() < 6)
				tiles.get(cmd[1]).addSnow(new Snow());
		
		String[] w = {"save"};
		writeMap(w);
	}
	
	public static void addFood(String[] cmd) {
		String[] t = {"loadMap"};
		loadMap(t);
		
		if (cmd.length > 2)
			tiles.get(cmd[1]).addFood(new Food(Integer.toString(game.numOfFood())));
		
		String[] w = {"save"};
		writeMap(w);
	}
	
	public static void addShovel(String[] cmd) {
		String[] t = {"loadMap"};
		loadMap(t);

		if (cmd.length > 2)
			tiles.get(cmd[1]).addShovel(new Shovel(Integer.toString(game.numOfFood())));
		
		String[] w = {"save"};
		writeMap(w);
	}
	
	public static void addFragileShovel(String[] cmd) {
		String[] t = {"loadMap"};
		loadMap(t);

		if (cmd.length > 2)
			tiles.get(cmd[1]).addFragileShovel(new FragileShovel(Integer.toString(game.numOfFood())));
		
		String[] w = {"save"};
		writeMap(w);
	}
	
	public static void addRope(String[] cmd) {
		String[] t = {"loadMap"};
		loadMap(t);

		if (cmd.length > 2)
			tiles.get(cmd[1]).addRope(new Rope(Integer.toString(game.numOfFood())));
		
		String[] w = {"save"};
		writeMap(w);
	}
}
