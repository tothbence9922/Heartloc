package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class BeaconView extends ItemView {

	private static final long serialVersionUID = -7578455206214664207L;
	protected static final ImageIcon icon = new ImageIcon(BeaconView.class.getResource("../images/gun.png"));

	public BeaconView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}

}
