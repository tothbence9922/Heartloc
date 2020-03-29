package entity.item.optionalitem;

public class Wetsuit implements OptionalItem{

	@Override
	public boolean use() {
			System.out.println("Wetsuit is not usable");
		return false;
	}

	@Override
	public boolean wear() {
		System.out.println("Wetsuit\tboolean wear()\tparam: -");
		return true;
	}
}
