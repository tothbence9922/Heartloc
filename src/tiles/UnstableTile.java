package tiles;

import entity.Entity;
import entity.player.Player;

public class UnstableTile extends Tile {

	private int load;
	private int capacity;
	private boolean showCapacity;

		
	/**
	 *  A tábla forog ha túlterhelõdik. Hívhatja a rajta álló emberek Fall fgv-ét vagy valami
	 * @return Ha sikeresen átfordult true érékkel tér vissza, ha nem akkor false-al.
	 */
	public boolean rotate() {
		return true;
	}
	
	public UnstableTile(int l) {
		load = l;
	}
	
	public void dig(int i) {
		System.out.println("UnstableTile\tvoid dig(int)\tparam: " + i );
		
	}
	
	public boolean receive(Entity e) {
		System.out.println("UnstableTile\tboolean receive(Entity)\tparam: " + e);
		return true;
	}
	
	public boolean remove(Entity e) {
		System.out.println("UnstableTile\tboolean remove(Entity)\tparam: " + e);
		return true;
	}
	
	public void removeSnow(int i) {
		System.out.println("UnstableTile\tvoid removeSnow(int)\tparam:" + i);
	}
	
	/**
	 * A függvény megadja mennyi a terhelés.
	 * @return - A terhelés nagyságával tér vissza.
	 */
	public int getLoad() {
		System.out.println("UnstableTile\tint getLoad()\tparam: -");
		return this.load;
	}
	
	/**
	 * A függvény megadja mennyi a kapacitás.
	 * @return - A kapacitás nagyságával tér vissza.
	 */
	public int getCapacity() {
		System.out.println("UnstableTile\tint getCapacity()\tparam: -");
		return this.capacity;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
    
	@Override
	public boolean getHasHole() {
		System.out.println("UnstableTile\tboolean getHasHole()\tparam: -");
		return true;
	}

	@Override
	public boolean alarmTile(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCapacityVisible(boolean b) {
		System.out.println("StableTile\t void setCapacityVisible(boolean)\tparam: -" + b);
		this.showCapacity = b;
	}
}
