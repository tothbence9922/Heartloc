package entity.item.optionalitem;

public class Shovel implements OptionalItem{
	@Override
	public boolean use() {
			System.out.println("Shovel is usable");
		return false;
	}

	@Override
	public boolean wear() {
		// TODO Auto-generated method stub
		return false;
	}
}
