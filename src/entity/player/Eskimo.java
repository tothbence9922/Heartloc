package entity.player;
import tiles.Tile;

public class Eskimo extends Player {

	public Eskimo() {
		this.bodyTemp = 5;
		this.energy = 4;
	}
	/**
	 * bool buildIgloo(Tile chosenTile): Az �soszt�lyb�l sz�rmaz� met�dus, mely
	 * itt az Eszkim� k�pess�g�t val�s�tja meg: �p�t egy iglut arra a j�gt�bl�ra, ahol
	 * az Eszkim� �ll.
	 * @param t - Az a Tile ami �ll az Eszkim�
	 * @return - A sikeresen fel�p�tett Iglu eset�n true, ellenkez� esetben false.
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
