package view.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.GameController;
import view.GamePanel;

public class EntityView extends JLabel {
	private static final long serialVersionUID = -5093410645830931185L;
	private GameController baseGameController;
	
	EntityView(GameController baseGameController) throws IOException {
		URL entityImage = EntityView.class.getResource("images/iceWaterDeep.png");
		BufferedImage myPicture = ImageIO.read(new File(entityImage.toString()));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		add(picLabel);
	}
}
