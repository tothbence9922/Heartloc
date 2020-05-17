package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import controller.GameController;
import model.Game;
import model.entity.item.Item;
import model.entity.player.Player;
import model.tiles.Tile;
import view.entity.EntityView;
import view.entity.ItemView;
import view.tiles.TileView;

public class GameView extends JPanel {

	private static final long serialVersionUID = -3883592817908195829L;
	private GameController baseGameController;

	private ArrayList<TileView> tileViews = new ArrayList<TileView>();
	private ArrayList<EntityView> entityViews = new ArrayList<EntityView>();
	private ArrayList<ItemView> itemViews = new ArrayList<ItemView>();

	private JPanel gamePanel;
	private JPanel buttonsPanel;

	private JButton btnShovel;
	private JButton btnFood;
	private JButton btnExplore;
	private JButton btnIgloo;
	private JButton btnTent;
	private JButton btnDrop;


	private JButton curPlayerIndicator;

	public static boolean syncObject = false;
	private static GameView singleInstance = null;

	public static GameView getInstance(GameController baseGameController) {
		try {
			if (singleInstance == null)
				singleInstance = new GameView(baseGameController);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return singleInstance;
	}

	public void addView(Tile t, TileView v) {
		v.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("move " + Game.playerID + " " + t.getId());
			}
		});
		tileViews.add(v);
	}

	public void addView(EntityView v) {
		entityViews.add(v);
	}

	public void addView(ItemView v) {
		itemViews.add(v);
	}

	private void clearPanel() {
		this.removeAll();
	}

	private void drawPanel() {
		for (Player p : Game.getPlayers()) {
			if (p.getId() == Game.getPlayerID()) {
				curPlayerIndicator = new JButton("");
				curPlayerIndicator.setIcon(new ImageIcon(MenuView.class.getResource("images/arrow-slim.png")));
				curPlayerIndicator.setLayout(null);
				curPlayerIndicator.setOpaque(false);
				curPlayerIndicator.setContentAreaFilled(false);
				curPlayerIndicator.setBorderPainted(false);
				curPlayerIndicator.setFocusable(false);
				int x = p.view.getX();
				int y = p.view.getY();
				int width = 10;
				int height = 30;
				curPlayerIndicator.setBounds(x + p.view.getWidth() / 2 - width / 2, y - height, width, height);
			}
		}
		add(curPlayerIndicator);
		for (EntityView ev : entityViews)
			add(ev);
		for (ItemView iv : itemViews)
			add(iv);
		for (TileView tv : tileViews)
			add(tv);

	}

	public void updatePanel() {
		clearPanel();
		drawPanel();
		try {
			buildHUD();
			validate();
			repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private GameView(GameController baseGameController) throws IOException {
		this.baseGameController = baseGameController;

		setLayout(new BorderLayout());

		gamePanel = new JPanel(new GridBagLayout());
		buttonsPanel = new JPanel(new GridBagLayout());

		gamePanel.setOpaque(false);

		java.net.URL urlShovel = MenuView.class.getResource("images/shovel.png");
		java.net.URL urlFood = MenuView.class.getResource("images/food.png");
		java.net.URL urlSpecial = MenuView.class.getResource("images/explore.png");
		java.net.URL urlIgloo = MenuView.class.getResource("images/igloo.png");
		java.net.URL urlTent = MenuView.class.getResource("images/tent.png");
    java.net.URL urlDrop = MenuView.class.getResource("images/arrow.png");
		

		ImageIcon iconShovel = new ImageIcon(urlShovel);
		ImageIcon iconFood = new ImageIcon(urlFood);
		ImageIcon iconSpecial = new ImageIcon(urlSpecial);
		ImageIcon iconIgloo = new ImageIcon(urlIgloo);
		ImageIcon iconTent = new ImageIcon(urlTent);
		ImageIcon iconDrop = new ImageIcon(urlDrop);


		Color btnBackgroundColour = new Color(225, 225, 225);

		btnShovel = new JButton("");
		Image temp = iconShovel.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnShovel.setIcon(new ImageIcon(temp));
		btnShovel.setBackground(btnBackgroundColour);
		btnShovel.setFocusPainted(false);

		btnFood = new JButton("");
		temp = iconFood.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnFood.setIcon(new ImageIcon(temp));
		btnFood.setBackground(btnBackgroundColour);
		btnFood.setFocusPainted(false);

		btnExplore = new JButton("");
		temp = iconSpecial.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnExplore.setIcon(new ImageIcon(temp));
		btnExplore.setBackground(btnBackgroundColour);
		btnExplore.setFocusPainted(false);

		btnIgloo = new JButton("");
		temp = iconIgloo.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnIgloo.setIcon(new ImageIcon(temp));
		btnIgloo.setBackground(btnBackgroundColour);
		btnIgloo.setFocusPainted(false);

		btnTent = new JButton("");
		temp = iconTent.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnTent.setIcon(new ImageIcon(temp));
		btnTent.setBackground(btnBackgroundColour);
		btnTent.setFocusPainted(false);

		btnDrop = new JButton("");
		temp = iconDrop.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnDrop.setIcon(new ImageIcon(temp));
		btnDrop.setBackground(btnBackgroundColour);
		btnDrop.setFocusPainted(false);

		buildPanel();
		buildListeners();
	}

	private void buildPanel() throws IOException {
		buildHUD();
	}

	private void buildHUD() throws IOException {
		add(gamePanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weighty = 1;

		buttonsPanel.setOpaque(false);

		buttonsPanel.add(btnShovel);
		buttonsPanel.add(btnFood);
		buttonsPanel.add(btnExplore);
		buttonsPanel.add(btnIgloo);
		buttonsPanel.add(btnTent);

		buttonsPanel.add(btnDrop);
	}

	/**
	 * Add listeners to buttons on the screen
	 * notifies controller
	 */
	private void buildListeners() {
		/**
		 * Listener for dig method
		 * variations include: shovel, fragile shovel, 'hand'
		 */
		btnShovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
			
				boolean hasTool = false;
			
				for (int i = 0; i < Game.getPlayer(Game.playerID).getInventory().size(); i++) {
					if (Game.getPlayer(Game.playerID).getInventory().get(i).dig()) {
						hasTool=true;

						Game.getPlayer(Game.playerID).step("dig " + Game.playerID + " shovel");

						break;
					}
				}
				if(!hasTool) {
					for (int i = 0; i < Game.getPlayer(Game.playerID).getInventory().size(); i++) {
						if (Game.getPlayer(Game.playerID).getInventory().get(i).digWithFragileShovel()) {
							hasTool=true;

							Game.getPlayer(Game.playerID).step("dig " + Game.playerID + " fragileshovel");

							break;
						}
					}
				}

				else {
					Game.getPlayer(Game.playerID).step("dig " + Game.playerID);
				}
			}
		});

		/**
		 * Listener for eat method so that players could heal
		 */
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useFood " + Game.playerID);
			}
		});

		/**
		 * Listener for Explorer's ability 
		 * checks capacity of nearby Tiles
		 */
		btnExplore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useSpecial " + Game.playerID);
			}
		});

		/**
		 * Listener for Eskimo's ability
		 * builds an Igloo on the current Tile
		 */
		btnIgloo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("buildIgloo" + Game.playerID);
			}
		});

		/**
		 * Listener for building a tent
		 * builds a tent on the current Tile
		 */
		btnTent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useTent" + Game.playerID);
			}
		});

		btnTentItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useTentitem" + Game.playerID);
			}
		});
		btnWetsuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useWetsuit" + Game.playerID);
			}
		});
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("drop " + Game.playerID);
			}
		});
		/*
		 * btnRocket.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent click) {
		 * Game.getPlayer(Game.playerID).step("useRocket" + Game.playerID); } });
		 */

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				Rectangle rect = new Rectangle(p);
				rect.width = rect.height = 1;

				for (Tile t : Game.getTiles()) {
					Rectangle r = new Rectangle(t.view.getX(), t.view.getY(), 128, 128);
					if (r.intersects(rect))
						Game.getPlayer(Game.playerID).step("move " + Game.playerID + " " + t.getId());
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// implement methods for mouse event
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// implement methods for mouse event
			}

			/**
			 * Az eger jobb gombbal torteno kattintasara megjelenit egy osszegzo
			 * panelt, amin bal oldalt a jatekban reszt vevok ID-ja, elete es munkakedve 
			 * jelenik meg, jobb oldalt pedig az aktualis jatekos neve es 
			 * az inventoryjaban levo Itemek nevei
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					JPanel panel = new JPanel(new BorderLayout());

					JPanel statsPanel = new JPanel(new GridBagLayout());
					JPanel currentPlayerPanel = new JPanel(new GridBagLayout());

					statsPanel.setOpaque(false);
					currentPlayerPanel.setOpaque(false);
					panel.setOpaque(false);

					panel.add(statsPanel, BorderLayout.WEST);
					panel.add(currentPlayerPanel, BorderLayout.EAST);

					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridwidth = GridBagConstraints.REMAINDER;
					gbc.anchor = GridBagConstraints.NORTH;
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.weighty = 0;

					Font font = null;
					try {
						font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/CHILLER.TTF"));
					} catch (FontFormatException | IOException ex) {
						ex.printStackTrace();
					}

					JLabel title = new JLabel("Player name \t | Temp \t | Capability");
					title.setFont(font.deriveFont(Font.PLAIN, 24f));
					statsPanel.add(title, gbc);
					for (Player p : Game.getPlayers()) {
						JLabel tempLabel = new JLabel(
								p.getId() + "  " + p.getBodyTemperature() + "  " + p.getEnergy());
						tempLabel.setFont(font.deriveFont(Font.PLAIN, 48f));
						statsPanel.add(tempLabel, gbc);
					}

					JLabel titleCurrentPlayerPanel = new JLabel("Current Player: " + Game.playerID);
					titleCurrentPlayerPanel.setFont(font.deriveFont(Font.PLAIN, 48f));
					currentPlayerPanel.add(titleCurrentPlayerPanel, gbc);

					JLabel itemsCurrentPlayer = new JLabel("Items:");
					itemsCurrentPlayer.setFont(font.deriveFont(Font.PLAIN, 24f));
					currentPlayerPanel.add(itemsCurrentPlayer, gbc);

					for (Item i : Game.getPlayer(Game.playerID).getInventory()) {
						JLabel tempLabel = new JLabel(i.getId());
						tempLabel.setFont(font.deriveFont(Font.PLAIN, 36f));
						currentPlayerPanel.add(tempLabel, gbc);
					}

					UIManager.put("OptionPane.minimumSize", new Dimension(640, 20));
					UIManager.put("OptionPane.background", new ColorUIResource(204, 255, 255));
					UIManager.put("Panel.background", new ColorUIResource(204, 255, 255));
					JOptionPane.showMessageDialog(baseGameController.getGameFrame(), panel, "Inventory",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// implement methods for mouse event
			}

		});
	}

	public JPanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(JPanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	/**
	 * JPanel hatterenek ciklussal torteno beallitasa
	 * illetve a mapon levo Tile-ok kozotti szomszedsagi kapcsolatok
	 * megjelenitese egy vilagoskek vonallal
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// setBackground(Color.BLUE);
		java.net.URL imgWaterDeep = MenuView.class.getResource("images/iceWaterDeep.png");
		java.net.URL imgWaterDeepAlt = MenuView.class.getResource("images/iceWaterDeepAlt.png");

		if (imgWaterDeep != null && imgWaterDeepAlt != null) {
			ImageIcon waterDeep = new ImageIcon(imgWaterDeep);
			ImageIcon waterDeepAlt = new ImageIcon(imgWaterDeepAlt);

			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 11; j++) {
					if (i % 2 != 0) {
						g.drawImage(waterDeep.getImage(), i * 70, j * 70, null);
					} else {
						g.drawImage(waterDeepAlt.getImage(), i * 70, j * 70, null);
					}
				}
			}
		}

		for (Tile t : Game.getTiles()) {
			for (Tile neigh : t.getNeighbours()) {
				int x1, y1, x2, y2;
				x1 = t.view.getX() + t.view.getWidth() / 2;
				y1 = t.view.getY() + t.view.getHeight() / 2;
				x2 = neigh.view.getX() + neigh.view.getWidth() / 2;
				y2 = neigh.view.getY() + neigh.view.getHeight() / 2;
				Color myWhite = new Color(100, 105, 255);
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(10));
				g2.setColor(myWhite);
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}

	public void EndGame(boolean losestate, String msg) {
		EndView end = new EndView(this.baseGameController, losestate, msg);
		this.baseGameController.EndGame(end);
	}
}
