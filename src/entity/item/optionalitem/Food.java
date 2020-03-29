package entity.item.optionalitem;

public class Food extends OptionalItem {
	
	@Override
	public boolean eat() {
		System.out.println("Food\tvoid setIsVisible()\t param: - ");
		return true;
	}
	
}
