package entity.item.optionalitem;

import entity.player.Player;

public class FragileShovel extends OptionalItem{
		int numofUses;
		public FragileShovel(String id) {
		super(id);
		numofUses = 3;
	}
	
	/**
	 * Felulirja az �soszt�lybeli dig() f�ggv�nyt. Amennyiben numOfUses v�ltoz� �rt�ke 0-ra cs�kken, akkor az �s� megsemmis�l
	 * @return boolean
	 */
	@Override
	public boolean dig() {
		System.out.println("Dig");
		if(numofUses > 0) {
			numofUses--;
			return true;
		}
		return false;
	}
	/**
	 * Mivel a FragileShovel az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
	 * Mivel a FragileShovel az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
	 * Mivel a FragileShovel az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
	 * Mivel a FragileShovel az Entity �soszt�lyb�l sz�rmaztatott oszt�ly, �s minden �soszt�lya absztrakt
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
