package model.entity;

import view.entity.HoleView;

public class Hole extends Entity {

	private HoleView view;
	
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
