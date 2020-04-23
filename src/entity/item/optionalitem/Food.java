package entity.item.optionalitem;

import entity.player.Player;

/**
 * A játékosok számára lehetõséget nyújt testhõmérsékletük növelésére, ha esznek valamit. Ez a valami az étel - Food, melyet ez az osztály reprezentál.
 * @author tothbence9922
 *
 */
public class Food extends OptionalItem {
	public Food(String id) {
		super(id);
	}
	/**
	 * A játékos, ha rendelkezik Food -dal, használhatja azt, hogy növelje testhõmérsékletét (bodyTemperature). Az étel  (Food) eltûnik a játékos táskájából használat után.
	 * @return A visszatérési értéke a logikai igaz (true), ezzel jelzi hogy sikeresen használta a Food Itemet a játékos.
	 */
	@Override
	public boolean eat() {
		System.out.println("Food\tvoid setIsVisible()\t param: - ");
		return true;
	}
	/**
	 * Mivel a Food az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása
	 * technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean wear() {
		System.out.println("Wear");
		return false;
	}
	/**
	 * Mivel a Food az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt,
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean dig() {
		System.out.println("Dig");
		return false;
	}
	/**
	 * Mivel a Food az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása technikai okok miatt kötelezõ.
	 * @param Player
	 * @return boolean
	 */
	@Override
	public boolean pull(Player p) {
		System.out.println("Pull");
		return false;
	}
	/**
	 * Mivel a Food az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean buildTent() {
		System.out.println("BuildTent");
		return false;
	}
}
