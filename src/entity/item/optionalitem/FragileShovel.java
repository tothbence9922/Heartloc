package entity.item.optionalitem;

import entity.player.Player;

public class FragileShovel extends OptionalItem{
		private int numofUses;
		public FragileShovel(String id) {
		super(id);
		numofUses = 3;
	}
	
	/**
	 * Felulirja az �soszt�lybeli digWithFragileShovel() f�ggv�nyt. Amennyiben numOfUses v�ltoz� �rt�ke 0-ra cs�kken, akkor az �s� megsemmis�l
	 * @return boolean
	 */
	public boolean digWithFragileShovel() {
		System.out.println("Dig");
		if(numofUses > 0) {
			numofUses--;
			return true;
		}
		return true;
	}
}
