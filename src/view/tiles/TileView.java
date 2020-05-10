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
		URL entityImage = TileView.class.getResource("../images/tile.png");
		//BufferedImage myPicture = ImageIO.read(new File(entityImage.toString()));
		//JLabel picLabel = new JLabel(new ImageIcon(myPicture));

		JLabel imgLabel = new JLabel(new ImageIcon(entityImage));
		this.add(imgLabel);
	}
}
