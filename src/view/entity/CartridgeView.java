package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class CartridgeView extends ItemView {

	
	private static final long serialVersionUID = 1875909257496554807L;
	protected static final ImageIcon icon = new ImageIcon(CartridgeView.class.getResource("../images/cartridge.png"));

	public CartridgeView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}

}
