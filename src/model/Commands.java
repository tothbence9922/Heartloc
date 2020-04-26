package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import entity.Hole;
import entity.Igloo;
import entity.item.Item;
import entity.item.optionalitem.Food;
import entity.item.optionalitem.FragileShovel;
import entity.item.optionalitem.Rope;
import entity.item.optionalitem.Shovel;
import entity.item.optionalitem.Wetsuit;
import entity.item.targetitem.Beacon;
import entity.item.targetitem.Cartridge;
import entity.item.targetitem.Gun;
import entity.item.targetitem.Rocket;
import entity.player.Eskimo;
import entity.player.Explorer;
import entity.player.Player;
import tiles.Tile;

public class Commands {
	public static String currentMap = "";
	public static Game game;

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * HANDLERS
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void loadMap(String[] cmd) throws ParseException {
		String[] maps = { "map01", "map02" };

		if (cmd.length > 1) {
			try {
				if (Arrays.asList(maps).contains(cmd[1])) {
					createCurrentMap(cmd[1]);
					currentMap = cmd[1];

					// relative to root: ./folderName
					MapLoader.readMapFromJSON("./assets/maps/" + cmd[1] + ".json");
					System.out.println((Game.getInstance()).toString());
				} else {
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

	@SuppressWarnings("unlikely-arg-type")
	public static <T, S> int finder(T[] a, S target) {
		return Arrays.asList(a).indexOf(target);
	}

	@SuppressWarnings("rawtypes")
	public static <T, S> int find(T a, S target) {
		return ((IntStream) a).filter(i -> target == ((Tile) ((HashMap) a).get(i)).getId()).findFirst().orElse(-1);
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * COMMANDS - ADD
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void addEskimo(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addPlayer(new Explorer("Esk" + (Game.getPlayers().size()+1)));

		System.out.println((Game.getInstance()).toString());
	}

	public static void addExplorer(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addPlayer(new Explorer("Exp" + (Game.getPlayers().size()+1)));

		System.out.println((Game.getInstance()).toString());
	}

	public static void addFood(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addItem(new Food("Foo" + (Game.getItems().size() + 1)));

		System.out.println((Game.getInstance()).toString());
	}

	public static void addFragileShovel(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addItem(new FragileShovel("Fra" + (Game.getItems().size() + 1)));

		System.out.println((Game.getInstance()).toString());
	}

	public static void addHole(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.setHasHole(true);

		System.out.println((Game.getInstance()).toString());	
	}

	public static void addIgloo(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.setHasIgloo(true);

		System.out.println((Game.getInstance()).toString());		
		
	}

	public static void addPolarBear(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addPolarBear(new PolarBear("Pol" + (Game.getPolarBears().size()+1)));

		System.out.println((Game.getInstance()).toString());

	}

	public static void addRope(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addItem(new Rope("Rop" + (Game.getItems().size() + 1)));

		System.out.println((Game.getInstance()).toString());
	}

	public static void addShovel(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addItem(new Shovel("Sho" + (Game.getItems().size() + 1)));

		System.out.println((Game.getInstance()).toString());
	}

	public static void addSnow(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					if (tile.getAmountOfSnow() < 5)
						tile.addSnow(1);

		System.out.println((Game.getInstance()).toString());
	}

	public static void addTent(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addItem(new TentItem("iTen" + (Game.getItems().size() + 1)));

		System.out.println((Game.getInstance()).toString());
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * COMMANDS - GIVE (TARGET)
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void giveCartridge(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		if (cmd.length != 2)
			System.out.println("Valami nincs rendben! A parancs formaja: \"giveCartridge jatekosnev\"");

		String id = cmd[1];
		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId() == id)
					p.addToInventory(Cartridge.getInstance(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}

		String[] w = { "save" };
		writeMap(w);
	}

	public static void giveGun(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		if (cmd.length != 2)
			System.out.println("Valami nincs rendben! A parancs formaja: \"giveGun jatekosnev\"");

		String id = cmd[1];
		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId() == id)
					p.addToInventory(Gun.getInstance(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}

		String[] w = { "save" };
		writeMap(w);
	}

	public static void giveBeacon(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		if (cmd.length != 2)
			System.out.println("Valami nincs rendben! A parancs formaja: \"giveBeacon jatekosnev\"");

		String id = cmd[1];
		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId() == id)
					p.addToInventory(Beacon.getInstance(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}

		String[] w = { "save" };
		writeMap(w);
	}

	public static void giveRocket(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		if (cmd.length != 2)
			System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");

		String id = cmd[1];
		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId() == id)
					p.addToInventory(Rocket.getInstance(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}

		String[] w = { "save" };
		writeMap(w);
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * COMMANDS - GIVE (OPT)
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void giveFood(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		if (cmd.length != 2)
			System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");

		String id = cmd[1];
		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId() == id)
					p.addToInventory(new Food(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}

		String[] w = { "save" };
		writeMap(w);
	}

	public static void giveFragileShovel(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		if (cmd.length != 2)
			System.out.println("Valami nincs rendben! A parancs formaja: \"giveFragileShovel jatekosnev\"");

		String id = cmd[1];
		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId() == id)
					p.addToInventory(new FragileShovel(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}

		String[] w = { "save" };
		writeMap(w);
	}

	public static void giveShovel(String[] cmd) throws ParseException {

		if (cmd.length != 2)
			System.out.println("Valami nincs rendben! A parancs formaja: \"giveShovel jatekosnev\"");

		System.out.println(cmd[1]);

		String id = cmd[1];
		System.out.println(id);
		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId().equals(id))
					p.addToInventory(new Shovel("Sho" + Integer.toString(p.getInventory().size())));
			}
		}

		System.out.println((Game.getInstance()).toString());

	}

	public static void giveRope(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		if (cmd.length != 2)
			System.out.println("Valami nincs rendben! A parancs formaja: \"giveRope jatekosnev\"");

		String id = cmd[1];
		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId() == id)
					p.addToInventory(new Rope(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}

		String[] w = { "save" };
		writeMap(w);
	}

	public static void giveTent(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		if (cmd.length != 2)
			System.out.println("Valami nincs rendben! A parancs formaja: \"giveTent jatekosnev\"");

		String id = cmd[1];
		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId() == id)
					p.addToInventory(new TentItem(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}

		String[] w = { "save" };
		writeMap(w);
	}

	public static void giveWetsuit(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		if (cmd.length != 2)
			System.out.println("Valami nincs rendben! A parancs formaja: \"giveWetsuit jatekosnev\"");

		String id = cmd[1];
		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId() == id)
					p.addToInventory(new Wetsuit(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}

		String[] w = { "save" };
		writeMap(w);
	}

	/*
	 * Kellemetlen lekezelni, inkább mégse legyen ilyen... public static void
	 * giveItem(String[] cmd) throws ParseException { String[] t = {"loadMap"};
	 * loadMap(t);
	 * 
	 * if(cmd.length != 2) System.out.
	 * println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
	 * 
	 * String id = cmd[1]; for(Tile tile : tiles) { for(Player p :
	 * tile.getPlayers()) { if(p.id == id) p.addToInventory(new
	 * Item(Integer.toString(p.getInventory().size()))); else
	 * System.out.println("Nem letezik ilyen jatekos"); } }
	 * 
	 * String[] w = {"save"}; writeMap(w); }
	 */

	public static void createStorm(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		if (cmd.length > 1) {
			game.generateStorm(cmd[1]);
		} else {
			game.generateStorm();
		}

		String[] w = { "save" };
		writeMap(w);
	}

	public static void buildTent(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		// if (cmd.length > 2)
		// Game.getTiles().get(find(Game.getTiles(), cmd[1])).buildTent(new
		// Tent("Tent023"));

		String[] w = { "save" };
		writeMap(w);
	}

	public static void check(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		// TODO
		if (cmd.length > 2) {
			// System.out.println(cmd[1] + ": " + tiles.get(cmd[1]).getCapacity());
			/*
			 * READ FROM JSON if (cmd[1].toLowerCase() == "field") { ArrayList<Tile> tiles =
			 * game.getTiles(); for (int i = 0; i < tiles.size(); i++) {
			 * System.out.println(tiles.get(i)); } } else if (cmd[1].toLowerCase() ==
			 * "player") { ArrayList<Player> players = game.getPlayers(); for (int i = 0; i
			 * < players.size(); i++) { System.out.println(players.get(i)); }
			 * 
			 * } else if (cmd[1].toLowerCase() == "polarbear") { ArrayList<PolarBear> bears
			 * = game.getPolarBears(); for (int i = 0; i < bears.size(); i++) {
			 * System.out.println(bears.get(i)); } }
			 */
		}
	}

	public static void move(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		// TODO
		// player.tile = "t2"
		// returns the current tile's id on which a players stands
		int tempIdx = find(Game.getPlayers(), cmd[1]);
		String tempString = Game.getPlayers().get(tempIdx).getCurrentTile().getId();
		@SuppressWarnings("unused") // TODO
		ArrayList<Tile> tiles = Game.getTiles().get(find(Game.getTiles(), tempString)).getNeighbours();

		// if (Arrays.asList(tiles).contains(cmd[2])) {
		// ArrayList<Player> players = Game.getPlayers();
		// Game.getTile(cmd[2]).receive((Player) players.get(0));
		// Game.getTile(currentTile).remove(Game.getPlayers().get(find(Game.getPlayers(),
		// cmd[1])));
		// }

		String[] w = { "save" };
		writeMap(w);
	}

	public static void dig(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		// dig esk1
		// dig esk1 shovel
		if (cmd.length > 2) {
			// Tile tile = game.getTile(game.getPlayer(cmd[1]).getTile());
			ArrayList<Item> inventory = Game.getPlayers().get(find(Game.getPlayers(), cmd[1])).getInventory();

			boolean couldDig = false;

			// food, shovel, shovel, fragileshovel
			if (cmd[2] == "fragileshovel") {
				for (int i = 0; i < inventory.size(); i++) {
					inventory.get(i).digWithFragileShovel();
					couldDig = true;
					if (couldDig)
						break;
				}

			} else if (cmd[2] == "shovel") {
				for (int i = 0; i < inventory.size(); i++) {
					inventory.get(i).dig();
					couldDig = true;
					if (couldDig)
						break;
				}

			}

			if (!couldDig) {
				int tempIdx = find(Game.getPlayers(), cmd[1]);
				String tempString = Game.getPlayers().get(tempIdx).getCurrentTile().getId();
				Game.getTiles().get(find(Game.getTiles(), tempString)).dig(1);
			}
		}

		String[] w = { "save" };
		writeMap(w);
	}

	public static void setCapacity(String[] cmd) throws ParseException {
		String[] t = { "loadMap" };
		loadMap(t);

		if (cmd.length > 2)
			Game.getTiles().get(find(Game.getTiles(), cmd[1])).setCapacity(Integer.parseInt(cmd[2]));

		String[] w = { "save" };
		writeMap(w);
	}
}
