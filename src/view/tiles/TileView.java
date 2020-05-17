package view.tiles;

import java.io.IOException;

import controller.GameController;
import model.tiles.Tile;
import view.View;

public class TileView extends View {
	private static final long serialVersionUID = 7891103595669365281L;

	private Tile t;

	public Tile getTile() {
		return t;
	}

	public void setTile(Tile t) {
		this.t = t;
	}

	public TileView(GameController baseGameController) throws IOException {
		super(baseGameController);
	}
}
