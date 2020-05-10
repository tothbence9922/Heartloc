package model.tiles;

/**
 * A j�t�k sor�n ezek a j�gt�bl�k jelentik a biztons�got: v�gtelen teherb�r�suk van, �gy b�rmennyi ember �ll is egyszerre egy adott stabil j�gt�bl�n, az nem fog �tfordulni. Lyukak azonban lehetnek rajta!
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
