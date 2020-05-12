package controller;

import model.GameFactory;
import model.org.json.simple.parser.ParseException;
import model.temp.Commands;
import view.GameFrame;

/**
 * Handle communication between model and view
 *
 */
public class GameController {
	private GameFrame gameFrame;
	private GameFactory gameFactory;
	
	public GameFactory getGameFactory() {
		return gameFactory;
	}
	
	public void setGameFactory(String[] tokens) {
		try {
			Commands.loadMap(tokens);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public GameFrame getGameFrame() {
		return gameFrame;
	}
	
	public GameController() {
		gameFactory = new GameFactory();
	}
	
	public void start() {
		gameFrame = new GameFrame(this);
	}
}
