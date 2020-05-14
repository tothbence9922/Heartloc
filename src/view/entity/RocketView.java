package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class RocketView extends ItemView {

	private static final long serialVersionUID = 4789254464599151480L;

	public RocketView(GameController baseGameController) {
		super(baseGameController);
		icon = new ImageIcon(RocketView.class.getResource("../images/gun.png"));
		this.setIcon(icon);
}

}
