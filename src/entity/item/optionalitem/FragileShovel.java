package entity.item.optionalitem;

public class FragileShovel extends OptionalItem {

	private int numOfUses;

	public FragileShovel(String id) {
		super(id);
		numOfUses = 3;
	}

	/**
	 * Felulirja az ososztalybeli digWithFragileShovel() fuggvenyt. Amennyiben
	 * numOfUses valtozo erteke 0-ra csokken, akkor az aso megsemmisul
	 * 
	 * @return boolean
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
