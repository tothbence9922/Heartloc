package model;

import java.util.ArrayList;

public class InstabileTile extends Tile {

	private int limit;
		
	/**
	 *  A t�bla forog ha t�lterhel�dik. H�vhatja a rajta �ll� emberek Fall fgv-�t vagy valami
	 * @return
	 */
	public boolean rotate() {
		return true;
	}
	
	public InstabileTile(int _limit) {
		limit = _limit;
		this.players = new ArrayList<Player>();
	}
}
