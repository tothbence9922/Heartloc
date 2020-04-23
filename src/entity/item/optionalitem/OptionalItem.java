package entity.item.optionalitem;

import entity.item.Item;
/**
 * A játék során használható opcionális tárgyak (OptionalItem-ek): Food, Rope, Shovel, Wetsuit absztrakt õsosztálya.
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
