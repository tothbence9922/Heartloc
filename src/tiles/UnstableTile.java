package tiles;
/**
 * A j�t�k sor�n ezek a j�gt�bl�k jelentik a legt�bb vesz�lyt: lyukak is lehetnek rajta, valamint a stabil j�gt�bl�kkal ellent�tben, az instabil j�gt�bl�knak van egy maxim�lis teherb�r�suk (kapacit�s), melyet ha a rajtuk l�v� entit�sok �sszs�lya meghalad, akkor �tfordulnak, ez�ltal minden rajtuk tal�lhat� dolog a v�zbe esik.
 * @author tothbence9922 & komendamate
 *
 */
public class UnstableTile extends Tile {

	private int load;
	/**
	 * Az UnstableTile konstruktora. A Param�ter�l kapott �rt�k lesz a maxim�lis �rt�k, amit t�ll�pve az UnstableTile �tfordul.
	 * @param l
	 */
	public UnstableTile(String id, int l) {
		super(id);
		load = l;
	}
	
	/**
	 *visszat�r az adott instabil j�gt�bla aktu�lis terh�vel.
	 *@return int
	 */
	public int getLoad() {
		System.out.println("UnstableTile\tint getLoad()\tparam: -");
		return this.load;
	}
	
	/**
	 *visszat�r az adott instabil j�gt�bla maxim�lis
	 *teherb�r�s�val, kapacit�s�val.
	 *@return int
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
