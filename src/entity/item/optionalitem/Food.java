package entity.item.optionalitem;

public class Food implements OptionalItem {
	@Override
	public boolean use() {
			System.out.println("Food :3");
		return false;
	}

	public void pickup() {
		System.out.println("Food\tvoid pickup()\tparam: -");
	}
}
