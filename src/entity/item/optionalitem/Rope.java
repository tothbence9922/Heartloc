package entity.item.optionalitem;

import entity.player.Player;
/**
 * Az egyik opcionális tárgyat, a kötelet (Rope) megvalósító és reprezentáló osztály. Segítségével a játékosok megmenthetik bajbajuttott társaikat.
 * @author tothbence9922
 *
 */
public class Rope extends OptionalItem{
	public Rope(String id) {
		super(id);
	}

	/**
	 * A játékos, ha rendelkezik Rope-pal, használhatja azt, hogy megmentse bajbajutott társát. Miután a bajbajuttott sikít (Player::scream()), a szomszédos jégtáblán (Tile) álló játékos, ha rendelkezik kötéllel, automatikusan kimenti a másik játékost aki ennek hatására arra a jégtáblára (Tile) kerül, melyen a megmentõje áll.
	 * @param Player p - A paraméterül kapott játékos a kimentendõ játékos.
	 * @return true A visszatérési értéke a logikai Igaz (true), ezzel jelezve hogy játékos sikeresen használta a kötelet (Rope).
	 */
	@Override
	public boolean pull(Player p) {
		System.out.println("Pull");
		return true;
	}
	
	/**
	 * Mivel a Rope az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása
	 * technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean eat() {
		System.out.println("Food\tvoid setIsVisible()\t param: - ");
		return false;
	}
	/**
	 * Mivel a Rope az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
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
	 * Mivel a Rope az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
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
	 * Mivel a Rope az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
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
