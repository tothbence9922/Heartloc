package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class RopeView extends ItemView {

	private static final long serialVersionUID = -7899741607513882606L;
	protected static final ImageIcon icon = new ImageIcon(RopeView.class.getResource("../images/rope.png"));

	public RopeView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}

}
