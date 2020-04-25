package entity.item.optionalitem;

import entity.player.Player;

public class FragileShovel extends OptionalItem{
		private int numofUses;
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
}
