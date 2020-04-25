package entity.player;

import tiles.Tile;

/**
 * A játékban szereplő egyik entitás. Kezdésként 4 egységnyi testhője van,
 * valamint egy különleges képessége is: meg tudja nézni a legfeljebb 3
 * távolságra lévő jégtábláról, hogy mekkora a teherbírása. Ez fontos és hasznos
 * képesség, ugyanis az instabil jégtáblák nagy veszélyt jelentenek.
 */
public class Explorer extends Player {

	public Explorer(String id) {
		super(id);
		this.bodyTemperature = 4;
		this.energy = 4;
	}

	/**
	 * Az ősosztályból származó metódus, mely itt az Explorer képességét valósítja
	 * meg: a játékos pozíciójától legfeljebb 3 távolságra lévő jégtáblák közül
	 * egyről megállapítja a teherbírását
	 * 
	 * @param chosenTile a kiválasztott Tile
	 * @return a Tile teherbírása
	 */
	@Override
	public int exploreTile(Tile chosenTile) {
		if (chosenTile.getDistance() <= 3) {
			return chosenTile.getCapacity();
		}
		return 0;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean buildIgloo(Tile chosenTile) {
		// TODO Auto-generated method stub
		return false;
	}
}

