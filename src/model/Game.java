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

	public static String playerID = "default";
	public static String firstPlayerID = "default";

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

	/**
	 * A metodusnak a palya inicializasakor van szerepe. Esetleges masodik betolteskor
	 * kiuritjuk a memoriaban tarolt adatokat
	 */
	public void ClearMap() {
		tiles = new ArrayList<Tile>();
		players = new ArrayList<Player>();
		items = new ArrayList<Item>();
		bears = new ArrayList<PolarBear>();
		buildings = new ArrayList<Building>();
	}

	/**
	 * A jatek megnyeresekor meghivodo metodus, magaval vonzza az EndGame() metodus
	 * meghivasat, ekkor a jatekos gyozelmet konyvelhetjuk el.
	 */
	public static void victory() {
		boolean losestate = false;
		EndGame(losestate, "Congratulations!");
	}

	/**
	 * A jatek vegekor meghivodo metodus, mellyel veglegesithetjuk a jatek allasat
	 * es lezarhatjuk a jatekot.
	 */
	public static void EndGame(boolean losestate, String msg) {
		view.EndGame(losestate, msg);
	}
	
	/**
	 * Vihart general a jatekban, ha a jatekosok nem tartozkodnak valamilyen epitmenyben
	 * lemegy egy eletuk. Emellett a vihar random tileokon havat general.
	 * 
	 */

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
					}
				}
			}
			if (Math.random() % 2 == 0) {
				t.addSnow(1);
			}
		}
		Game.view.updatePanel();

	}
	
	/**
	 * A metodus hivasakor megkapjuk a jatekban tartozkodo PolarBear-eket
	 * @return ArrayList<PolarBear>
	 */

	public static ArrayList<PolarBear> getPolarBears() {
		return bears;
	}

	/**
	 * A metodus a jatekhoz hozza ad egy Building-et, amit parameterben kap meg
	 * @param b
	 */
	public static void addBuilding(Building b) {
		buildings.add(b);
	}

	/**
	 * A metodus a jatekhoz hozza ad egy PolarBear-t, amit parameterben kap meg
	 * @param b
	 */
	public static void addPolarBear(PolarBear pb) {
		Game.bears.add(pb);
	}


	/**
	 * A metodus segitsegevel megkapjuk a jatekban levo Tile-okat
	 * @return ArrayList<Tile>
	 */

	public static ArrayList<Tile> getTiles() {
		return Game.tiles;
	}

	/**
	 * A metodus kap parameterkent egy ArrayList<Tile>-et, majd ezekre modositja
	 * a jatekban levo Tile-okat
	 * @param tilesArr
	 */
	public static void setTiles(ArrayList<Tile> tilesArr) {
		for (int i = 0; i < tilesArr.size(); i++)
			Game.tiles.add(tilesArr.get(i));
	}

	/**
	 * A metodus kap egy String id parametert, amit osszehasonlit az osszes Tile 
	 * id-javal, ha egyezest talal, visszater azzal a Tile-al, ahol az id egyezett
	 * @param id
	 * @return t vagy null ha nem talaltuk meg a keresett Tile-t
	 */
	public static Tile getTile(String id) {
		for (Tile t : tiles) {
			if (t.getId().equals(id))
				return t;
		}

		return null;
	}

	/**
	 * A metodus kap egy String id parametert, amit osszehasonlit az osszes Player 
	 * id-javal, ha egyezest talal, visszater azzal a Player-el, ahol az id egyezett
	 * @param id
	 * @return p vagy null ha nem talaltuk meg a keresett Playert
	 */
	public static Player getPlayer(String id) {
		for (Player p : players) {
			if (p.getId().equals(id))
				return p;
		}

		return null;
	}

	/**
	 * A metodus segitsegevel megkapjuk a jatekban levo jatekosokat(Player)
	 * @return ArrayList<Player>
	 */
	public static ArrayList<Player> getPlayers() {
		return players;
	}
	
	/**
	 * A metodus segitsegevel megkapjuk a jatekban levo epuleteket(Building)
	 * @return ArrayList<Building>
	 */
	public static ArrayList<Building> getBuildings() {
		return buildings;
	}

	/**
	 * A metodus kap parameterkent egy ArrayList<Player>-et, majd ezekre modositja
	 * a jatekban levo jatekosokat
	 * @param players
	 */
	public static void setPlayers(ArrayList<Player> players) {
		Game.players = players;
	}

	/**
	 * A metodus hozza ad egy parameterben kapott e jatekost a players ArrayList-hez
	 * @param e
	 */
	public static void addPlayer(Player e) {
		Game.players.add(e);
	}

	/**
	 * A metodus kap parameterkent egy ArrayList<Item>-et, majd ezekre modositja
	 * a jatekban levo Item-eket
	 * @param itemsArr
	 */
	public static void setItems(ArrayList<Item> itemsArr) {
		for (int i = 0; i < itemsArr.size(); i++)
			Game.items.add(itemsArr.get(i));
	}
	
	/**
	 * A metodus kap egy String id parametert, amit osszehasonlit az osszes Item
	 * id-javal, ha egyezest talal, visszater azzal az Item-el, ahol az id egyezett
	 * @param id
	 * @return i.getId() vagy ures String ha nem talaltuk meg a keresett Itemet
	 */

	public static String getItem(String id) {
		for (Item i : items) {
			if (i.getId().equals(id))
				return i.getId();
		}

		return "";
	}
	
	/**
	 * A metodus segitsegevel megkapjuk a jatekban levo Item-eket
	 * @return ArrayList<Item>
	 */

	public static ArrayList<Item> getItems() {
		return items;
	}
	
	/**
	 * A metodus hozza ad egy parameterben kapott item Item-et az items	 ArrayList-hez
	 * @param item
	 */

	public static void addItem(Item item) {
		Game.items.add(item);
	}

	/**
	 * A mteodus egy adott jatekos ID-jat adja meg
	 * @return String
	 */
	public static String getPlayerID() {
		return playerID;
	}

	/**
	 * A metodus az adott jatekos ID-jat a modositja a parameterben megkapott ID-ra
	 * @param playerID
	 */
	public static void setPlayerID(String playerID) {
		Game.playerID = playerID;
	}

	/**
	 * A jatek minden korenek elejen meghivodo metodus. 
	 */
	public static void nextRound() {
		for (PolarBear pb : bears)
			pb.step();
		generateStorm();
		for (Player p : players)
			p.setEnergy(5);
		for (Building b : buildings)
			b.step();
		view.updatePanel();
	}

	/**
	 * A Player die metodusanak meghivasakor automatikusan hivodik meg a Defeat metodus
	 * ami jatek veget jelenti.
	 * @param msg
	 */
	public static void Defeat(String msg) {
		boolean losestate = true;
		EndGame(losestate, msg);
	}
	
	/**
	 * A metodus visszater a jatekinicializalasa soran letrehozott elso 
	 * jatekosanak ID-javal. Igy tudjuk, ha a jatekos ujra sorra kerul lement egy kor.
	 * @return String
	 */
	public static String getFirstPlayerID() {
		return firstPlayerID;
	}
	
	
	/**
	 * A metodus megkapja egy jatekos ID-jat parameterkent, majd 
	 * ot allitja "elso jatekosnak"
	 * @param firstPlayerID
	 */
	public static void setFirstPlayerID(String firstPlayerID) {
		Game.firstPlayerID = firstPlayerID;
	}
	
	/**
	 * A metodus megadj az eppen cselekvo jatekost
	 * @return Player
	 */
	public Player getCurrentPlayer() {
		return (getPlayer(playerID));
	}
}
