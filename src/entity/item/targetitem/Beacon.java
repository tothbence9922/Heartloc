package entity.item.targetitem;

public class Beacon implements TargetItem {
	@Override
	public boolean use() {
			System.out.println("Beacon is not yet usable");
		return false;
	}
}
