package model.entity.item.optionalitem;

import controller.GameRunner;
import model.entity.item.Item;
import view.entity.ItemView;

/**
 * A jatek soran hasznalhato opcionalis targyak (OptionalItem-ek): Food, Rope,
 * Shovel, Wetsuit absztrakt ososztalya.
 */
public abstract class OptionalItem extends Item {

	public OptionalItem(String id) {
		super(id);
		view = new ItemView(GameRunner.baseGameController);
	}

}
