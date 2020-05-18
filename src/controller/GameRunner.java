package controller;
/**
 * 
 * @author Heartloc
 */
public class GameRunner {

	public static GameController baseGameController;
	/**
	 * A jatek belepesi pontja
	 * @param args
	 */
	public static void main(String[] args) {

		baseGameController = new GameController();
		baseGameController.start();
	}
}
