package controller;

public class GameRunner {
	
	public static GameController baseGameController;
	
	public static void main(String[] args) {
		
		baseGameController = new GameController();
		baseGameController.start();
	}
}
