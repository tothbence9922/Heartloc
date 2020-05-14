package model.entity.item.optionalitem;

import controller.GameRunner;
import view.entity.FragileShovelView;

public class FragileShovel extends OptionalItem {

	
	private int numOfUses = 3;

	public FragileShovel(String id) {
		super(id);
		view = new FragileShovelView(GameRunner.baseGameController);
	}

	/**
	 * A j�t�kos, ha rendelkezik FragileShovel-lel, haszn�lhatja azt, hogy egy �s�ssal k�t egys�gnyi havat
	 * t�ntethessen el.
	 * Mivel alapb�l numOfUses = 3, �gy h�rom haszn�lat ut�n "elt�rik" az �s�.
	 * @return A visszat�r�si �rt�ke a logikai igaz (true), amennyiben numOfUses > 0, ezzel jelzi hogy
	 *         sikeresen haszn�lta a FragileShovel Itemet a j�t�kos. Ha m�r elt�r�tt az �s�, visszat�r�se logikai hamis (false) lesz.
	 */
	@Override
	public boolean digWithFragileShovel() {
		System.out.println("Dig");
		if (numOfUses > 0) {
			numOfUses--;
		} else {
			return false;
		}
		return true;
	}
	
	@Override
	public int getNumOfUses() {
		return numOfUses;
	}

}
