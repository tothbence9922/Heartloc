package entity.player;

import tiles.Tile;

/**
 * A játékban szereplõ egyik entitás. Kezdésként 4 egységnyi testhõje van,
 * valamint egy különleges képessége is: meg tudja nézni a legfeljebb 3
 * távolságra lévõ jégtábláról, hogy mekkora a teherbírása. Ez fontos és hasznos
 * képesség, ugyanis az instabil jégtáblák nagy veszélyt jelentenek.
 */
public class Explorer extends Player {

	public Explorer(String id) {
		super(id);
		this.bodyTemperature = 4;
		this.energy = 4;
	}

	/**
	 * Az õsosztályból származó metódus, mely itt az Explorer képességét valósítja
	 * meg: a játékos pozíciójától legfeljebb 3 távolságra lévõ jégtáblák közül
	 * egyrõl megállapítja a teherbírását
	 * 
	 * @param chosenTile a kiválasztott Tile
	 * @return a Tile teherbírása
	 */
	@Override
	public int exploreTile(Tile chosenTile) {
		System.out.println("Explorer\tint ExploreTile()\tparam: " + chosenTile);
		return 5;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}
