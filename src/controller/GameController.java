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
 * Handle communication between model and view
 *
 */
public class GameController {

	public static String currentMap = "";

	private ApplicationFrame applicationFrame;
	private Game game;

	public Game getGame() {
		return game;
	}

	public boolean setGame(String[] tokens, int eskNum, int expNum) {
		try {
			return loadMap(tokens, eskNum, expNum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ApplicationFrame getGameFrame() {
		return applicationFrame;
	}

	public GameController() {
		game = Game.getInstance(this);
	}

	public void start() {
		applicationFrame = new ApplicationFrame(this);
	}

	public void EndGame(JPanel end) {
		this.applicationFrame.changePanel(end);
	}

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
