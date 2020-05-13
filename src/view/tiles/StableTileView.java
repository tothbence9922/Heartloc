package view.tiles;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;
import view.tiles.TileView;

public class StableTileView extends TileView {

	private static final long serialVersionUID = 283052365511298595L;
	protected static final ImageIcon icon = new ImageIcon(StableTileView.class.getResource("../images/tile.png"));

	public StableTileView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}


}
