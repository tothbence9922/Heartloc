package entity.player;
import tiles.Tile;

import tiles.Tile;

public class Eskimo extends Player {

	public Eskimo() {
		this.bodyTemp = 5;
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

	public void move(Tile t) {
		System.out.println("Eskimo\tvoid move(Tile)\tparam: " + t);
	}

	public int step() {
		System.out.println("Eskimo\tint step()\tparam: -");
		return 0;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
  }
 
	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}

	@Override
	public int exploreTile(Tile chosenTile) {
		return -1;
	}
}
