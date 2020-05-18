package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Game;
import model.MapLoader;
import model.org.json.simple.JSONObject;
import model.org.json.simple.parser.JSONParser;
import model.org.json.simple.parser.ParseException;
import view.ApplicationFrame;

/**
 * Az MVC felepites Control elemet megvalosito, a jatekos szamara
 * interfeszt biztosito osztaly. Felelossege kimerul a jatek letrehozasaban,
 * mely alatt inicialja is azt, igy biztositva a modell es view kozti kommunikaciot.
 */
public class GameController {

	public static String currentMap = "";

	private ApplicationFrame applicationFrame;
	private Game game;

	public Game getGame() {
		return game;
	}
	
	/**
	 * A jatek inicializalasahoz szukseges metodus.
	 * Parametereiben megkapja a szukseges adatokat, melyet ellenorizve megprobal egy palyat betolteni.
	 * @param tokens A jatek menujebol kapott string tomb, mely tartalmazza a palya kivalasztasahoz szukseges adatokat.
	 * @param eskNum A jatek menujebol kapott egesz szam (integer), mely meghatarozza hany darab Eskimot kell a jatekba helyezni.
	 * @param expNum A jatek menujebol kapott egesz szam (integer), mely meghatarozza hany darab Explorer kell a jatekba helyezni.
	 * @return A betoltes sikeresseget jelzo boolean valtozo.
	 */
	public boolean setGame(String[] tokens, int eskNum, int expNum) {
		try {
			return loadMap(tokens, eskNum, expNum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Alapveto getter metodus az alkalmazas ablakara hivatkozo ApplicationFrame valtozora
	 * @return Az alkalmazas ablakat tarolo ApplicationFrame valtozo
	 */
	public ApplicationFrame getGameFrame() {
		return applicationFrame;
	}
	
	/**
	 * A Singleton tervezesi mintaban ezen keresztul erhetjuk el az osztaly egyetlen peldanyat
	 */
	public GameController() {
		game = Game.getInstance(this);
	}

	/**
	 * A jatekot elindito metodus. Mivel az egyes feluletek inicializalasra kerultek, nincs szukseg visszateresi ertekre,
	 * minden szepen zajlik tovabb.
	 */
	public void start() {
		applicationFrame = new ApplicationFrame(this);
	}

	/**
	 * A jatek lezarasat vegzo metodus. Megjeleniti a mar inicializalt 'vegso' kepernyot, mely tajekoztatja a jatekosokat
	 * arrol, hogy nyertek, vagy vesztettek.
	 * @param end A gyozelem vagy vereseg tenye altal meghatarozott panel kerul
	 * a jatekos szeme ele, ezt kapja meg a metodus egyetlen parametereben.
	 */
	public void EndGame(JPanel end) {
		this.applicationFrame.changePanel(end);
	}
	
	/**
	 * A jatek palyajat inicializalo metodus. Parametereiben megkapja a szukseges adatokat.
	 * @param cmd
	 * @param eskNum
	 * @param expNum
	 * @return Visszateresi erteke megadja hogy sikeres volt-e a betoltes; ez alapjan az
	 * ezt a metodust hivo fuggveny vagy elinditja a jatekot, vagy tovabb var megfelelo parameterekre es event-re.
	 * @throws ParseException Amennyiben invalid inputot kap, jellemzoen a cmd parametereben, ilyen tipusu kivetelt dob, mivel nem fog tudni int-et parse-olni.
	 */
	public static boolean loadMap(String[] cmd, int eskNum, int expNum) throws ParseException {
		String[] maps = { "map1", "map2", "map3", "map4", "map5" };

		if (cmd.length > 1) {
			try {
				if (Arrays.asList(maps).contains(cmd[1])) {
					createCurrentMap(cmd[1]);
					currentMap = cmd[1];

					// relative to root: ./folderName
					MapLoader.readMapFromJSON("./assets/maps/" + cmd[1] + ".json", eskNum, expNum);
					return true;
				} else {
					JOptionPane.showMessageDialog(GameRunner.baseGameController.getGameFrame(),
							"There is no such map!", "", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * A palya letrehozasaban kozrejatszo metodus.
	 * @param path A palya eleresi utvonalat meghatarozo string, mely helyes hasznalat eseten egy szam betukkel, helyes intervallumon belul.
	 * @return Visszateresi erteke megadja, hogy sikeres volt-e az adatok adott utvonalrol valo beolvasasa.
	 * @throws FileNotFoundException Helytelen eleresi utvonal eseten sikertelen lesz a fajlkezeles. Ekkor keletkezik ez a kivetel.
	 * @throws IOException Helytelen eleresi utvonal eseten sikertelen lesz a fajlkezeles. Ekkor keletkezik ez a kivetel.
	 * @throws ParseException Helytelen bemeneti string eseten sikertelen lesz a szam (integer) kesobbi keresese. Ekkor keletkezik ez a kivetel.
	 */
	public static boolean createCurrentMap(String path) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader("./assets/maps/" + path + ".json"));

		PrintWriter pw = new PrintWriter("./assets/maps/temp.json");
		pw.write(obj.toJSONString());
		pw.flush();
		pw.close();

		return false;
	}
}
