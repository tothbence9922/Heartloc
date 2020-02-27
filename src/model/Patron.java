package model;

public class Patron implements TargetItem {
	@Override
	public boolean use() {
			System.out.println("Patron is not yet usable");
		return false;
	}
}
