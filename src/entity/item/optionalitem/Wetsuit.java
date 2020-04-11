package entity.item.optionalitem;
/**
 * A Wetsuit osztály reprezentálja a játékos egy lehetséges tárgyát, mellyel képes túlélni vízbeeés után, sérülés nélkül.
 * @author tothbence9922
 *
 */
public class Wetsuit extends OptionalItem{
/**
 * A Wetsuit használata automatikus, ha a játékosnak van Wetsuitja és vízbe esik, automatikusan használja.
 * @return Visszatérési értéke a logikai Igaz (true), ezzel jelezve hogy a játékosnak van ilyen Item-e és szükség esetén sikeresen használta.
 */
  @Override
	public boolean wear() {
		System.out.println("Wetsuit\t boolean wear()\tparam: -");
		return true;
	}

}
