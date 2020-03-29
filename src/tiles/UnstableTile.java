package tiles;

import java.util.ArrayList;

import entity.player.Player;

public class UnstableTile extends Tile {

	private int load;
		
	/**
	 *  A tábla forog ha túlterhelõdik. Hívhatja a rajta álló emberek Fall fgv-ét vagy valami
	 * @return Ha sikeresen átfordult true érékkel tér vissza, ha nem akkor false-al.
	 */
	public boolean rotate() {
		return true;
	}
	
	public UnstableTile(int _load) {
		load = _load;
		this.players = new ArrayList<Player>();
	}
	/**
	 * A függvény megadja mennyi a terhelés.
	 * @return - A terhelés nagyságával tér vissza.
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
