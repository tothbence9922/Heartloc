package model.entity.item.optionalitem;

/**
 * Az egyik opcionalis targyat, az asot (Shovel) megvalosito es reprezentalo
 * osztaly.
 */
public class Shovel extends OptionalItem {

	public Shovel(String id) {
		super(id);
	}

	/**
	 * A jatekos, ha rendelkezik Shovel-lel, hasznalhatja azt, hogy asson vele.
	 * Ezzel ket egysegnyi havat takarithat el, azonban Itemet nem vehet fel Shovel
	 * hasznalataval.
	 * 
	 * @return Visszateresi erteke a logikai Igaz (true), ezzel jelezve hogy a
	 *         jatekos sikeresen hasznalta az Aso (Shovel) Itemet.
	 */
	@Override
	public boolean dig() {
		return true;
	}

}
