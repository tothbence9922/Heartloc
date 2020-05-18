package view.tiles;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;
import view.entity.TentView;
import view.tiles.TileView;
/**
 * A stabil tablak megjeleniteseert felelos osztaly
 * 
 */
public class StableTileView extends TileView {

	private static final long serialVersionUID = 283052365511298595L;
	/**
	 * 
	 * A Stabil tabla kepenek eltaroasa az osztalyban
	 */
	public StableTileView(GameController baseGameController) throws IOException {
		super(baseGameController);
		ImageIcon tmp = new ImageIcon(StableTileView.class.getResource("../images/tile.png"));
		if (tmp != null) {
			icon = tmp;
			this.setIcon(icon);
		}
	}


}
