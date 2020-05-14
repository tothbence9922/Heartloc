package model.entity.item.optionalitem;

import view.entity.TentView;

public class TentItem extends OptionalItem {

	public TentView view;
	
	public TentItem(String id) {
		super(id);
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
