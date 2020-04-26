package entity.player;

import tiles.Tile;

/**
 * A jatekban szereplo egyik entitas. Kezdeskent 5 egysegnyi testhoje van,
 * valamint egy kulonleges kepessege is: tud iglut epíteni, amiben megbujva a
 * hovihar nem tesz kart bennuk.
 */
public class Eskimo extends Player {

	public Eskimo(String id) {
		super(id);
		this.bodyTemperature = 5;
		this.energy = 4;
	}

	/**
	 * bool buildIgloo(Tile chosenTile): Az ososztalybol szarmazo metodus,
	 * mely itt az Eszkimo kepesseget valosetja meg: epet egy iglut arra a
	 * jegtablara, ahol az Eszkimo all.
	 * 
	 * @param t - az a Tile ami all az Eszkimo
	 * @return sikeresen felepetett Iglu eseten true, ellenkezo esetben false.
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

	/**
	 * @return false - Eskimo cannot explore Tile
	 */
	@Override
	public int exploreTile(Tile chosenTile) {
		return -2;
	}
}
