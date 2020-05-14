package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class BeaconView extends ItemView {

	private static final long serialVersionUID = -7578455206214664207L;

	public BeaconView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(BeaconView.class.getResource("../images/gun.png"));
		this.setIcon(icon);
	}

}
