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
 * 
 * A kezdomenu megjelenitiseert felelos osztaly, a program elindulasa utan ez az ablak jelenik meg,
 * A jatekos elindithata a jatekot a start gombbal, ekkor meg kell adnia a kovetkezoekben melyik palyan
 * szeretne jatszani vagy az exit gombbal kilephet a jatekbol es ekkor a program leall.
 * @author Gabor
 *
 */
public class MenuView extends JPanel {

	private static final long serialVersionUID = -5113606236074548822L;
	/**
	 * 
	 * Az MVC megvalositasaert tarolunk egy GameController entitast is.
	 */
	private GameController baseGameController;
	/**
	 * A Jatek evenek grafikus megjeleniteseert felelo label.
	 * 
	 */
	private JLabel labelGame;
	/*
	 * 
	 * A jatek elinditasaaert felelos button.
	 */
	private JButton btnStartGame;
	/**
	 * 
	 * A jatekbol valo kilepest valositja meg ez a gomb
	 */
	private JButton btnExit;
	/**
	 * 
	 * A Layout beallitasa GridBagLayout-ra
	 */
	private GridBagLayout baseLayout;
	
	public MenuView(GameController baseGameController) {
		this.baseGameController = baseGameController;
		
		Font font = null;
		try {
			//A betutipius beallitasa
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/CHILLER.TTF"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}  

		//A jatek nevenek beallitasa
		labelGame = new JLabel("Heartloc");
		labelGame.setFont(font.deriveFont(Font.PLAIN, 120f));
		//Majd ennek betutipusanak megadasa
		labelGame.setForeground(Color.WHITE);
		//Letrehozzuk a Layout-ot
		baseLayout = new GridBagLayout();
        //Letrehozzuk a startbutton-t majd beallitjuk a kivant kinezetet
		btnStartGame = new JButton("Start");
		btnStartGame.setForeground(Color.DARK_GRAY);
		btnStartGame.setFont(font.deriveFont(Font.PLAIN, 48f));
		//Kivesszuk a hatterszint és a fokuszt
		btnStartGame.setOpaque(false);
		btnStartGame.setContentAreaFilled(false);
		btnStartGame.setBorderPainted(false);
		btnStartGame.setFocusPainted(false);
		//Letrehozzuk az exit gombot
		btnExit = new JButton("Exit");
		//Beallitjuk a kivant kinezetet
		btnExit.setForeground(Color.DARK_GRAY);
		btnExit.setFont(font.deriveFont(Font.PLAIN, 48f));
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setFocusPainted(false);
		//Felepitjuk a panelt majd a Lstenereket is letrehozzuk
		buildPanel();
		buildListeners();
	}
	/**
	 * 
	 * A Panel felepiteseert,strukturajaert felelos fuggveny. Tobbek kozott itt allitjuk be melyik
	 * komponens hova keruljon a Layout szerint, itt kerulnek a panelhez a gombok is
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
        buttons.add(btnExit, gbc);		
        buttons.setOpaque(false);
       
		this.setLayout(baseLayout);
		this.add(labelGame, gbc);
		this.add(buttons, gbc);	
	}
	
	/**
	 * A Listenerek letehozasaert felelos fuggveny, itt rendeljuk hozza oket a gombokhoz.
	 * Majd a nevuk altal adott viselkedest hajtjak vegre lenyomakskor,
	 * A start button-nel betoltodik a MapselectionView
	 * Az exit gombbal pedig bzarodik az egesz program.
	 */
	private void buildListeners() {
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
								
				baseGameController.getGameFrame().changePanel(new MapSelectionView(baseGameController));
			}
		});
		
		btnStartGame.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnStartGame.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnStartGame.setForeground(Color.DARK_GRAY);
		    }
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				System.exit(1);
			}
		});
		
		btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnExit.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnExit.setForeground(Color.DARK_GRAY);
		    }
		});
	}
	/*
	 * 
	 * Ez a fuggveny felelos az egesz MenuView Grafikus megjeleniteseert, kirajzolasaert
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
