package entity.item.optionalitem;

public class Shovel implements OptionalItem{
	@Override
	public boolean use() {
			System.out.println("Shovel is usable");
		return false;
	}
	
	public boolean dig() {
		System.out.println("Shovel\tboolean dig()\tparam: -");
		return true;
	}
}
