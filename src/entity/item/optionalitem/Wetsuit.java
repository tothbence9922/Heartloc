package entity.item.optionalitem;

public class Wetsuit extends OptionalItem{

  @Override
	public boolean wear() {
		System.out.println("Wetsuit\t boolean wear()\tparam: -");
		return true;
	}

}
