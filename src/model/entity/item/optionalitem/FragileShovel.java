package model.entity.item.optionalitem;

import controller.GameRunner;
import view.entity.FragileShovelView;
/**
 * Az egyik opcionalis targyat, a torekeny asot (FragileShovel) megvalosito és reprezentalo
 * osztaly. Segitsegevel a jatekosok megmenthetik bajbajuttott tarsaikat.
 */
public class FragileShovel extends OptionalItem {

	private int numOfUses = 3;

	public FragileShovel(String id) {
		super(id);
		view = new FragileShovelView(GameRunner.baseGameController);
	}

	/**
	 * A jatekos, ha rendelkezik FragileShovel-lel, hasznalhatja azt, hogy egy
	 * asassal ket egysegnyi havat tuntethessen el. Mivel alapbol numOfUses = 3, igy
	 * harom hasznalat után "eltorik" az aso.
	 * 
	 * @return A visszateresi erteke a logikai igaz (true), amennyiben numOfUses >
	 *         0, ezzel jelzi hogy sikeresen hasznalta a FragileShovel Itemet a
	 *         jatekos. Ha mar eltorott az aso, visszaterese logikai hamis (false)
	 *         lesz.
	 */
	@Override
	public boolean digWithFragileShovel() {
		if (numOfUses > 0) {
			numOfUses--;
		} else {
			return false;
		}
		return true;
	}
	/**
	 * Visszater egy int ertekkel, ami megadja hogy hanyszor lehet meg hasznalni a FragileShovel-t.
	 * @return A visszateresi erteke megadja, hanyszor tudunk meg asni a FragileShovel segitsegevel
	 */

	@Override
	public int getNumOfUses() {
		return numOfUses;
	}

}
