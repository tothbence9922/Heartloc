package entity.item.targetitem;


public class Rocket {

public class Rocket implements TargetItem {
	
	public Rocket() {
		System.out.println("Rocket has been created");
	}
	@Override
	public boolean use() {
			System.out.println("Rocket is not yet usable");
		return false;
	}
	/**
	 *  A függvényt meghívva az összerakott TargetItem
	 *	(Rocket) elsül, ezáltal jelezve a játék végét, hogy nyertek a játékosok. 
	 */
	@Override
	public boolean useTargetItem() {
		System.out.println("Rocket\tboolean useTargetItem()\tparam: -");
		return false;
	}

}
