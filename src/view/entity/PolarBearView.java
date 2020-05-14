package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class PolarBearView extends EntityView {

	private static final long serialVersionUID = 559740303949629090L;

	public PolarBearView(GameController baseGameController) throws IOException {
		super(baseGameController);
		icon = new ImageIcon(PolarBearView.class.getResource("../images/bear.png"));
		this.setIcon(icon);
	}

}
