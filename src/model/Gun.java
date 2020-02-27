package model;

public class Gun implements TargetItem {
	@Override
	public boolean use() {
			System.out.println("Gun is not yet usable");
		return false;
	}
}
