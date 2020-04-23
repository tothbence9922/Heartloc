package entity.item.optionalitem;

import entity.player.Player;

/**
 * A Wetsuit oszt�ly reprezent�lja a j�t�kos egy lehets�ges t�rgy�t, mellyel k�pes t�l�lni v�zbee�s ut�n, s�r�l�s n�lk�l.
 * @author tothbence9922
 *
 */
public class Wetsuit extends OptionalItem{
	public Wetsuit(String id) {
		super(id);
	}
/**
 * A Wetsuit haszn�lata automatikus, ha a j�t�kosnak van Wetsuitja �s v�zbe esik, automatikusan haszn�lja.
 * @return Visszat�r�si �rt�ke a logikai Igaz (true), ezzel jelezve hogy a j�t�kosnak van ilyen Item-e �s sz�ks�g eset�n sikeresen haszn�lta.
 */
	/**
	 * Mivel a Wetsuit az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
	 * Mivel a Wetsuit az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
	 * Mivel a Wetsuit az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
	 * Mivel a Wetsuit az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
	 * �gy implement�lnia kell ezt a met�dust is. A met�dus nem m�dos�t semmin, azonban megval�s�t�sa
	 * technikai okok miatt k�telez�.
	 * @return boolean
	 */
	@Override
	public boolean pull(Player p) {
		System.out.println("Pull");
		return false;
	}
	/**
	 * Mivel a Wetsuit az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
