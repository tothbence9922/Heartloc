package entity.item.optionalitem;

import entity.player.Player;

/**
 * A j�t�kosok sz�m�ra lehet�s�get ny�jt testh�m�rs�klet�k n�vel�s�re, ha esznek valamit. Ez a valami az �tel - Food, melyet ez az oszt�ly reprezent�l.
 * @author tothbence9922
 *
 */
public class Food extends OptionalItem {
	public Food(String id) {
		super(id);
	}
	/**
	 * A j�t�kos, ha rendelkezik Food -dal, haszn�lhatja azt, hogy n�velje testh�m�rs�klet�t (bodyTemperature). Az �tel  (Food) elt�nik a j�t�kos t�sk�j�b�l haszn�lat ut�n.
	 * @return A visszat�r�si �rt�ke a logikai igaz (true), ezzel jelzi hogy sikeresen haszn�lta a Food Itemet a j�t�kos.
	 */
	@Override
	public boolean eat() {
		System.out.println("Food\tvoid setIsVisible()\t param: - ");
		return true;
	}
	/**
	 * Mivel a Food az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
	 * Mivel a Food az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt,
	 * �gy implement�lnia kell ezt a met�dust is. A met�dus nem m�dos�t semmin, azonban megval�s�t�sa technikai okok miatt k�telez�.
	 * @return boolean
	 */
	@Override
	public boolean dig() {
		System.out.println("Dig");
		return false;
	}
	/**
	 * Mivel a Food az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
	 * �gy implement�lnia kell ezt a met�dust is. A met�dus nem m�dos�t semmin, azonban megval�s�t�sa technikai okok miatt k�telez�.
	 * @param Player
	 * @return boolean
	 */
	@Override
	public boolean pull(Player p) {
		System.out.println("Pull");
		return false;
	}
	/**
	 * Mivel a Food az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
	 * �gy implement�lnia kell ezt a met�dust is. A met�dus nem m�dos�t semmin, azonban megval�s�t�sa technikai okok miatt k�telez�.
	 * @return boolean
	 */
	@Override
	public boolean buildTent() {
		System.out.println("BuildTent");
		return false;
	}
}
