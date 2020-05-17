package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.GameController;
import model.Game;
import model.entity.player.Player;
import model.tiles.Tile;
import view.entity.BeaconView;
import view.entity.EntityView;
import view.entity.EskimoView;
import view.entity.ExplorerView;
import view.entity.GunView;
import view.entity.ItemView;
import view.entity.PlayerView;
import view.entity.PolarBearView;
import view.entity.RocketView;
import view.entity.RopeView;
import view.entity.ShovelView;
import view.entity.TentView;
import view.tiles.TileView;

public class GameView extends JPanel {

	private static final long serialVersionUID = -3883592817908195829L;
	private GameController baseGameController;

	private ArrayList<TileView> tileViews = new ArrayList<TileView>();
	private ArrayList<EntityView> entityViews = new ArrayList<EntityView>();
	private ArrayList<ItemView> itemViews = new ArrayList<ItemView>();

	private JPanel gamePanel;
	private JPanel buttonsPanel;

	private JLabel labelGame;

	private JButton btnRope;
	private JButton btnShovel;
	private JButton btnFood;
	private JButton btnCartridge;
	private JButton btnGun;
	//private JButton btnBeacon;
	private JButton btnSpecial;

	private JButton curPlayerIndicator;
  private JButton btnIgloo;
	private JButton btnTent;
	private JButton btnTentItem;
	private JButton btnWetsuit;
	private JButton btnBuild;
	//private JButton btnRocket;


	public static boolean syncObject = false;

	private static GameView singleInstance = null;

	private GridBagLayout baseLayout;

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
				Game.getPlayer(Game.playerID).step("move " + Game.playerID + " " +t.getId());
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
				curPlayerIndicator.setIcon(new ImageIcon(MenuView.class.getResource("images/gun.png")));
				curPlayerIndicator.setLayout(null);
				curPlayerIndicator.setOpaque(false);
				curPlayerIndicator.setContentAreaFilled(false);
				curPlayerIndicator.setBorderPainted(false);
				curPlayerIndicator.setFocusable(false);
				int x = p.view.getX();
				int y = p.view.getY();
				int width = 10;
				int height = 30;
				curPlayerIndicator.setBounds(x + p.view.getWidth()/2 - width/2, y - height, width, height);
				System.out.println(String.valueOf(p.view.getX()) +"  "+ String.valueOf(p.view.getY()));
				
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

		baseLayout = new GridBagLayout();
		gamePanel.setOpaque(false);

		/*
		 * btnRope = new JButton("R"); btnShovel = new JButton("S"); btnFood = new
		 * JButton("F"); btnCartridge = new JButton("C"); btnGun = new JButton("G");
		 * btnFlare = new JButton("F"); btnSpecial = new JButton("*");
		 */

		java.net.URL urlRope = MenuView.class.getResource("images/rope.png");
		java.net.URL urlShovel = MenuView.class.getResource("images/shovel.png");
		java.net.URL urlFood = MenuView.class.getResource("images/food.png");
		java.net.URL urlCartridge = MenuView.class.getResource("images/cartridge.png");
		java.net.URL urlGun = MenuView.class.getResource("images/gun.png");
		//java.net.URL urlBeacon = MenuView.class.getResource("images/beacon.png");
		java.net.URL urlSpecial = MenuView.class.getResource("images/explore.png");
		java.net.URL urlIgloo = MenuView.class.getResource("images/igloo.png");
		java.net.URL urlTent = MenuView.class.getResource("images/tent.png");
		java.net.URL urlTentItem = MenuView.class.getResource("images/tentitem.png");
		java.net.URL urlWetsuit = MenuView.class.getResource("images/wetsuit.png");
		java.net.URL urlBuild = MenuView.class.getResource("images/build.png");
		//java.net.URL urlRocket = MenuView.class.getResource("images/rocket.png");

		ImageIcon iconRope = new ImageIcon(urlRope);
		ImageIcon iconShovel = new ImageIcon(urlShovel);
		ImageIcon iconFood = new ImageIcon(urlFood);
		ImageIcon iconCartridge = new ImageIcon(urlCartridge);
		ImageIcon iconGun = new ImageIcon(urlGun);
		//ImageIcon iconBeacon = new ImageIcon(urlBeacon);
		ImageIcon iconSpecial = new ImageIcon(urlSpecial);
		ImageIcon iconIgloo = new ImageIcon(urlIgloo);
		ImageIcon iconTent = new ImageIcon(urlTent);
		ImageIcon iconTentItem = new ImageIcon(urlTentItem);
		ImageIcon iconWetsuit = new ImageIcon(urlWetsuit);
		ImageIcon iconBuild = new ImageIcon(urlBuild);
		//ImageIcon iconRocket = new ImageIcon(urlRocket);
		
		

		Color btnBackgroundColour = new Color(225, 225, 225);

		btnRope = new JButton("");
		Image temp = iconRope.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnRope.setIcon(new ImageIcon(temp));
		btnRope.setBackground(btnBackgroundColour);
		btnRope.setFocusPainted(false);

		btnShovel = new JButton("");
		temp = iconShovel.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnShovel.setIcon(new ImageIcon(temp));
		btnShovel.setBackground(btnBackgroundColour);
		btnShovel.setFocusPainted(false);

		btnFood = new JButton("");
		temp = iconFood.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnFood.setIcon(new ImageIcon(temp));
		btnFood.setBackground(btnBackgroundColour);
		btnFood.setFocusPainted(false);

		btnCartridge = new JButton("");
		temp = iconCartridge.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnCartridge.setIcon(new ImageIcon(temp));
		btnCartridge.setBackground(btnBackgroundColour);
		btnCartridge.setFocusPainted(false);

		btnGun = new JButton("");
		temp = iconGun.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnGun.setIcon(new ImageIcon(temp));
		btnGun.setBackground(btnBackgroundColour);
		btnGun.setFocusPainted(false);

		// TODO BEACON, STB ITEMEK
		/*btnBeacon = new JButton("");
		temp = iconBeacon.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnBeacon.setIcon(new ImageIcon(temp));
		btnBeacon.setBackground(btnBackgroundColour);
		btnBeacon.setFocusPainted(false);*/
		
		btnSpecial = new JButton("");
		temp = iconSpecial.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnSpecial.setIcon(new ImageIcon(temp));
		btnSpecial.setBackground(btnBackgroundColour);
		btnSpecial.setFocusPainted(false);
		
		btnIgloo = new JButton("");
		temp = iconIgloo.getImage().getScaledInstance(32, 32,java.awt.Image.SCALE_SMOOTH);
		btnIgloo.setIcon(new ImageIcon(temp));
		btnIgloo.setBackground(btnBackgroundColour);
		btnIgloo.setFocusPainted(false);
		
		btnTent = new JButton("");
		temp = iconTent.getImage().getScaledInstance(32, 32,java.awt.Image.SCALE_SMOOTH);
		btnTent.setIcon(new ImageIcon(temp));
		btnTent.setBackground(btnBackgroundColour);
		btnTent.setFocusPainted(false);
		
		btnTentItem = new JButton("");
		temp = iconTentItem.getImage().getScaledInstance(32, 32,java.awt.Image.SCALE_SMOOTH);
		btnTentItem.setIcon(new ImageIcon(temp));
		btnTentItem.setBackground(btnBackgroundColour);
		btnTentItem.setFocusPainted(false);
		
		btnWetsuit = new JButton("");
		temp = iconWetsuit.getImage().getScaledInstance(32, 32,java.awt.Image.SCALE_SMOOTH);
		btnWetsuit.setIcon(new ImageIcon(temp));
		btnWetsuit.setBackground(btnBackgroundColour);
		btnWetsuit.setFocusPainted(false);
		
		btnBuild = new JButton("");
		temp = iconBuild.getImage().getScaledInstance(32, 32,java.awt.Image.SCALE_SMOOTH);
		btnBuild.setIcon(new ImageIcon(temp));
		btnBuild.setBackground(btnBackgroundColour);
		btnBuild.setFocusPainted(false);
		
		/*btnRocket = new JButton("");
		temp = iconRocket.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnRocket.setIcon(new ImageIcon(temp));
		btnRocket.setBackground(btnBackgroundColour);
		btnRocket.setFocusPainted(false);*/
		
		

		buildPanel();
		buildListeners();
	}

	private void buildPanel() throws IOException {
		buildHUD();
		buildGame();
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

		buttonsPanel.add(btnRope);
		buttonsPanel.add(btnShovel);
		buttonsPanel.add(btnFood);
		buttonsPanel.add(btnCartridge);

		buttonsPanel.add(btnGun);
		//buttonsPanel.add(btnBeacon);

		buttonsPanel.add(btnSpecial);
		buttonsPanel.add(btnIgloo);
		buttonsPanel.add(btnTent);
		buttonsPanel.add(btnTentItem);
		buttonsPanel.add(btnWetsuit);
		buttonsPanel.add(btnBuild);
		//buttonsPanel.add(btnRocket);
		
		
		/*
		 * buttonsPanel.add(new EskimoView(baseGameController)); buttonsPanel.add(new
		 * ExplorerView(baseGameController)); buttonsPanel.add(new
		 * PolarBearView(baseGameController)); buttonsPanel.add(new
		 * BeaconView(baseGameController)); buttonsPanel.add(new
		 * GunView(baseGameController)); buttonsPanel.add(new
		 * RocketView(baseGameController)); buttonsPanel.add(new
		 * TentView(baseGameController)); buttonsPanel.add(new
		 * ShovelView(baseGameController)); buttonsPanel.add(new
		 * RopeView(baseGameController));
		 */

		// this.setLayout(baseLayout);
		// this.add(buttonsPanel, gbc);
	}

	private void buildGame() throws IOException {
		// TODO : Based on game information, build the game
	}

	/**
	 * Add listener to the button, notifies controller
	 */
	private void buildListeners() {
		btnRope.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useRope " + Game.playerID);
			}
		});
		btnShovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("dig " + Game.playerID);
			}
		});
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useFood " + Game.playerID);
			}
		});
		btnCartridge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useCartridge " + Game.playerID);
			}
		});
		btnGun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useGun " + Game.playerID);
			}
		});
		/*btnBeacon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useBeacon" + Game.playerID);
			}
		});*/
		// TODO BEACON, STB ITEMEK
		btnSpecial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useSpecial " + Game.playerID);
			}
		});
    
  btnIgloo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useIgloo" + Game.playerID);
			}
		});
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
		btnBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useBuild" + Game.playerID);
			}
		});/*
		btnRocket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).step("useRocket" + Game.playerID);
			}
		});*/
    
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Point p = arg0.getPoint();
				Rectangle rect = new Rectangle(p);
				rect.width = rect.height = 1;
				
				for (Tile t :Game.getTiles()) {
					if (t.view.getBounds().intersects(rect)) Game.getPlayer(Game.playerID).step("move " + Game.playerID +" "+t.getId());
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	public JPanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(JPanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// setBackground(Color.BLUE);
		java.net.URL imgWaterDeep = MenuView.class.getResource("images/iceWaterDeep.png");
		java.net.URL imgWaterDeepAlt = MenuView.class.getResource("images/iceWaterDeepAlt.png");
		java.net.URL imgWaterDeepStar = MenuView.class.getResource("images/iceWaterDeepStars.png");
		java.net.URL imgWaterDeepStarAlt = MenuView.class.getResource("images/iceWaterDeepStarsAlt.png");

		if (imgWaterDeep != null && imgWaterDeepAlt != null) {
			ImageIcon waterDeep = new ImageIcon(imgWaterDeep);
			ImageIcon waterDeepAlt = new ImageIcon(imgWaterDeepAlt);
			ImageIcon waterDeepStars = new ImageIcon(imgWaterDeepStar);
			ImageIcon waterDeepStarsAlt = new ImageIcon(imgWaterDeepStarAlt);

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
	
	public void EndGame(boolean losestate){
		EndView end = new EndView(this.baseGameController, losestate);
		this.baseGameController.EndGame(end);
		
	}
}
