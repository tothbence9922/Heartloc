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
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import controller.GameController;
import controller.GameRunner;
import model.Game;
import model.entity.Snow;
import model.entity.item.Item;
import model.entity.player.Player;
import model.tiles.Tile;
import view.entity.BuildingView;
import view.entity.EntityView;
import view.entity.HoleView;
import view.entity.ItemView;
import view.entity.SnowView;
import view.tiles.TileView;

/**
 * A jatek soran hasznalt fo view, Singleton tervezesi modszert alkalmazva:
 * privat konstruktora van, ra referenciat egy statikus getInstance metodussal
 * lehet szerezni, mely az elso meghivas alkalmaval inicializalja is az osztalyt
 */
public class GameView extends JPanel {

	private static final long serialVersionUID = -3883592817908195829L;
	private GameController baseGameController;

	/**
	 * Game soran hasznalt view tarolok
	 */
	private ArrayList<TileView> tileViews = new ArrayList<TileView>();
	public static ArrayList<Tile> tiles = new ArrayList<Tile>();
	private ArrayList<EntityView> entityViews = new ArrayList<EntityView>();
	private ArrayList<ItemView> itemViews = new ArrayList<ItemView>();
	private ArrayList<SnowView> snowViews = new ArrayList<SnowView>();
	private ArrayList<BuildingView> buildingViews = new ArrayList<BuildingView>();
	private ArrayList<HoleView> holeViews = new ArrayList<HoleView>();
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();

	/**
	 * Game-ben hasznalt panelek, az elsoben a jatek rajzolodik ki, a massodikban
	 * pedig a jatek iranyitasara szolgalo gombok
	 */
	private JPanel gamePanel;
	private JPanel buttonsPanel;

	/**
	 * A jatek iranyitasara szolgalo gombok
	 */
	private JButton btnShovel;
	private JButton btnFood;
	private JButton btnExplore;
	private JButton btnIgloo;
	private JButton btnTent;
	private JButton btnDrop;
	private JButton btnRocket;

	/**
	 * Aktualis jatekost jelolo (2020.05.17 idopontban a feje felett megjeleno),
	 * listener nelkuli indikator
	 */
	private JButton curPlayerIndicator;

	public static boolean syncObject = false;
	private static GameView singleInstance = null;
	public static boolean usingSpecial = false;

	/**
	 * Singleton tervezesi mintat kovetve kialakitott getInstance metodus
	 * 
	 * @param baseGameController
	 * @return GameView referencia
	 */
	public static GameView getInstance(GameController baseGameController) {
		try {
			if (singleInstance == null)
				singleInstance = new GameView(baseGameController);
			tiles = Game.getTiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return singleInstance;
	}

	/**
	 * Eltavolit egy Itemet a panelrol
	 * 
	 * @param view
	 */
	public void removeItemView(EntityView view) {
		itemViews.clear();
		updatePanel();
	}

	/**
	 * Eltavolit egy havat abrazolo hogolyot a panelrol
	 * 
	 * @param view
	 */
	public void removeSnowView(EntityView view) {
		snowViews.clear();
		updatePanel();
	}

	/**
	 * Uj view-t es egy listenert ad hozza valamennyi tile-hoz
	 * 
	 * @param t - tile
	 * @param v - tile-hoz tartozo view
	 */
	public void addView(Tile t, TileView v) {
		tileViews.add(v);
	}

	/**
	 * Uj view-t es egy listenert ad hozza valamennyi tile-hoz
	 * 
	 * @param t - tile
	 * @param v - tile-hoz tartozo view
	 */
	public void addView(HoleView hv) {
		holeViews.add(hv);
	}

	/**
	 * Entity view-t ad hozza a panelhez
	 * 
	 * @param v
	 */
	public void addView(EntityView v) {
		entityViews.add(v);
	}

	/**
	 * Item view-t ad hozza a panelhez
	 * 
	 * @param v
	 */
	public void addView(ItemView v) {
		itemViews.add(v);
	}

	/**
	 * JLabel-t ad hozza a panelhez, melyeken lathato lesz adott tileok kapacitasa
	 * 
	 * @param v
	 */
	public void addLabel(JLabel v) {
		labels.add(v);
	}

	/**
	 * Building view-t ad hozza a panelhez
	 * 
	 * @param v
	 */
	public void addView(BuildingView v) {
		buildingViews.add(v);
	}

	/**
	 * Snow view-t ad hozza a panelhez
	 * 
	 * @param v
	 */
	public void addView(SnowView v) {
		snowViews.add(v);
	}

	/**
	 * Kirajzolja az osszes, a jatekban jelenlevo viewt olyan sorrendben, hogy ne
	 * fedjek egymast (swing forditott sorrendben jarja be a dolgokat, tehat az
	 * utoljara hozzaadott kerul eloszor kirajzolasra
	 */
	private void drawPanel() {
		for (Player p : Game.getPlayers()) {
			if (p.getId() == Game.getPlayerID()) {
				curPlayerIndicator = new JButton("");
				curPlayerIndicator.setIcon(new ImageIcon(this.getClass().getResource("images/arrow-slim.png")));
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
		for (EntityView ev : entityViews) {
			add(ev);
		}
		for (ItemView iv : itemViews) {
			iv.setLayout(null);
			add(iv);
		}
		for (Tile t : tiles) {
			int sc = 1;
			for (Snow s : t.getSnows()) {
				SnowView sv = new SnowView(GameRunner.baseGameController);
				s.view= sv;
				sv.setLayout(null);
				sv.setPos(t.view.getX() + sc * 10, t.view.getY() + 105);
				sc++;
				add(sv);
			}
		}
		for (HoleView hv : holeViews) {
			add(hv);
		}
		for (BuildingView bv : buildingViews) {
			add(bv);
		}
		for (JLabel jl : labels) {
			add(jl);
		}
		for (TileView tv : tileViews) {
			add(tv);
		}

	}

	/**
	 * a view ujrarajzolasa, mely valtoztatasok eseten kerul meghivasra
	 */
	public void updatePanel() {
		removeAll();
		drawPanel();
		try {
			buildHUD();
			revalidate();
			repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private GameView(GameController baseGameController) throws IOException {
		this.baseGameController = baseGameController;

		setLayout(new BorderLayout());

		gamePanel = new JPanel(new GridBagLayout());
		buttonsPanel = new JPanel(new GridBagLayout());

		gamePanel.setOpaque(false);

		/**
		 * Kepek eleresi helyenek megszerzese olyan modon, hogy bundling utan is
		 * megtalalja oket
		 */
		java.net.URL urlShovel = this.getClass().getResource("images/shovel.png");
		java.net.URL urlFood = this.getClass().getResource("images/food.png");
		java.net.URL urlSpecial = this.getClass().getResource("images/explore.png");
		java.net.URL urlIgloo = this.getClass().getResource("images/igloo.png");
		java.net.URL urlTent = this.getClass().getResource("images/tent.png");
		java.net.URL urlDrop = this.getClass().getResource("images/arrow.png");
		java.net.URL urlRocket = this.getClass().getResource("images/rocket.png");

		/**
		 * ImageIconok keszitese a kinyert eleresi utvonalakkal
		 */
		ImageIcon iconShovel = new ImageIcon(urlShovel);
		ImageIcon iconFood = new ImageIcon(urlFood);
		ImageIcon iconSpecial = new ImageIcon(urlSpecial);
		ImageIcon iconIgloo = new ImageIcon(urlIgloo);
		ImageIcon iconTent = new ImageIcon(urlTent);
		ImageIcon iconDrop = new ImageIcon(urlDrop);
		ImageIcon iconRocket = new ImageIcon(urlRocket);

		Color btnBackgroundColour = new Color(225, 225, 225);

		/**
		 * Gombok inicializalasa: hatter, ikon es a fokusz letiltasanak beallitasa
		 */
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

		btnRocket = new JButton("");
		temp = iconRocket.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnRocket.setIcon(new ImageIcon(temp));
		btnRocket.setBackground(btnBackgroundColour);
		btnRocket.setFocusPainted(false);

		/**
		 * Panel elkeszitese a fent inicializalt gombokkal
		 */
		buildPanel();

		/**
		 * Listenerek hozzaadasa a fentebb inicializalt gombokhoz
		 */
		buildListeners();
	}

	private void buildPanel() throws IOException {
		buildHUD();
	}

	/**
	 * Hozzaadja az osszes gombot a Heads-up-Displayhez, ami a kepernyo aljan,
	 * kozepen jelenik meg, es segitsegevel valik iranyithatova a jatek (kivetel ez
	 * alol a mozgas, ami a tile-okra kattintassal oldhato meg
	 * 
	 * @throws IOException
	 */
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
		buttonsPanel.add(btnRocket);
	}

	/**
	 * Uj ertek hozzaadas egy Object tombhoz
	 * 
	 * @param obj
	 * @param newObj
	 * @return
	 */
	private Object[] appendValue(Object[] obj, Object newObj) {

		ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
		temp.add(newObj);
		return temp.toArray();

	}

	/**
	 * Listenerek hozzaadasa a gombokhoz
	 */
	private void buildListeners() {
		/**
		 * Listener for dig method variations include: shovel, fragile shovel, 'hand'
		 */
		btnShovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).dig();
				Game.getPlayer(Game.playerID).step();

			}
		});

		/**
		 * Ha a jatekos taskajaban talalhato Food, akkor azt ezzel a gombbal el tudja
		 * hasznalni, ezatlal megnovelve sajat eletet
		 */
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {

				Game.getPlayer(Game.playerID).eat();
				Game.getPlayer(Game.playerID).step();

			}
		});

		/**
		 * Explorerek kepesseget erre a gombra torteno kattintassal lehet aktivalni:
		 * ilyenkor felugrik egy panel, amibol kivalaszthato, hogy melyik mezonek a
		 * teherbirasat szeretnenk megkapni
		 */
		btnExplore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				usingSpecial = true;

				/**
				 * A JOptionPanelben megjelenitendo gombok szovegeit tartalmazo object tomb
				 */
				Object[] options = { "" };

				/**
				 * Szomszedos mezok megkeresese, ID-k (string) hozzaadasa az options tarolohoz
				 */
				for (int i = 0; i < Game.getPlayer(Game.playerID).getCurrentTile().getNeighbours().size(); i++) {
					options = appendValue(options,
							Game.getPlayer(Game.playerID).getCurrentTile().getNeighbours().get(i).getId());
				}

				/**
				 * Options taroloban elso elemkent szerepel egy "", ezert itt balra shiftelunk
				 * egyel
				 */
				Object[] newOptions = Arrays.copyOfRange(options, 1, options.length);

				/**
				 * A JOptionPanelben megjelenitendo gombok 0-1-2... ertekekkel ternek vissza, ha
				 * rajuk kattintunk, ezt taroljuk el egy valtozoban
				 */
				int n = JOptionPane.showOptionDialog(baseGameController.getGameFrame(),
						"Which tile would you like to explore?", "Explore a Tile!", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, newOptions, null);

				/**
				 * Ha X-szel zartuk be a panel, akkor a visszateresi ertek -1, amit a get()
				 * fuggvenyben hasznalva eleresi hibat dobna, ezzel ezt kizarjuk
				 */
				if (n != -1) {

					boolean canExplore;
					int value = Game.getPlayer(Game.playerID)
							.exploreTile(Game.getPlayer(Game.playerID).getCurrentTile().getNeighbours().get(n).getId());

					if (value == -2)
						canExplore = false;
					else {
						canExplore = true;
						Game.getPlayer(Game.playerID).step();

					}
					if (!canExplore) {
						JOptionPane.showMessageDialog(baseGameController.getGameFrame(), "You can't explore, sorry.",
								"Explore(r) error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		/**
		 * Eskimok kepesseget erre a gombra torteno kattintassal lehet aktivalni:
		 * ilyenkor egy uj Igloo epul azon a Tile-on, amelyiken az Eskimo a gombra
		 * kattintas pillanataban all
		 */
		btnIgloo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				boolean builded = Game.getPlayer(Game.playerID).buildIgloo();
				if (builded) {
					Game.getPlayer(Game.playerID).step();
					Game.view.updatePanel();
				} else {

					JOptionPane.showMessageDialog(baseGameController.getGameFrame(), "You can't build an Igloo, sorry.",
							"Igloo build error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		/**
		 * Tentet epit az aktualis mezore, ha van a jatekos taskajaban TentItem
		 */
		btnTent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).buildTent();
				Game.getPlayer(Game.playerID).step();

			}
		});

		/**
		 * Eldobja a jatekos inventoryjabol a 0. elemet, igy egyreszt adhato etel a
		 * raszorulo csapattarsnak, valamint a jatek megnyeresehez is hasznalni kell,
		 * mivel cel, hogy mindegyik item egy tile-on legyen
		 */
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).drop();
				Game.getPlayer(Game.playerID).step();

			}
		});

		/**
		 * Ha valamennyi szukseges item a birtokunkban van, akkor ezzel a gombbal
		 * suthetjuk el a rocketet, amivel a jatekot meg tudjuk nyerni
		 */
		btnRocket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Game.getPlayer(Game.playerID).assembleRocket();
				Game.getPlayer(Game.playerID).step();

			}
		});

		/**
		 * Eger kattintasanak detektalasa
		 */
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
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
			 * Az eger jobb gombbal torteno kattintasara megjelenit egy osszegzo panelt,
			 * amin bal oldalt a jatekban reszt vevok ID-ja, elete es munkakedve jelenik
			 * meg, jobb oldalt pedig az aktualis jatekos neve es az inventoryjaban levo
			 * Itemek nevei
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

					/**
					 * Jobb es bal oldali panelek hozzaadasa
					 */
					panel.add(statsPanel, BorderLayout.WEST);
					panel.add(currentPlayerPanel, BorderLayout.EAST);

					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridwidth = GridBagConstraints.REMAINDER;
					gbc.anchor = GridBagConstraints.NORTH;
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.weighty = 0;

					/**
					 * Hasznalt betutipus beallitasa
					 */
					Font font = null;
					try {
						font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/CHILLER.TTF"));
					} catch (FontFormatException | IOException ex) {
						ex.printStackTrace();
					}

					/**
					 * Cim a bal oldali panelen megjeleno adatoknak
					 */
					JLabel title = new JLabel("Player name \t | Temp \t | Capability");
					title.setFont(font.deriveFont(Font.PLAIN, 24f));
					statsPanel.add(title, gbc);

					/**
					 * Bal oldali panel feltoltese a jatekosok adataival
					 */
					for (Player p : Game.getPlayers()) {
						JLabel tempLabel = new JLabel(
								p.getId() + " - " + p.getBodyTemperature() + " - " + p.getEnergy());
						tempLabel.setFont(font.deriveFont(Font.PLAIN, 48f));
						statsPanel.add(tempLabel, gbc);
					}

					/**
					 * Cim a jobb oldali panelen megjeleno adatoknak
					 */
					JLabel titleCurrentPlayerPanel = new JLabel("Current Player: " + Game.playerID);
					titleCurrentPlayerPanel.setFont(font.deriveFont(Font.PLAIN, 48f));
					currentPlayerPanel.add(titleCurrentPlayerPanel, gbc);

					JLabel itemsCurrentPlayer = new JLabel("Items:");
					itemsCurrentPlayer.setFont(font.deriveFont(Font.PLAIN, 24f));
					currentPlayerPanel.add(itemsCurrentPlayer, gbc);

					/**
					 * A jobb oldali panel feltoltese a jatekos inventoryjaban levo dolgokkal
					 */
					for (Item i : Game.getPlayer(Game.playerID).getInventory()) {
						JLabel tempLabel = new JLabel(i.getId());
						tempLabel.setFont(font.deriveFont(Font.PLAIN, 36f));
						currentPlayerPanel.add(tempLabel, gbc);
					}

					/**
					 * A megjelenitett JOptionPane parametereinek beallitasara kulon UIManager-t
					 * hasznalunk. Igy konnyen allithato a kivant minimum meret es a hatterszin
					 */
					UIManager.put("OptionPane.minimumSize", new Dimension(640, 20));
					UIManager.put("OptionPane.background", new ColorUIResource(204, 255, 255));
					UIManager.put("Panel.background", new ColorUIResource(204, 255, 255));
					JOptionPane.showMessageDialog(baseGameController.getGameFrame(), panel, "Inventory",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				/**
				 * Osszes tile-on vegigiteral, ha a kattintas helye (a krealt rect) az egyiknek
				 * a hatarain belul talalhato, akkor oda mozgatja a jatekost (amennyiben az a
				 * tile szomszedos azzal, amelyiken a jatekos all)
				 * 
				 * @see player.move
				 */
				for (Tile t : Game.getTiles()) {
					/**
					 * Rectangle letrehozasa a kattintasok pontosabb meghatarozasahoz, kezelesehez
					 */
					Rectangle rect = new Rectangle(t.view.getX(), t.view.getY(), t.view.getWidth(), t.view.getHeight());
					if (rect.contains(e.getPoint())) {
						Game.getPlayer(Game.playerID).move(t);
						Game.getPlayer(Game.playerID).step();
					}
				}
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
	 * JPanel hatterenek ciklussal torteno beallitasa illetve a mapon levo Tile-ok
	 * kozotti szomszedsagi kapcsolatok megjelenitese egy vilagoskek vonallal
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// setBackground(Color.BLUE);
		java.net.URL imgWaterDeep = this.getClass().getResource("images/iceWaterDeep.png");
		java.net.URL imgWaterDeepAlt = this.getClass().getResource("images/iceWaterDeepAlt.png");

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

		/**
		 * A jatekban a szomszedos mezok koze egy vilagos szinu vonalat rajzol, egyfele
		 * vizualis visszajelzest adva
		 */
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

	/**
	 * Jatek veget elindito fuggveny
	 * 
	 * @param losestate
	 * @param msg
	 */
	public void EndGame(boolean losestate, String msg) {
		EndView end = new EndView(this.baseGameController, losestate, msg);
		this.baseGameController.EndGame(end);
	}
}
