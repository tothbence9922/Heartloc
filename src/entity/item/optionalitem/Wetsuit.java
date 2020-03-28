package entity.item.optionalitem;

public class Wetsuit implements OptionalItem{
	
	public void henlo() {
		System.out.println("Hello");
	}

	@Override
	public boolean use() {
			System.out.println("Wetsuit is not usable");
		return false;
	}
	
	public boolean wear() {
		System.out.println("Wetsuit\tboolean wear()\tparam: -");
		return false;
	}
}
