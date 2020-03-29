package entity.item.optionalitem;
/**
 * Az egyik opcionális tárgyat, az ásót (Shovel) megvalósító és reprezentáló osztály.
 * @author tothbence9922
 *
 */
public class Shovel extends OptionalItem{
	/**
	 * A játékos, ha rendelkezik Shovel-lel, használhatja azt, hogy ásson vele. Ezzel két egységnyi havat takaríthat el, azonban Itemet nem vehet fel Shovel használatával.
	 * @return Visszatérési értéke a logikai Igaz (true), ezzel jelezve hogy a játékos sikeresen használta  az Ásó (Shovel) Itemet.
	 */
	@Override
	public boolean dig() {
		System.out.println("Shovel\tboolean dig()\tparam: -");
		return true;
	}
	
}
