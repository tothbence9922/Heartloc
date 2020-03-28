package entity.player;
import tiles.Tile;

public class Eskimo extends Player {

	public Eskimo() {
		this.bodyTemp = 5;
		this.energy = 4;
	}
	/**
	 * bool buildIgloo(Tile chosenTile): Az õsosztályból származó metódus, mely
	 * itt az Eszkimó képességét valósítja meg: épít egy iglut arra a jégtáblára, ahol
	 * az Eszkimó áll.
	 * @param t - Az a Tile ami áll az Eszkimó
	 * @return - A sikeresen felépített Iglu esetén true, ellenkezõ esetben false.
	 */
	public boolean buildIgloo(Tile t) {
		System.out.println("Eskimo\tvoid build()\tparam: Tile");
		return false;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
