package entity.player;
import tiles.Tile;

import tiles.Tile;

public class Eskimo extends Player {

	public Eskimo() {
		this.bodyTemperature = 5;
		this.energy = 4;
	}
	
	/**
	 * bool buildIgloo(Tile chosenTile): Az ősosztályból származó metódus, mely
	 * itt az Eszkimó képességét valósítja meg: épít egy iglut arra a jégtáblára, ahol
	 * az Eszkimó áll.
	 * @param t - Az a Tile ami áll az Eszkimó
	 * @return - A sikeresen felépített Iglu esetén true, ellenkező esetben false.
	 */
	public boolean buildIgloo(Tile chosenTile) {
		System.out.println("Eskimo\tvoid build()\tparam: " + chosenTile);
		return false;
	}
 
	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}
}
