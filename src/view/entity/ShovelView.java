package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class ShovelView extends ItemView {

	private static final long serialVersionUID = 4934129432033430008L;

	public ShovelView(GameController baseGameController) throws IOException {
		super(baseGameController);
		icon = new ImageIcon(ShovelView.class.getResource("../images/shovel.png"));
	}

}
