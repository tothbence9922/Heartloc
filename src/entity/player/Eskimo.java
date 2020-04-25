package entity.player;

import entity.Igloo;
import tiles.Tile;

/**
 * A játékban szereplõ egyik entitás. Kezdésként 5 egységnyi testhõje van,
 * valamint egy különleges képessége is: tud iglut építeni, amiben megbújva a
 * hóvihar nem tesz kárt bennük.
 */
public class Eskimo extends Player {

	public Eskimo(String id) {
		super(id);
		this.bodyTemperature = 5;
		this.energy = 4;
	}

	/**
	 * bool buildIgloo(Tile chosenTile): Az Å‘sosztÃ¡lybÃ³l szÃ¡rmazÃ³ metÃ³dus,
	 * mely itt az EszkimÃ³ kÃ©pessÃ©gÃ©t valÃ³sÃ­tja meg: Ã©pÃ­t egy iglut arra a
	 * jÃ©gtÃ¡blÃ¡ra, ahol az EszkimÃ³ Ã¡ll.
	 * 
	 * @param t - Az a Tile ami Ã¡ll az EszkimÃ³
	 * @return - A sikeresen felÃ©pÃ­tett Iglu esetÃ©n true, ellenkezÅ‘ esetben
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
