package entity.item.optionalitem;

public class Shovel extends OptionalItem{
	
	@Override
	public boolean dig() {
		System.out.println("Shovel\tboolean dig()\tparam: -");
		return true;
	}
	
}
