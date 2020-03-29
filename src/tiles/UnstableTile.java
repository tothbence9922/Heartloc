package tiles;

import entity.Entity;
import entity.player.Player;

public class UnstableTile extends Tile {

	private int load;
	private int capacity;
		
	/**
	 *  A t�bla forog ha t�lterhel�dik. H�vhatja a rajta �ll� emberek Fall fgv-�t vagy valami
	 * @return
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
	 * A f�ggv�ny megadja mennyi a terhel�s.
	 * @return - A terhel�s nagys�g�val t�r vissza.
	 */
	public int getLoad() {
		System.out.println("UnstableTile\tint getLoad()\tparam: -");
		return this.load;
	}
	
	/**
	 * A f�ggv�ny megadja mennyi a kapacit�s.
	 * @return - A kapacit�s nagys�g�val t�r vissza.
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
	public Tile getNeighbours() {
		return null;
	}

	@Override
	public boolean alarmTile(Player p) {
		// TODO Auto-generated method stub
		return false;
	}
}
