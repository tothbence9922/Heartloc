package tiles;

/**
 * A játék során ezek a jégtáblák jelentik a legtöbb veszélyt: lyukak is
 * lehetnek rajta, valamint a stabil jégtáblákkal ellentétben, az instabil
 * jégtábláknak van egy maximális teherbírásuk (kapacitás), melyet ha a rajtuk
 * lévõ entitások összsúlya meghalad, akkor átfordulnak, ezáltal minden rajtuk
 * található dolog a vízbe esik.
 * 
 * @author tothbence9922 & komendamate
 *
 */
public class UnstableTile extends Tile {


	/**
	 * Az UnstableTile konstruktora. A Paraméterül kapott érték lesz a maximális
	 * érték, amit túllépve az UnstableTile átfordul.
	 * 
	 * @param l
	 */
	public UnstableTile(String id, int l) {
		super(id, l);
	}

	/**
	 * visszatér az adott instabil jégtábla maximális teherbírásával, kapacitásával.
	 * 
	 * @return int
	 */
	public int getCapacity() {
		return this.capacity;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}
