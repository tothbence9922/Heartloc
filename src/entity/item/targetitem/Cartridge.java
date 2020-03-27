package entity.item.targetitem;

public class Cartridge implements TargetItem {
	@Override
	public boolean use() {
			System.out.println("Patron is not yet usable");
		return false;
	}
}
