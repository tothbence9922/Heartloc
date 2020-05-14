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
	 * A játékos, ha rendelkezik FragileShovel-lel, használhatja azt, hogy egy ásással két egységnyi havat
	 * tüntethessen el.
	 * Mivel alapból numOfUses = 3, így három használat után "eltörik" az ásó.
	 * @return A visszatérési értéke a logikai igaz (true), amennyiben numOfUses > 0, ezzel jelzi hogy
	 *         sikeresen használta a FragileShovel Itemet a játékos. Ha már eltörött az ásó, visszatérése logikai hamis (false) lesz.
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
