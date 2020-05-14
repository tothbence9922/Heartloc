package view.entity;

import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;

import controller.GameController;
import view.tiles.TileView;

public class EskimoView extends PlayerView{
	
	private static final long serialVersionUID = -8448321802798258694L;
	protected static final ImageIcon icon = new ImageIcon(EskimoView.class.getResource("../images/eskimo.png"));

	public EskimoView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}

}
