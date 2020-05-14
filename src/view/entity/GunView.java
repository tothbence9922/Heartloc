package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class GunView extends ItemView {

	private static final long serialVersionUID = -7983495518142460870L;

	public GunView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(GunView.class.getResource("../images/gun.png"));
		this.setIcon(icon);
	}

}
