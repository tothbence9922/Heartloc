package entity.item.optionalitem;

import entity.player.Player;

/**
 * Az egyik opcion�lis t�rgyat, a k�telet (Rope) megval�s�t� �s reprezent�l�
 * oszt�ly. Seg�ts�g�vel a j�t�kosok megmenthetik bajbajuttott t�rsaikat.
 */
public class Rope extends OptionalItem {
	
	public Rope(String id) {
		super(id);
	}

	/**
	 * A j�t�kos, ha rendelkezik Rope-pal, haszn�lhatja azt, hogy megmentse
	 * bajbajutott t�rs�t. Miut�n a bajbajuttott sik�t (Player::scream()), a
	 * szomsz�dos j�gt�bl�n (Tile) �ll� j�t�kos, ha rendelkezik k�t�llel,
	 * automatikusan kimenti a m�sik j�t�kost aki ennek hat�s�ra arra a j�gt�bl�ra
	 * (Tile) ker�l, melyen a megment�je �ll.
	 * 
	 * @param Player p - A param�ter�l kapott j�t�kos a kimentend� j�t�kos.
	 * @return true A visszat�r�si �rt�ke a logikai Igaz (true), ezzel jelezve hogy
	 *         j�t�kos sikeresen haszn�lta a k�telet (Rope).
	 */
	@Override
	public boolean pull(Player p) {
		return true;
	}
}
