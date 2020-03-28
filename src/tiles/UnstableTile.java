package tiles;

import java.util.ArrayList;

import entity.player.Player;

public class UnstableTile extends Tile {

	private int load;
		
	/**
	 *  A t�bla forog ha t�lterhel�dik. H�vhatja a rajta �ll� emberek Fall fgv-�t vagy valami
	 * @return Ha sikeresen �tfordult true �r�kkel t�r vissza, ha nem akkor false-al.
	 */
	public boolean rotate() {
		return true;
	}
	
	public UnstableTile(int _load) {
		load = _load;
		this.players = new ArrayList<Player>();
	}
	/**
	 * A f�ggv�ny megadja mennyi a terhel�s.
	 * @return - A terhel�s nagys�g�val t�r vissza.
	 */
	public int getLoad() {
		System.out.println("UnstableTile\tint getLoad()\tparam: -");
		return this.load;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
