package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class SnowView extends EntityView {

	private static final long serialVersionUID = -8536002127200621216L;

	// TODO Creating snow images. Image depends on amount of snow.
	
	public SnowView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(SnowView.class.getResource("../images/snowBallBig.png"));
		this.setIcon(icon);
	}
}
