package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class ShovelView extends ItemView {

	private static final long serialVersionUID = 4934129432033430008L;
	protected static final ImageIcon icon = new ImageIcon(ShovelView.class.getResource("../images/shovel.png"));

	public ShovelView(GameController baseGameController) throws IOException {
		super(baseGameController);
		// TODO Auto-generated constructor stub
	}

}
