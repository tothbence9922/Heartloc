package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class RocketView extends ItemView {

	private static final long serialVersionUID = 4789254464599151480L;
	protected static final ImageIcon icon = new ImageIcon(RocketView.class.getResource("../images/gun.png"));

	public RocketView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
}

}
