package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.GameController;

/**
 * A fomenubol a Start gombra torteno kattintas utan jelenik meg ez a menu, itt
 * kivalaszthato, hogy melyik palyan szeretnenk jatszani, valamint, hogy mennyi
 * jatekossal, ha a jatekosok mennyisegen nem valtoztatunk az alpertelmezett jkerul betoltesre.
 *
 */
public class MapSelectionView extends JPanel {
	//Alapertelmezett jatekosmennyisegek
	int numOfEsk = 2;
	int numOfExp = 1;

	private static final long serialVersionUID = -7780612029288723490L;
	/**
	 * Az MVC modell megvalostasahoz szukseges modon eltarlunk egy GameController entitast.
	 */
	private GameController baseGameController;
	/**
	 * A felhasznalot segito label utasitjuk ot, hogy valasszon egy palyat.
	 */
	private JLabel labelSelect;
	/**
	 * Ezzel a gombbal elindul a jatek, betoltodik a kivalasztott palya
	 */
	private JButton btnStartGame;
	/**
	 * 
	 * Ezzel a gombbal lephetunk vissza az elozo menube
	 */
	private JButton btnBack;
	/**
	 * 
	 * A Panel Layout-ja
	 */
	private GridBagLayout baseLayout;
	/**
	 * 
	 * Innen olvassuk be a kivalasztott paplyat
	 */
	private JTextField mapTextField;
	/*
	 * 
	 * Itt adhato meg az eszkimok szama a palyan
	 */
	private JTextField eskTextField;
	/**
	 * 
	 * Itt adhato meg a felfedezok szama a palyan
	 */
	private JTextField expTextField;

	public MapSelectionView(GameController baseGameController) {
		this.baseGameController = baseGameController;

		Font font = null;
		try {
			//A betutipus beallitasa
			font = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("fonts/CHILLER.TTF"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		//AJatekost utasito szoveg beallitasa es betutipusanak beallitasa
		labelSelect = new JLabel("Select a map!");
		labelSelect.setFont(font.deriveFont(Font.PLAIN, 120f));
		labelSelect.setForeground(Color.WHITE);

		baseLayout = new GridBagLayout();

		/**
		 * Input mezok inicializalasa es formazasa
		 */
		mapTextField = new JTextField();
		mapTextField.setFont(font.deriveFont(Font.PLAIN, 60f));

		eskTextField = new JTextField();
		eskTextField.setFont(font.deriveFont(Font.PLAIN, 60f));
		eskTextField.setText("Enter the number of eskimos! Default: 2");

		expTextField = new JTextField();
		expTextField.setText("Enter the number of explorers! Default: 1");
		expTextField.setFont(font.deriveFont(Font.PLAIN, 60f));

		/**
		 * Gombok hozzaadasa a panelhez, ezeket formazzuk meg a lenti modon, tobbek kozott:
		 * Font meret,kinezet beallitasa, gomb hatterszinenek es korvonalanak letiltasa
		 */
		btnStartGame = new JButton("Start");
		btnStartGame.setForeground(Color.DARK_GRAY);
		btnStartGame.setFont(font.deriveFont(Font.PLAIN, 48f));
		// disable background color and focus outline
		btnStartGame.setOpaque(false);
		btnStartGame.setContentAreaFilled(false);
		btnStartGame.setBorderPainted(false);
		btnStartGame.setFocusPainted(false);

		/**
		 * A fentihez hasonlo modon jarunk el az exit gombnal is
		 */
		btnBack = new JButton("Exit");
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setFont(font.deriveFont(Font.PLAIN, 48f));
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);

		// A Panel felepitese es Listenerek hozzaadasa a komponensekhez
		buildPanel();
		buildListeners();
	}

	/**
	 * A panel strukturajaert felelos fuggveny, itt allutjuk be tobbek kozott a gombok,labelek elrendezeset
	 * Itt kerulnek a fent emlitett komponensek hozzáadása a panelhez
	 */
	private void buildPanel() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weighty = 1;

		JPanel buttons = new JPanel(new GridBagLayout());
		buttons.add(btnStartGame, gbc);
		buttons.add(btnBack, gbc);
		buttons.setOpaque(false); // do not display background over the other panel

		this.setLayout(baseLayout);
		this.add(labelSelect, gbc);
		this.add(mapTextField, gbc);
		this.add(expTextField, gbc);
		this.add(eskTextField, gbc);
		this.add(buttons, gbc);
	}

	/**
	 * Listenerek letrehozasa a gombokhoz
	 */
	private void buildListeners() {
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String selectedMap = mapTextField.getText();
				/**
				 * Ha a user nem adott meg kulon palyat, akkor a map1-et tolti be
				 */
				if (selectedMap.contentEquals(""))
					selectedMap = "map1";

				/**
				 * A maximalisan beallithato eskimok szamat 5-ben maximalizalja
				 */
				try {
					numOfEsk = Integer.parseInt(eskTextField.getText());
				} catch (NumberFormatException e) {
					numOfEsk = 2;
					if (numOfEsk > 5)
						numOfEsk = 5;
				}

				/**
				 * A maximalisan beallithato explorerek szamat 5-ben maximalizalja
				 */
				try {
					numOfExp = Integer.parseInt(expTextField.getText());
					if (numOfExp > 5)
						numOfExp = 5;
				} catch (NumberFormatException e) {
					numOfExp = 1;
				}
				String[] tokens = { "loadMap", selectedMap };

				boolean gameSet = baseGameController.setGame(tokens, numOfEsk, numOfExp);

				if (gameSet)
					baseGameController.getGameFrame().changePanel(GameView.getInstance(baseGameController));
			}
		});

		eskTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				eskTextField.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
			}
		});
		eskTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				//A valaszottt palya beolvasasa a textfield-rol
				String selectedMap = mapTextField.getText();
				try {
					numOfEsk = Integer.parseInt(eskTextField.getText());
				} catch (NumberFormatException e) {
					numOfEsk = 2;
				}
				try {
					numOfExp = Integer.parseInt(expTextField.getText());
				} catch (NumberFormatException e) {
					numOfExp = 1;
				}
				String[] tokens = { "loadMap", selectedMap };

				boolean gameSet = baseGameController.setGame(tokens, numOfEsk, numOfExp);

				if (gameSet)
					//A panel megvaltoztatasa annak szerit , milyen gombot nyomtunk le.
					baseGameController.getGameFrame().changePanel(GameView.getInstance(baseGameController));

			}
		});

		mapTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				
				String selectedMap = mapTextField.getText();
				try {
					numOfEsk = Integer.parseInt(eskTextField.getText());
				} catch (NumberFormatException e) {
					numOfEsk = 2;
				}
				try {
					numOfExp = Integer.parseInt(expTextField.getText());
				} catch (NumberFormatException e) {
					numOfExp = 1;
				}
				String[] tokens = { "loadMap", selectedMap };

				boolean gameSet = baseGameController.setGame(tokens, numOfEsk, numOfExp);

				if (gameSet)
					baseGameController.getGameFrame().changePanel(GameView.getInstance(baseGameController));

			}
		});

		expTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				expTextField.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
			}
		});

		// add hover effect
		btnStartGame.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnStartGame.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnStartGame.setForeground(Color.DARK_GRAY);
			}
		});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				baseGameController.getGameFrame().changePanel(new MenuView(baseGameController));
			}
		});

		btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnBack.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnBack.setForeground(Color.DARK_GRAY);
			}
		});
	}
	/**
	 * 
	 * A Panel grafikus megjelenitese a felhasznalo szamara.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		java.net.URL imageURL = this.getClass().getResource("images/background-menu.jpg");
		if (imageURL != null) {
			ImageIcon icon = new ImageIcon(imageURL);
			g.drawImage(icon.getImage(), 0, -20, null);
		}
	}
}