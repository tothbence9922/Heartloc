package controller;

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
	
	public void setGame(String[] tokens) {
		try {
			Commands.loadMap(tokens);
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
}
