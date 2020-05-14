package model.entity.item.optionalitem;

import model.entity.item.Item;
import view.entity.OptionalItemView;

/**
 * A játék során használható opcionális tárgyak (OptionalItem-ek): Food, Rope,
 * Shovel, Wetsuit absztrakt õsosztálya.
 */
public abstract class OptionalItem extends Item {

	public OptionalItemView view;
	
	public OptionalItem(String id) {
		super(id);
	}
	
}
