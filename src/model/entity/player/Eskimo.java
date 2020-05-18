package model.entity.player;

import controller.GameRunner;
import model.Drawable;
import model.Game;
import model.entity.Igloo;
import model.entity.Tent;
import model.tiles.Tile;
import view.entity.EskimoView;

/**
 * A jatekban szereplo egyik entitas. Kezdeskent 5 egysegnyi testhoje van,
 * valamint egy kulonleges kepessege is: tud iglut epíteni, amiben megbujva a
 * hovihar nem tesz kart bennuk.
 */
public class Eskimo extends Player implements Drawable {

	public Eskimo(String id) {
		super(id);
		this.bodyTemperature = 5;
		this.energy = 4;
		view = new EskimoView(GameRunner.baseGameController);
		view.setLayout(null);

	}

	/**
	 * Az ososztalybol szarmazo metodus, mely itt az Eszkimo kepesseget valositja
	 * meg: epit egy iglut arra a jegtablara, ahol az Eszkimo all.
	 * 
	 * @param t - az a Tile ami all az Eszkimo.
	 * @return sikeresen felepetett Iglu eseten true, ellenkezo esetben false.
	 */
	@Override
	public boolean buildIgloo() {
		if (energy > 0) {
			currentTile.addIgloo(new Igloo("Igl " + Game.getBuildings().size()));
			if (currentTile.getCapacity() == -1) {
				energy--;
				return true;
			}
			if (currentTile.getCapacity() < currentTile.getLoad()) {
				for (int i = 0; i < currentTile.getPlayers().size(); i++) {
					currentTile.getPlayers().get(i).pushToWater();
				}
			}
			energy--;
			return true;
		}
		return false;

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}
}
