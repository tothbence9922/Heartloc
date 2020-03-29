package entity.item.optionalitem;
/**
 * A játékosok számára lehetõséget nyújt testhõmérsékletük növelésére, ha esznek valamit. Ez a valami az étel - Food, melyet ez az osztály reprezentál.
 * @author tothbence9922
 *
 */
public class Food extends OptionalItem {
	/**
	 * A játékos, ha rendelkezik Food -dal, használhatja azt, hogy növelje testhõmérsékletét (bodyTemperature). Az étel  (Food) eltûnik a játékos táskájából használat után.
	 * @return A visszatérési értéke a logikai igaz (true), ezzel jelzi hogy sikeresen használta a Food Itemet a játékos.
	 */
	@Override
	public boolean eat() {
		System.out.println("Food\tvoid setIsVisible()\t param: - ");
		return true;
	}
	
}
