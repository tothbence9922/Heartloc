package entity.item.optionalitem;

import entity.item.Item;
/**
 * A j�t�k sor�n haszn�lhat� opcion�lis t�rgyak (OptionalItem-ek): Food, Rope, Shovel, Wetsuit absztrakt �soszt�lya.
 * @author tothbence9922
 *
 */
public abstract class OptionalItem extends Item {
	
	public OptionalItem(String id) {
		super(id);
	}
	@Override
	public int step() {
		System.out.println("Step");
		return 0;
	}
	@Override
	public boolean assembleRocket() {
		return false;
	}
	
	@Override
	public boolean useTargetItem() {
		System.out.println("useTargetItem");
		return false;
	}
	
}
