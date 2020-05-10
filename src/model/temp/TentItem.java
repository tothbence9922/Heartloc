package model.temp;

import model.entity.item.optionalitem.OptionalItem;

public class TentItem extends OptionalItem {

	public TentItem(String id) {
		super(id);
	}

	@Override
	public boolean buildTent() {
		return true;
	}
}
