package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class WetsuitView extends ItemView {

	private static final long serialVersionUID = -5378569920028842024L;
	protected static final ImageIcon icon = new ImageIcon(WetsuitView.class.getResource("../images/wetsuit.png"));

	public WetsuitView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}

}
