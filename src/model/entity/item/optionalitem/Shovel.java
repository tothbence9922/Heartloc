package model.entity.item.optionalitem;

/**
 * Az egyik opcionális tárgyat, az ásót (Shovel) megvalósító és reprezentáló
 * osztály.
 */
public class Shovel extends OptionalItem {
	
	public Shovel(String id) {
		super(id);
	}

	/**
	 * A játékos, ha rendelkezik Shovel-lel, használhatja azt, hogy ásson vele.
	 * Ezzel két egységnyi havat takaríthat el, azonban Itemet nem vehet fel Shovel
	 * használatával.
	 * 
	 * @return Visszatérési értéke a logikai Igaz (true), ezzel jelezve hogy a
	 *         játékos sikeresen használta az Ásó (Shovel) Itemet.
	 */
	@Override
	public boolean dig() {
		return true;
	}

}
