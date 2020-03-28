package entity.item.targetitem;

public class Rocket implements TargetItem {
	@Override
	public boolean use() {
			System.out.println("Rocket is not yet usable");
		return false;
	}
	@Override
	public boolean useTargetItem() {
		System.out.println("Rocket\tboolean useTargetItem()\tparam: -");
		return false;
	}
}
