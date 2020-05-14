package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class EskimoView extends PlayerView{
	
	private static final long serialVersionUID = -8448321802798258694L;

	public EskimoView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(EskimoView.class.getResource("../images/eskimo.png"));
		this.setIcon(icon);
	}

}
