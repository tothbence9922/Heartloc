package entity;

public class Hole extends Entity {

	public Hole(String id) {
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
