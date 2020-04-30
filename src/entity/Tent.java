package entity;

public class Tent extends Building  {

	public Tent(String id) {
		super(id);
	}
	/**
	 * A step() metodus oly modon megvalositva, hogy jelezze, ez az objektum nem jatekost reprezental.
	 */
	@Override
	public int step() {
		return -1;
	}
	
}
