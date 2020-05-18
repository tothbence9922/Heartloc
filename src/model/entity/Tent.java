package model.entity;

import controller.GameRunner;
import model.Game;
import view.entity.TentView;

public class Tent extends Building {
	

	public Tent(String id) {
		super(id);
		view = new TentView(GameRunner.baseGameController);
	}
	

	/**
	 * A step() metodus oly modon megvalositva, hogy jelezze, ez az objektum nem
	 * jatekost reprezental.
	 */
	@Override
	public int step() {
		return -1;
	}
	
	@Override
	public boolean destroy() {
		Game.view.remove(this.view);
		Game.view.updatePanel();
		return true;
	}

}
