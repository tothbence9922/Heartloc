package entity.item.optionalitem;

import entity.player.Player;

/**
 * A Wetsuit osztály reprezentálja a játékos egy lehetséges tárgyát, mellyel képes túlélni vízbeeés után, sérülés nélkül.
 * @author tothbence9922
 *
 */
public class Wetsuit extends OptionalItem{
	public Wetsuit(String id) {
		super(id);
	}
/**
 * A Wetsuit használata automatikus, ha a játékosnak van Wetsuitja és vízbe esik, automatikusan használja.
 * @return Visszatérési értéke a logikai Igaz (true), ezzel jelezve hogy a játékosnak van ilyen Item-e és szükség esetén sikeresen használta.
 */
	/**
	 * Mivel a Wetsuit az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása
	 * technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean eat() {
		System.out.println("Food\tvoid setIsVisible()\t param: - ");
		return true;
	}
	/**
	 * Mivel a Wetsuit az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
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
	 * Mivel a Wetsuit az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása
	 * technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean dig() {
		System.out.println("Dig");
		return false;
	}
	/**
	 * Mivel a Wetsuit az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása
	 * technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean pull(Player p) {
		System.out.println("Pull");
		return false;
	}
	/**
	 * Mivel a Wetsuit az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása
	 * technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean buildTent() {
		System.out.println("BuildTent");
		return false;
	}
}
