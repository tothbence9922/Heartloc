package tiles;

public class UnstableTile extends Tile {

	private int load;
	
	public UnstableTile(int l) {
		load = l;
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
}
