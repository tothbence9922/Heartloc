package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.GameController;

/**
 * A jatek veget jelento kepernyo, mely akkor jelenik meg, amikor egy jatekos
 * valamilyen modon meghalt, ezaltal veget er a jatek. Ennek az okat egy
 * parameterkent atadott valtozonak koszonhetoen meg is jeleniti
 *
 */
public class EndView extends JPanel {
	/**
	 * Auto-generated serial variable
	 */
	private static final long serialVersionUID = -1748399399482164668L;
	private boolean lose;
	private GameController baseGameController;
	private JLabel labelGame;
	private JButton btnExit;
	private GridBagLayout baseLayout;

	public EndView(GameController baseGameController, boolean loseState, String msg) {
		this.baseGameController = baseGameController;
		lose = loseState;
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/CHILLER.TTF"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		/**
		 * JLabelbe tetszoleges formatumban megjeleniti az uzenetet HTML kod
		 * segitsegevel es kozepre zarja
		 */
		if (lose)
			labelGame = new JLabel("<html><body style='text-align:center'>You Lose!<br>" + msg + "</body></html>");
		else
			labelGame = new JLabel(
					"<html><body style='text-align:center'>You Win! You saved our arses!<br> ${'msg'} </body></html>");

		labelGame.setFont(font.deriveFont(Font.PLAIN, 120f));
		labelGame.setForeground(Color.WHITE);

		baseLayout = new GridBagLayout();
		btnExit = new JButton("Exit");
		btnExit.setForeground(Color.DARK_GRAY);
		btnExit.setFont(font.deriveFont(Font.PLAIN, 90f));
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setFocusPainted(false);

		buildPanel();
		buildListeners();
	}

	/**
	 * Megadja a szukseges constrainteket, letrehoz egy uj panelt, amin mejeleniti a
	 * gombot
	 */
	private void buildPanel() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weighty = 1;

		JPanel buttons = new JPanel(new GridBagLayout());
		buttons.add(btnExit, gbc);
		buttons.setOpaque(false); // do not display background over the other panel

		this.setLayout(baseLayout);
		this.add(labelGame, gbc);
		this.add(buttons, gbc);
	}

	/**
	 * Add listener to the button, notifies controller
	 */
	private void buildListeners() {
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				System.exit(1);
			}
		});

		/**
		 * Hover effekt szimulalasa (amikor kilep az eger akkor visszaallitja a
		 * kezdetben hasznalt szinre, mikor belep az eger, akkor pedig feherre
		 */
		btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnExit.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnExit.setForeground(Color.DARK_GRAY);
			}
		});
	}

	/**
	 * Hatterkep beallitasa
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		java.net.URL imageURL = MenuView.class.getResource("images/background-menu.jpg");
		if (imageURL != null) {
			ImageIcon icon = new ImageIcon(imageURL);
			g.drawImage(icon.getImage(), 0, -20, null);
		}
	}
}