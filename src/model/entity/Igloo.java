package model.entity;

import controller.GameRunner;
import view.entity.IglooView;

public class Igloo extends Building {
	
	public static int numOfIgloos = 0;
	
	public Igloo(String id) {
		super(id);
		view = new IglooView(GameRunner.baseGameController);

	}
	
	/**
	 * A step() metodus oly modon megvalositva, hogy jelezze, ez az objektum nem jatekost reprezental.
	 */
	@Override
	public int step(String msg) {
		return -1;
	}

}
