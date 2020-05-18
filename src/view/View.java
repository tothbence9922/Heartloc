package view;

import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.text.html.ImageView;

import controller.GameController;
import view.tiles.TileView;

public class View extends JLabel {

	protected ImageIcon icon;

	private static final long serialVersionUID = 4819391159119195619L;
	protected GameController baseGameController;

	protected int x, y, w, h;

	public void setPos(int x, int y) {
		super.setBounds(x, y, w, h);
	}

	public View(GameController baseGameController) {
		w = 128;
		h = 128;
		this.baseGameController = baseGameController;

		// So our JButton is transparent, only icons will appear
		setOpaque(false);
		setFocusable(false);

		// BufferedImage myPicture = ImageIO.read(new File(entityImage.toString()));
		// JLabel picLabel = new JLabel(new ImageIcon(myPicture));

	}

	public void Draw() {
		this.getParent().validate();
		this.getParent().repaint();
	}

}
