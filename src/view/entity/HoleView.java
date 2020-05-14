package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class HoleView extends EntityView {

	private static final long serialVersionUID = -3299152365267062000L;

	public HoleView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(GunView.class.getResource("../images/gun.png")); // TODO MAKE IT A HOLE!!
	}

}
