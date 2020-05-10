package model.entity.item.optionalitem;

/**
 * A játékosok számára lehetõséget nyújt testhõmérsékletük növelésére, ha esznek
 * valamit. Ez a valami az étel - Food, melyet ez az osztály reprezentál.
 */
public class Food extends OptionalItem {
	
	public Food(String id) {
		super(id);
	}

	/**
	 * A játékos, ha rendelkezik Food-al, használhatja azt, hogy növelje
	 * testhõmérsékletét (bodyTemperature). Az étel (Food) eltûnik a játékos
	 * táskájából használat után.
	 * 
	 * @return A visszatérési értéke a logikai igaz (true), ezzel jelzi hogy
	 *         sikeresen használta a Food Itemet a játékos.
	 */
	@Override
	public boolean eat() {
		return true;
	}
	
}
