package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class CartridgeView extends ItemView {

	
	private static final long serialVersionUID = 1875909257496554807L;

	public CartridgeView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(CartridgeView.class.getResource("../images/cartridge.png"));
		this.setIcon(icon);
	}

}
