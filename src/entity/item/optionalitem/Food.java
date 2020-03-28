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
	
	public void setIsVisible(boolean trueorfalse) {
		boolean testVisible=trueorfalse;
		if(trueorfalse==true) {
			System.out.println("Food\tvoid setIsVisible(boolean)\tparam: true");
		}
	}
	
	public boolean eat() {
		System.out.println("Food\tboolean eat()\tparam: -");
		return true;
	}
}
