package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class FragileShovelView extends ItemView {

	private static final long serialVersionUID = -6760217020665515466L;
	protected static final ImageIcon icon = new ImageIcon(FragileShovelView.class.getResource("../images/fragileShovel.png"));

	public FragileShovelView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
}

}
