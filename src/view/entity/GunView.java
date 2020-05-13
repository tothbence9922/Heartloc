package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class GunView extends ItemView {

	private static final long serialVersionUID = -7983495518142460870L;
	protected static final ImageIcon icon = new ImageIcon(GunView.class.getResource("../images/gun.png"));

	public GunView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}

}
