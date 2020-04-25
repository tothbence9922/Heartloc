package entity.item.optionalitem;

import entity.item.Item;

/**
 * A játék során használható opcionális tárgyak (OptionalItem-ek): Food, Rope,
 * Shovel, Wetsuit absztrakt õsosztálya.
 */
public abstract class OptionalItem extends Item {

	public OptionalItem(String id) {
		super(id);
	}
	
}
