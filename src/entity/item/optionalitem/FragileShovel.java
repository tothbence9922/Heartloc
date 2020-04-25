package entity.item.optionalitem;

public class FragileShovel extends OptionalItem {

	private int numofUses;

	public FragileShovel(String id) {
		super(id);
		numofUses = 3;
	}

	/**
	 * Felulirja az ososztalybeli digWithFragileShovel() fuggvenyt. Amennyiben
	 * numOfUses valtozo erteke 0-ra csokken, akkor az aso megsemmisul
	 * 
	 * @return boolean
	 */
	public boolean digWithFragileShovel() {
		System.out.println("Dig");
		if (numofUses > 0) {
			numofUses--;
			return true;
		}
		return true;
	}

}
