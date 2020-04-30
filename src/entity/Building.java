package entity;

public class Building extends Entity {
	/**
	 * A step() metodus oly modon megvalositva, hogy jelezze, ez az objektum nem jatekost reprezental.
	 */
	@Override
	public int step() {
		return -1;
	}
	
	public Building(String id) {super(id);}
	
}
