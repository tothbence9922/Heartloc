package entity.item.optionalitem;

import entity.player.Player;
/**
 * Az egyik opcion�lis t�rgyat, a k�telet (Rope) megval�s�t� �s reprezent�l� oszt�ly. Seg�ts�g�vel a j�t�kosok megmenthetik bajbajuttott t�rsaikat.
 * @author tothbence9922
 *
 */
public class Rope extends OptionalItem{
	public Rope(String id) {
		super(id);
	}

	/**
	 * A j�t�kos, ha rendelkezik Rope-pal, haszn�lhatja azt, hogy megmentse bajbajutott t�rs�t. Miut�n a bajbajuttott sik�t (Player::scream()), a szomsz�dos j�gt�bl�n (Tile) �ll� j�t�kos, ha rendelkezik k�t�llel, automatikusan kimenti a m�sik j�t�kost aki ennek hat�s�ra arra a j�gt�bl�ra (Tile) ker�l, melyen a megment�je �ll.
	 * @param Player p - A param�ter�l kapott j�t�kos a kimentend� j�t�kos.
	 * @return true A visszat�r�si �rt�ke a logikai Igaz (true), ezzel jelezve hogy j�t�kos sikeresen haszn�lta a k�telet (Rope).
	 */
	@Override
	public boolean pull(Player p) {
		System.out.println("Pull");
		return true;
	}
	
	/**
	 * Mivel a Rope az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
	 * �gy implement�lnia kell ezt a met�dust is. A met�dus nem m�dos�t semmin, azonban megval�s�t�sa
	 * technikai okok miatt k�telez�.
	 * @return boolean
	 */
	@Override
	public boolean eat() {
		System.out.println("Food\tvoid setIsVisible()\t param: - ");
		return false;
	}
	/**
	 * Mivel a Rope az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
	 * �gy implement�lnia kell ezt a met�dust is. A met�dus nem m�dos�t semmin, azonban megval�s�t�sa
	 * technikai okok miatt k�telez�.
	 * @return boolean
	 */
	@Override
	public boolean wear() {
		System.out.println("Wear");
		return false;
	}
	/**
	 * Mivel a Rope az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
	 * �gy implement�lnia kell ezt a met�dust is. A met�dus nem m�dos�t semmin, azonban megval�s�t�sa
	 * technikai okok miatt k�telez�.
	 * @return boolean
	 */
	@Override
	public boolean dig() {
		System.out.println("Dig");
		return false;
	}
	/**
	 * Mivel a Rope az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
	 * �gy implement�lnia kell ezt a met�dust is. A met�dus nem m�dos�t semmin, azonban megval�s�t�sa
	 * technikai okok miatt k�telez�.
	 * @return boolean
	 */
	@Override
	public boolean buildTent() {
		System.out.println("BuildTent");
		return false;
	}
}
