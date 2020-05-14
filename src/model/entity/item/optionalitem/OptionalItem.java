package model.entity.item.optionalitem;

import controller.GameRunner;
import model.entity.item.Item;
import view.entity.ItemView;

/**
 * A j�t�k sor�n haszn�lhat� opcion�lis t�rgyak (OptionalItem-ek): Food, Rope,
 * Shovel, Wetsuit absztrakt �soszt�lya.
 */
public abstract class OptionalItem extends Item {

	
	public OptionalItem(String id) {
		super(id);
		view = new ItemView(GameRunner.baseGameController);
	}
	
}
