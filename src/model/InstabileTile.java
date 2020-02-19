package model;

import java.util.ArrayList;

public class InstabileTile extends Tile {

	private int limit;
		
	/**
	 *  A tábla forog ha túlterhelõdik. Hívhatja a rajta álló emberek Fall fgv-ét vagy valami
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
