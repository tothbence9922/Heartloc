package entity.item.optionalitem;

import entity.player.Player;

public class FragileShovel extends OptionalItem{
		private int numofUses;
		public FragileShovel(String id) {
		super(id);
		numofUses = 3;
	}
	
	/**
	 * Felulirja az õsosztálybeli dig() függvényt. Amennyiben numOfUses változó értéke 0-ra csökken, akkor az ásó megsemmisül
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
}
