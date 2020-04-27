package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import entity.Entity;
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
import tiles.StableTile;
import tiles.Tile;

/**
 * @author vabe9
 *
 */
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
		String[] maps = { "map1", "map2", "map3", "map4", "map5", "map6", "map7", "map8", "map9", "map10", "map11",
				"map12" };

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
					tile.addPlayer(new Explorer("Esk" + (Game.getPlayers().size() + 1)));

		System.out.println((Game.getInstance()).toString());
	}

	public static void addExplorer(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addPlayer(new Explorer("Exp" + (Game.getPlayers().size() + 1)));

		System.out.println((Game.getInstance()).toString());
	}

	public static void addFood(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addItem(new Food("Foo" + (Game.getItems().size() + 1)));

		System.out.println((Game.getInstance()).toString());
	}

	public static void addCartridge(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addItem(Cartridge.getInstance("Car"));

		System.out.println((Game.getInstance()).toString());
	}

	public static void addBeacon(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addItem(Beacon.getInstance("Bea"));

		System.out.println((Game.getInstance()).toString());
	}

	public static void addGun(String[] cmd) throws ParseException {
		if (cmd.length > 1)
			for (Tile tile : Game.getTiles())
				if (tile.getId().equals(cmd[1]))
					tile.addItem(Gun.getInstance("Gun"));

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
					tile.addPolarBear(new PolarBear("Pol" + (Game.getPolarBears().size() + 1)));

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

	/**
	 * Hozzaad a parancsban megadott jatekohoz egy Cartridge Itemet. Ha a paracsnak
	 * tobb mint ket tokenje van nem fgadja ez a fuggveny a parancsot, Ha nem
	 * letezik a 2. tokenben megadott jatekos, nem tortenik semmi.
	 * 
	 * @param cmd a parancs maga tokenizalva
	 * @throws ParseException
	 */
	public static void giveCartridge(String[] cmd) throws ParseException {

		if (cmd.length != 2) {
			System.out.println("Valami nincs rendben! A parancs formaja: " + cmd[0] + " jatekosnev\"");
			return;
		}

		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.addToInventory(Cartridge.getInstance("Car" + Integer.toString(Game.getItems().size() + 1)));
					break;
				}
			}
		}

		System.out.println((Game.getInstance()).toString());

	}

	/**
	 * Hozzaad a parancsban megadott jatekohoz egy Gun Itemet. Ha a paracsnak tobb
	 * mint ket tokenje van nem fgadja ez a fuggveny a parancsot, Ha nem letezik a
	 * 2. tokenben megadott jatekos, nem tortenik semmi.
	 * 
	 * @param cmd a parancs maga tokenizalva
	 * @throws ParseException
	 */
	public static void giveGun(String[] cmd) throws ParseException {

		if (cmd.length != 2) {
			System.out.println("Valami nincs rendben! A parancs formaja: " + cmd[0] + " jatekosnev\"");
			return;
		}

		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.addToInventory(Gun.getInstance("Gun" + Integer.toString(Game.getItems().size() + 1)));
					break;
				}
			}
		}

		System.out.println((Game.getInstance()).toString());

	}

	/**
	 * Hozzaad a parancsban megadott jatekohoz egy Beacon Itemet. Ha a paracsnak
	 * tobb mint ket tokenje van nem fgadja ez a fuggveny a parancsot, Ha nem
	 * letezik a 2. tokenben megadott jatekos, nem tortenik semmi.
	 * 
	 * @param cmd a parancs maga tokenizalva
	 * @throws ParseException
	 */
	public static void giveBeacon(String[] cmd) throws ParseException {

		if (cmd.length != 2) {
			System.out.println("Valami nincs rendben! A parancs formaja: " + cmd[0] + " jatekosnev\"");
			return;
		}

		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.addToInventory(Beacon.getInstance("Bea" + Integer.toString(Game.getItems().size() + 1)));
					break;
				}
			}
		}

		System.out.println((Game.getInstance()).toString());

	}

	/**
	 * Hozzaad a parancsban megadott jatekohoz egy Rocket Itemet. Ha a paracsnak
	 * tobb mint ket tokenje van nem fgadja ez a fuggveny a parancsot, Ha nem
	 * letezik a 2. tokenben megadott jatekos, nem tortenik semmi.
	 * 
	 * @param cmd a parancs maga tokenizalva
	 * @throws ParseException
	 */
	public static void giveRocket(String[] cmd) throws ParseException {

		if (cmd.length != 2) {
			System.out.println("Valami nincs rendben! A parancs formaja: " + cmd[0] + " jatekosnev\"");
			return;
		}

		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.addToInventory(Rocket.getInstance("Roc" + Integer.toString(Game.getItems().size() + 1)));
					break;
				}
			}
		}

		System.out.println((Game.getInstance()).toString());

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

	/**
	 * Hozzaad a parancsban megadott jatekohoz egy Food Itemet. Ha a paracsnak tobb
	 * mint ket tokenje van nem fgadja ez a fuggveny a parancsot, Ha nem letezik a
	 * 2. tokenben megadott jatekos, nem tortenik semmi.
	 * 
	 * @param cmd a parancs maga tokenizalva
	 * @throws ParseException
	 */
	public static void giveFood(String[] cmd) throws ParseException {

		if (cmd.length != 2) {
			System.out.println("Valami nincs rendben! A parancs formaja: " + cmd[0] + " jatekosnev\"");
			return;
		}

		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.addToInventory(new Food("Foo" + Integer.toString(Game.getItems().size() + 1)));
					break;
				}
			}
		}

		System.out.println((Game.getInstance()).toString());

	}

	/**
	 * Hozzaad a parancsban megadott jatekohoz egy FragileSovel Itemet. Ha a
	 * paracsnak tobb mint ket tokenje van nem fgadja ez a fuggveny a parancsot, Ha
	 * nem letezik a 2. tokenben megadott jatekos, nem tortenik semmi.
	 * 
	 * @param cmd a parancs maga tokenizalva
	 * @throws ParseException
	 */
	public static void giveFragileShovel(String[] cmd) throws ParseException {

		if (cmd.length != 2) {
			System.out.println("Valami nincs rendben! A parancs formaja: " + cmd[0] + " jatekosnev\"");
			return;
		}

		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.addToInventory(new FragileShovel("Fra" + Integer.toString(Game.getItems().size() + 1)));
					break;
				}
			}
		}

		System.out.println((Game.getInstance()).toString());

	}

	/**
	 * Hozzaad a parancsban megadott jatekohoz egy Shovel Itemet. Ha a paracsnak
	 * tobb mint ket tokenje van nem fgadja ez a fuggveny a parancsot, Ha nem
	 * letezik a 2. tokenben megadott jatekos, nem tortenik semmi.
	 * 
	 * @param cmd a parancs maga tokenizalva
	 * @throws ParseException
	 */
	public static void giveShovel(String[] cmd) throws ParseException {

		if (cmd.length != 2) {
			System.out.println("Valami nincs rendben! A parancs formaja: " + cmd[0] + " jatekosnev\"");
			return;
		}

		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.addToInventory(new Shovel("Sho" + Integer.toString(Game.getItems().size() + 1)));
					break;
				}
			}
		}

		System.out.println((Game.getInstance()).toString());

	}

	/**
	 * Hozzaad a parancsban megadott jatekohoz egy Rope Itemet. Ha a paracsnak tobb
	 * mint ket tokenje van nem fgadja ez a fuggveny a parancsot, Ha nem letezik a
	 * 2. tokenben megadott jatekos, nem tortenik semmi.
	 * 
	 * @param cmd a parancs maga tokenizalva
	 * @throws ParseException
	 */
	public static void giveRope(String[] cmd) throws ParseException {

		if (cmd.length != 2) {
			System.out.println("Valami nincs rendben! A parancs formaja: " + cmd[0] + " jatekosnev\"");
			return;
		}

		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.addToInventory(new Rope("Rop" + Integer.toString(Game.getItems().size() + 1)));
					break;
				}
			}
		}

		System.out.println((Game.getInstance()).toString());

	}

	/**
	 * Hozzaad a parancsban megadott jatekohoz egy Tent Itemet. Ha a paracsnak tobb
	 * mint ket tokenje van nem fgadja ez a fuggveny a parancsot, Ha nem letezik a
	 * 2. tokenben megadott jatekos, nem tortenik semmi.
	 * 
	 * @param cmd a parancs maga tokenizalva
	 * @throws ParseException
	 */
	public static void giveTent(String[] cmd) throws ParseException {

		if (cmd.length != 2) {
			System.out.println("Valami nincs rendben! A parancs formaja: " + cmd[0] + " jatekosnev\"");
			return;
		}

		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.addToInventory(new TentItem("Ten" + Integer.toString(Game.getItems().size() + 1)));
					break;
				}
			}
		}

		System.out.println((Game.getInstance()).toString());

	}

	/**
	 * Hozzaad a parancsban megadott jatekohoz egy Tent Itemet. Ha a paracsnak tobb
	 * mint ket tokenje van nem fgadja ez a fuggveny a parancsot, Ha nem letezik a
	 * 2. tokenben megadott jatekos, nem tortenik semmi.
	 * 
	 * @param cmd a parancs maga tokenizalva
	 * @throws ParseException
	 */
	public static void giveWetsuit(String[] cmd) throws ParseException {

		if (cmd.length != 2) {
			System.out.println("Valami nincs rendben! A parancs formaja: " + cmd[0] + " jatekosnev\"");
			return;
		}

		for (Tile tile : Game.getTiles()) {
			for (Player p : tile.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.addToInventory(new Wetsuit("Wet" + Integer.toString(Game.getItems().size() + 1)));
					break;
				}
			}
		}

		System.out.println((Game.getInstance()).toString());

	}

	public static void createStorm(String[] cmd) throws ParseException {
		if (cmd.length > 1) {
			Game.generateStorm(cmd[1]);
		} else {
			Game.generateStorm();
		}

		System.out.println((Game.getInstance()).toString());
	}

	public static void check(String[] cmd) throws ParseException {

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

	public static void exploreTile(String[] cmd) {

		System.out.println("Capacity: " + Game.getPlayer(cmd[1]).exploreTile(cmd[2]));

		System.out.println((Game.getInstance()).toString());
	}

	public static void move(String[] cmd) throws ParseException {

		// Ha nem eleg hosszu a parancs biztosan rossz
		if (cmd.length != 3) {
			System.out.println("Valami nem jó! A parancs kinézete: move játékosnév mezõnév ");
			return;
		}

		if (cmd[1].equals("PolarBear")) {
			Tile temp = new StableTile("");
			Tile newt = new StableTile("");
			Entity tempPol = new PolarBear("Pol1");

			for (Tile oldtile : Game.getTiles()) {
				for (Entity e : oldtile.getBears()) {
					if (e.getId().equals("Pol1")) {
						tempPol = e;
						temp = oldtile;
						break;

					}
				}
				if (!(temp.getId().equals(""))) {
					break;
				}
			}

			for (Tile newtile : Game.getTiles()) {
				if (newtile.getId().equals(cmd[2])) {
					newt = newtile;
					newtile.receive(tempPol);
					temp.remove(tempPol);
					break;

				}
			}

			for (Player p : newt.getPlayers()) {
				newt.remove(p);
				p.die();
			}
		} else {
			Tile tempTile = new StableTile("");
			Player tempPlayer = new Explorer("");

			for (Tile oldtile : Game.getTiles()) {
				for (Player p : oldtile.getPlayers()) {
					if (p.getId().equals(cmd[1])) {

						tempPlayer = p;
						tempTile = oldtile;
						break;

					}
				}
				if (!tempPlayer.getId().equals("")) {
					break;
				}
			}

			for (Tile newTile : Game.getTiles()) {
				if (newTile.getId().equals(cmd[2])) {
					tempPlayer.setCurrentTile(tempTile);
					tempPlayer.move(newTile);
					break;

				}
			}
		}

		System.out.println((Game.getInstance()).toString());
	}

	/**
	 * A dig függvény szimulálása, 2 paraméterrel rendelkezik (a cmd[1] és cmd[2]
	 * értékek: - cmd[1]: játékost azonosítja - cmd[2]: az eszközt (shovel,
	 * fragileShovel, none - hand)
	 * 
	 * @param cmd
	 * @throws ParseException
	 */
	public static void dig(String[] cmd) throws ParseException {
		boolean couldDig = false;

		if (cmd.length > 2) {
			/**
			 * Runs through the inventory of the the player if "couldDig" (so shovel or
			 * fragileShovel exists)
			 */
			if (cmd[2].equals("fragileshovel")) {
				for (int i = 0; i < Game.getPlayer(cmd[1]).getInventory().size(); i++) {
					if (Game.getPlayer(cmd[1]).getInventory().get(i).digWithFragileShovel()) {
						for (Tile t : Game.getTiles()) {
							for (Player p : t.getPlayers()) {
								if (p.getId().equals(cmd[1])) {
									t.dig(2);
									if (p.getInventory().get(i).getNumOfUses() == 0) {
										p.getInventory().remove(p.getInventory().get(i));
									}
									p.setEnergy(p.getEnergy() - 1);
									couldDig = true;
								}
							}
						}
						break;
					}
				}

			} else if (cmd[2].equals("shovel")) {
				for (int i = 0; i < Game.getPlayer(cmd[1]).getInventory().size(); i++) {
					if (Game.getPlayer(cmd[1]).getInventory().get(i).dig()) {
						for (Tile t : Game.getTiles()) {
							for (Player p : t.getPlayers()) {
								if (p.getId().equals(cmd[1])) {
									t.dig(2);
									p.setEnergy(p.getEnergy() - 1);
									couldDig = true;
								}
							}
						}
						break;
					}
				}

			}
		}

		/**
		 * Finds the player's tile and then digs with hand moves the items from the tile
		 * to the player's inventory
		 */
		if (!couldDig) {
			for (Tile t : Game.getTiles()) {
				for (Player p : t.getPlayers()) {
					if (p.getId().equals(cmd[1])) {
						t.dig(1);
						for (Item i : t.getItems()) {
							p.addToInventory(i);

						}
						t.setItems(new ArrayList<Item>());
						p.setEnergy(p.getEnergy() - 1);
						break;
					}
				}
			}
		}

		System.out.println((Game.getInstance()).toString());
	}

	public static void buildIgloo(String[] cmd) {
		boolean couldBuild = false;
		for (Tile t : Game.getTiles()) {
			for (Player p : Game.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.buildIgloo(t);
					t.setHasIgloo(true);
					couldBuild = true;
					break;
				}
			}
			if (couldBuild)
				break;
		}
		System.out.println((Game.getInstance()).toString());
	}

	public static boolean useBeacon(String[] cmd) {
		if (cmd.length != 2) {
			System.out.println("Hiba: formatumnak igy kene kineznie: " + cmd[0] + " Exp1");
			return false;
		}

		for (Item it : Game.getPlayer(cmd[1]).getInventory()) {
			if (it.useTargetItem()) {
				Game.getPlayer(cmd[1]).heal(1);
				System.out.println("Beacon succesfully used!");
				return true;
			}
		}

		System.out.println((Game.getInstance()).toString());
		return false;
	}

	public static boolean useGun(String[] cmd) {
		if (cmd.length != 2) {
			System.out.println("Hiba: formatumnak igy kene kineznie: " + cmd[0] + " Exp1");
			return false;
		}

		for (Item it : Game.getPlayer(cmd[1]).getInventory()) {
			if (it.useTargetItem()) {
				Game.getPlayer(cmd[1]).heal(1);
				System.out.println("Gun succesfully used!");
				return true;
			}
		}

		System.out.println((Game.getInstance()).toString());
		return false;
	}

	public static boolean useCartridge(String[] cmd) {
		if (cmd.length != 2) {
			System.out.println("Hiba: formatumnak igy kene kineznie: " + cmd[0] + " Exp1");
			return false;
		}

		for (Item it : Game.getPlayer(cmd[1]).getInventory()) {
			if (it.useTargetItem()) {
				Game.getPlayer(cmd[1]).heal(1);
				System.out.println("Cartridge succesfully used!");
				return true;
			}
		}

		System.out.println((Game.getInstance()).toString());
		return false;

	}

	public static boolean useRocket(String[] cmd) {
		if (cmd.length != 2) {
			System.out.println("Hiba: formatumnak igy kene kineznie: " + cmd[0] + " Exp1");
			return false;
		}
		int cnt = 0;
		for (Item it : Game.getPlayer(cmd[1]).getInventory()) {
			if (it.useTargetItem()) {
				cnt++;
			}
		}
		if (cnt > 2) {
			System.out.println("Rocket succesfully used!");
			return true;
		}

		System.out.println((Game.getInstance()).toString());
		return false;

	}

	public static void buildTent(String[] cmd) {
		boolean couldBuild = false;
		for (Tile t : Game.getTiles()) {
			for (Player p : Game.getPlayers()) {
				if (p.getId().equals(cmd[1])) {
					p.buildTent(t);
					t.setHasTent(true);
					couldBuild = true;
					break;
				}
			}
			if (couldBuild)
				break;
		}
		System.out.println((Game.getInstance()).toString());
	}

	public static void useFood(String[] cmd) {
		if (cmd.length != 2) {
			System.out.println("Hiba: formatumnak igy kene kineznie: " + cmd[0] + " Exp1");
			return;
		}

		for (Item it : Game.getPlayer(cmd[1]).getInventory()) {
			if (it.eat()) {
				Game.getPlayer(cmd[1]).heal(1);
				Game.getPlayer(cmd[1]).getInventory().remove(it);
				break;
			}
		}

		System.out.println((Game.getInstance()).toString());
	}

	public static void damage(String[] cmd) {
		if (cmd.length != 2) {
			System.out.println("Hiba: formatumnak igy kene kineznie: " + cmd[0] + " Exp1");
			return;
		}

		Game.getPlayer(cmd[1]).damage(1);
		System.out.println((Game.getInstance()).toString());
	}

	public static void setCapacity(String[] cmd) {

		if (cmd.length > 2)
			Game.getTiles().get(find(Game.getTiles(), cmd[1])).setCapacity(Integer.parseInt(cmd[2]));

		System.out.println((Game.getInstance()).toString());
	}
}
