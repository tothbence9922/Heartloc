package model;

import java.util.ArrayList;

import entity.player.Player;

public class UnstableTile extends Tile {

	private int limit;
		
	/**
	 *  A t�bla forog ha t�lterhel�dik. H�vhatja a rajta �ll� emberek Fall fgv-�t vagy valami
	 * @return
	 */
	public boolean rotate() {
		return true;
	}
	
	public UnstableTile(int _limit) {
		limit = _limit;
		this.players = new ArrayList<Player>();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
