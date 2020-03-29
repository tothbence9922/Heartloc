package model;

public class Game {
	/**
	 *  A játék megnyerésekor meghívódó metódus, magával vonzza
	 *	az EndGame() metódus meghívását, ekkor a játékos gyõzelmét könyvelhetjük
	 *	el.
	 */
	public void victory(){
		System.out.println("Game\tvoid victory()\tparam: -");
	}
	/**
	 *  A játék végekor meghívódó metódus, mellyel
	 *  véglegesíthetjük a játék állását és lezárhatjuk a játékot.
	 */
	public void EndGame() {
		System.out.println("Game\tvoid EndGame()\tparam: -");
	}
}
