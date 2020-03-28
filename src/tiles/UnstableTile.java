package tiles;

import java.util.ArrayList;

import entity.player.Player;

public class UnstableTile extends Tile {

	private int load;
		
	/**
	 *  A t�bla forog ha t�lterhel�dik. H�vhatja a rajta �ll� emberek Fall fgv-�t vagy valami
	 * @return
	 */
	public boolean rotate() {
		return true;
	}
	
	public UnstableTile(int _load) {
		load = _load;
		this.players = new ArrayList<Player>();
	}
	public int getLoad() {
		System.out.println("UnstableTile\tint getLoad()\tparam: -");
		return this.load;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
