package model.entity;

import controller.GameRunner;
import view.entity.BuildingView;
import view.entity.EntityView;

public class Building extends Entity {
	public EntityView view;

	/**
	 * A step() metodus oly modon megvalositva, hogy jelezze, ez az objektum nem
	 * jatekost reprezental.
	 */
	@Override
	public int step() {
		return -1;
	}

	public Building(String id) {
		super(id);
		view = new BuildingView(GameRunner.baseGameController);
	}

}
