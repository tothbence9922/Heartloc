package view.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.GameController;
import view.MenuView;
import view.View;
import view.tiles.TileView;

public class EntityView extends View {

	private static final long serialVersionUID = -1649204326123260256L;
	
	public EntityView(GameController baseGameController) throws IOException {
		super(baseGameController);
	}
	
}
