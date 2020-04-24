package entity.player;

import tiles.Tile;

/**
 * A j�t�kban szerepl� egyik entit�s. Kezd�sk�nt 4 egys�gnyi testh�je van,
 * valamint egy k�l�nleges k�pess�ge is: meg tudja n�zni a legfeljebb 3
 * t�vols�gra l�v� j�gt�bl�r�l, hogy mekkora a teherb�r�sa. Ez fontos �s hasznos
 * k�pess�g, ugyanis az instabil j�gt�bl�k nagy vesz�lyt jelentenek.
 */
public class Explorer extends Player {

	public Explorer(String id) {
		super(id);
		this.bodyTemperature = 4;
		this.energy = 4;
	}

	/**
	 * Az �soszt�lyb�l sz�rmaz� met�dus, mely itt az Explorer k�pess�g�t val�s�tja
	 * meg: a j�t�kos poz�ci�j�t�l legfeljebb 3 t�vols�gra l�v� j�gt�bl�k k�z�l
	 * egyr�l meg�llap�tja a teherb�r�s�t
	 * 
	 * @param chosenTile a kiv�lasztott Tile
	 * @return a Tile teherb�r�sa
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
