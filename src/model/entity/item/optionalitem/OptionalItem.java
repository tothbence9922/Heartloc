package model.entity.item.optionalitem;

import controller.GameRunner;
import model.entity.item.Item;
import view.entity.ItemView;

/**
 * A játék során használható opcionális tárgyak (OptionalItem-ek): Food, Rope,
 * Shovel, Wetsuit absztrakt õsosztálya.
 */
public abstract class OptionalItem extends Item {

	
	public OptionalItem(String id) {
		super(id);
		view = new ItemView(GameRunner.baseGameController);
	}
	
}
