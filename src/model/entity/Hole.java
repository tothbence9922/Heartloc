package model.entity;

import controller.GameRunner;
import view.entity.HoleView;

public class Hole extends Entity {

	public Hole(String id) {
		super(id);
		view = new HoleView(GameRunner.baseGameController);
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
