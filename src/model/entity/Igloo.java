package model.entity;

import view.entity.IglooView;

public class Igloo extends Building {
	
	public static int numOfIgloos = 0;
	public IglooView view;
	
	public Igloo(String id) {
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
