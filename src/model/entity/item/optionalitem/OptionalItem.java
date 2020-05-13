package model.entity.item.optionalitem;

import model.entity.item.Item;
import view.entity.OptionalItemView;

/**
 * A j�t�k sor�n haszn�lhat� opcion�lis t�rgyak (OptionalItem-ek): Food, Rope,
 * Shovel, Wetsuit absztrakt �soszt�lya.
 */
public abstract class OptionalItem extends Item {

	public OptionalItemView view;
	
	public OptionalItem(String id) {
		super(id);
	}
	
}
