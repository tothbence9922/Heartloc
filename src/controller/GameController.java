package controller;

import javax.swing.JPanel;

import model.Commands;
import model.Game;
import model.org.json.simple.parser.ParseException;
import view.ApplicationFrame;

/**
 * Handle communication between model and view
 *
 */
public class GameController {
	private ApplicationFrame applicationFrame;
	private Game game;

	public Game getGame() {
		return game;
	}

	public void setGame(String[] tokens, int eskNum, int expNum) {
		try {
			Commands.loadMap(tokens, eskNum, expNum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
}
