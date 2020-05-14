
package view.tiles;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;
import view.tiles.TileView;

public class UnstableTileView extends TileView {

	private static final long serialVersionUID = -8704062230678535059L;
	protected static final ImageIcon icon = new ImageIcon(UnstableTileView.class.getResource("../images/tile.png"));

	public UnstableTileView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}


}
