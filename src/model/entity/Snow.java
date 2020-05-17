package model.entity;

import controller.GameRunner;
import view.entity.SnowView;

public class Snow extends Entity {

	public Snow(String id) {
		super(id);
		view = new SnowView(GameRunner.baseGameController);
	}

	/**
	 * A step() metodus oly modon megvalositva, hogy jelezze, ez az objektum nem
	 * jatekost reprezental.
	 */
	@Override
	public int step(String msg) {
		return -1;
	}

}