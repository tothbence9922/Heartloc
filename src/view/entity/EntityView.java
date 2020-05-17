package view.entity;

import controller.GameController;
import view.View;

public class EntityView extends View {

	private static final long serialVersionUID = -1649204326123260256L;

	public EntityView(GameController baseGameController) {
		super(baseGameController);
		this.w = 64;
		this.h = 85;
	}

}
