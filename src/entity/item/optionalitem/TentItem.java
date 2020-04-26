package entity.item.optionalitem;

public class TentItem extends OptionalItem {

	public TentItem(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * A jatekos, ha rendelkezik Item-mel, annak hasznalataval kulonbozo modokon
	 * juthat elonyhoz - vagy nyerheti meg a jatekot.
	 * 
	 * @return Ha az epites sikeres true-val ter vissza.
	 */
	@Override
	public boolean buildTent() {
		return true;
	}

}
