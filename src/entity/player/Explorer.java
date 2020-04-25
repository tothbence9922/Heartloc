package entity.player;

import tiles.Tile;

/**
 * A jatekban szereplo egyik entitas. Kezdeskent 4 egysegnyi testhoje van,
 * valamint egy kulonleges kepessege is: meg tudja nezni a legfeljebb 3
 * tavolsagra levo jegtablarol, hogy mekkora a teherbirasa. Ez fontos es hasznos
 * kepesseg, ugyanis az instabil jegtablak nagy veszelyt jelentenek.
 */
public class Explorer extends Player {

	public Explorer(String id) {
		super(id);
		this.bodyTemperature = 4;
		this.energy = 4;
	}

	/**
	 * Az ososztalybol szarmazo metodus, mely itt az Explorer kepesseget valositja
	 * meg: a jatekos poziciojatol legfeljebb 3 tavolsagra levo jegtablak kozul
	 * egyrol megallapitja a teherbirasat
	 * 
	 * @param chosenTile a kivalasztott Tile
	 * @return a Tile teherbirasa
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

	/**
	 * @return false - Explorer cannot build Igloo
	 */
	@Override
	public boolean buildIgloo(Tile chosenTile) {
		return false;
	}
}

