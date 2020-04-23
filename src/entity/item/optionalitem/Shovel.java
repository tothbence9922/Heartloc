package entity.item.optionalitem;

import entity.player.Player;

/**
 * Az egyik opcion�lis t�rgyat, az �s�t (Shovel) megval�s�t� �s reprezent�l� oszt�ly.
 * @author tothbence9922
 *
 */
public class Shovel extends OptionalItem{
	
	public Shovel(String id) {
		super(id);
	}
	/**
	 * A j�t�kos, ha rendelkezik Shovel-lel, haszn�lhatja azt, hogy �sson vele. Ezzel k�t egys�gnyi havat takar�that el, azonban Itemet nem vehet fel Shovel haszn�lat�val.
	 * @return Visszat�r�si �rt�ke a logikai Igaz (true), ezzel jelezve hogy a j�t�kos sikeresen haszn�lta  az �s� (Shovel) Itemet.
	 */
	/**
	 * Mivel a Shovel az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
	 * �gy implement�lnia kell ezt a met�dust is. A met�dus nem m�dos�t semmin, azonban megval�s�t�sa
	 * technikai okok miatt k�telez�.
	 * @return boolean
	 */
	@Override
	public boolean eat() {
		System.out.println("Food\tvoid setIsVisible()\t param: - ");
		return true;
	}
	/**
	 * Mivel a Shovel az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
	 * Mivel a Shovel az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
	 * Mivel a Shovel az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
	 * �gy implement�lnia kell ezt a met�dust is. A met�dus nem m�dos�t semmin, azonban megval�s�t�sa
	 * technikai okok miatt k�telez�.
	 * @param Player
	 * @return boolean
	 */
	@Override
	public boolean pull(Player p) {
		System.out.println("Pull");
		return false;
	}
	/**
	 * Mivel a Shovel az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
