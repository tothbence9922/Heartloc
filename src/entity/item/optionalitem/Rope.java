package entity.item.optionalitem;

import entity.player.Player;

/**
 * Az egyik opcionális tárgyat, a kötelet (Rope) megvalósító és reprezentáló
 * osztály. Segítségével a játékosok megmenthetik bajbajuttott társaikat.
 */
public class Rope extends OptionalItem {
	
	public Rope(String id) {
		super(id);
	}

	/**
	 * A játékos, ha rendelkezik Rope-pal, használhatja azt, hogy megmentse
	 * bajbajutott társát. Miután a bajbajuttott sikít (Player::scream()), a
	 * szomszédos jégtáblán (Tile) álló játékos, ha rendelkezik kötéllel,
	 * automatikusan kimenti a másik játékost aki ennek hatására arra a jégtáblára
	 * (Tile) kerül, melyen a megmentõje áll.
	 * 
	 * @param Player p - A paraméterül kapott játékos a kimentendõ játékos.
	 * @return true A visszatérési értéke a logikai Igaz (true), ezzel jelezve hogy
	 *         játékos sikeresen használta a kötelet (Rope).
	 */
	@Override
	public boolean pull(Player p) {
		return true;
	}
}
