package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class EskimoView extends PlayerView{
	
	private static final long serialVersionUID = -8448321802798258694L;
	protected static final ImageIcon icon = new ImageIcon(EskimoView.class.getResource("../images/eskimo.png"));

	public EskimoView(GameController baseGameController){
		super(baseGameController);
		this.setIcon(icon);
	}

}
