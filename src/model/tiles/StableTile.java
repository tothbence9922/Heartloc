package model.tiles;

import view.tiles.StableTileView;

/**
 * A játék során ezek a jégtáblák jelentik a biztonságot: végtelen teherbírásuk van, így bármennyi ember áll is egyszerre egy adott stabil jégtáblán, az nem fog átfordulni. Lyukak azonban lehetnek rajta!
 * @author tothbence9922
 *
 */
public class StableTile extends Tile {	
	
	public StableTileView view;
	public StableTile(String id) {
		super(id, -1);
	}
	@Override
	public void draw() {
		//draw
	}
	
}
