package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class TentView extends BuildingView {

	private static final long serialVersionUID = 7669658819771612706L;
	protected static final ImageIcon icon = new ImageIcon(TentView.class.getResource("../images/tent.png"));

	public TentView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}

}
