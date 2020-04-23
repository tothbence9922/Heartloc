package entity.item.optionalitem;

import entity.player.Player;

/**
 * Az egyik opcionális tárgyat, az ásót (Shovel) megvalósító és reprezentáló osztály.
 * @author tothbence9922
 *
 */
public class Shovel extends OptionalItem{
	
	public Shovel(String id) {
		super(id);
	}
	/**
	 * A játékos, ha rendelkezik Shovel-lel, használhatja azt, hogy ásson vele. Ezzel két egységnyi havat takaríthat el, azonban Itemet nem vehet fel Shovel használatával.
	 * @return Visszatérési értéke a logikai Igaz (true), ezzel jelezve hogy a játékos sikeresen használta  az Ásó (Shovel) Itemet.
	 */
	/**
	 * Mivel a Shovel az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
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
	 * Mivel a Shovel az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
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
	 * Mivel a Shovel az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
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
	 * Mivel a Shovel az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása
	 * technikai okok miatt kötelezõ.
	 * @param Player
	 * @return boolean
	 */
	@Override
	public boolean pull(Player p) {
		System.out.println("Pull");
		return false;
	}
	/**
	 * Mivel a Shovel az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
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
