package view.tiles;

import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.GameController;

public class TileView extends JLabel {
	private static final long serialVersionUID = 7891103595669365281L;
	private GameController baseGameController;
	
	public TileView(GameController baseGameController) throws IOException {
		this.baseGameController = baseGameController;
		
		URL entityImage = TileView.class.getResource("../images/tile.png");
		//BufferedImage myPicture = ImageIO.read(new File(entityImage.toString()));
		//JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		
		setIcon(new ImageIcon(entityImage));
		
	}
}
