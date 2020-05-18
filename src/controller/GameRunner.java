package controller;
/**
 * 
 * @author Heartloc
 */
public class GameRunner {

	public static GameController baseGameController;
	/**
	 * main fuggveny, ahonnan a program elinditja a jatekot
	 * @param args
	 */
	public static void main(String[] args) {

		baseGameController = new GameController();
		baseGameController.start();
	}
}
