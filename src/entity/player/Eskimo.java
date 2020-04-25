package entity.player;

import entity.Igloo;
import tiles.Tile;

/**
 * A j�t�kban szerepl� egyik entit�s. Kezd�sk�nt 5 egys�gnyi testh�je van,
 * valamint egy k�l�nleges k�pess�ge is: tud iglut �p�teni, amiben megb�jva a
 * h�vihar nem tesz k�rt benn�k.
 */
public class Eskimo extends Player {

	public Eskimo(String id) {
		super(id);
		this.bodyTemperature = 5;
		this.energy = 4;
	}

	/**
	 * bool buildIgloo(Tile chosenTile): Az ősosztályból származó metódus,
	 * mely itt az Eszkimó képességét valósítja meg: épít egy iglut arra a
	 * jégtáblára, ahol az Eszkimó áll.
	 * 
	 * @param t - Az a Tile ami áll az Eszkimó
	 * @return - A sikeresen felépített Iglu esetén true, ellenkező esetben
	 *         false.
	 */
	@Override
	public boolean buildIgloo(Tile chosenTile) {
		/*if (energy > 0) {
			Igloo igloo = new Igloo(chosenTile);
			if (chosenTile.getCapacity() < chosenTile.load()) {
				for (int i = 0; i < chosenTile.getPlayers().length; i++) {
					chosenTile.getPlayers().at(i).pushToWater();
				}
			}
			return true;
		}*/
		return false;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}

	@Override
	public int exploreTile(Tile chosenTile) {
		// TODO Auto-generated method stub
		return 0;
	}
}
