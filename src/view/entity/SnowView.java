package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;
import view.tiles.TileView;

public class SnowView extends EntityView {

	private static final long serialVersionUID = -8536002127200621216L;
	protected static final ImageIcon icon = new ImageIcon(SnowView.class.getResource("../images/snowBallBig.png"));

	// TODO Creating snow images. Image depends on amount of snow.
	
	public SnowView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}
}
