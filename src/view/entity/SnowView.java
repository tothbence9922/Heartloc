package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class SnowView extends EntityView {

	private static final long serialVersionUID = -8536002127200621216L;
	
	public SnowView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(SnowView.class.getResource("../images/snowBallBig-32x32.png"));
		this.setIcon(icon);
	}
}
