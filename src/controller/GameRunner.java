package controller;
/**
 * A jatek futtatasat kezdemenyezo, inicializalasban jelentos reszt vevo osztaly.
 * Az ebben definialt GameController peldany all rendelkezesre a legtobb jatekban talalhato elemnek controllerkent.
 * @author tothbence9922
 *
 */
public class GameRunner {

	public static GameController baseGameController;

	/**
	 * Az egesz applikacio belepesi pontja. Definial egy controllert, majd kezdemenyezi a jatek inditasat.
	 * @param args Standart argumentum a main fuggvenynek.
	 */
	public static void main(String[] args) {

		baseGameController = new GameController();
		baseGameController.start();
	}
}
