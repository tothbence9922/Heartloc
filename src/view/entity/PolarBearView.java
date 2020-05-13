package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;
import view.tiles.TileView;

public class PolarBearView extends EntityView {

	private static final long serialVersionUID = 559740303949629090L;
	protected static final ImageIcon icon = new ImageIcon(PolarBearView.class.getResource("../images/bear.png"));

	public PolarBearView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}

}
