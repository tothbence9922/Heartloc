package model.entity;

import view.entity.SnowView;

public class Snow extends Entity {

	public SnowView view;
	
	public Snow(String id) {
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