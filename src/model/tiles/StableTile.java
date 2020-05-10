package model.tiles;

/**
 * A játék során ezek a jégtáblák jelentik a biztonságot: végtelen teherbírásuk van, így bármennyi ember áll is egyszerre egy adott stabil jégtáblán, az nem fog átfordulni. Lyukak azonban lehetnek rajta!
 * @author tothbence9922
 *
 */
public class StableTile extends Tile {	
	
	
	public StableTile(String id) {
		super(id, -1);
	}
	@Override
	public void draw() {
		//draw
	}
	
}
