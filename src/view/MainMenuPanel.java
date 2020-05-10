package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.GameController;
import view.tiles.TileView;

public class MainMenuPanel extends JPanel {
	
	private GameController baseGameController;
	private JLabel labelGame;
	
	private JButton btnRope;
	private JButton btnShovel;
	private JButton btnFood;
	private JButton btnCartridge;
	private JButton btnGun;
	private JButton btnBeacon;
	private JButton btnSpecial;

	private GridBagLayout baseLayout;
	
	public MainMenuPanel(GameController baseGameController) throws IOException {
		this.baseGameController = baseGameController;
		
		baseLayout = new GridBagLayout();
		/*
		btnRope = new JButton("R");
		btnShovel  = new JButton("S");
		btnFood = new JButton("F");
		btnCartridge = new JButton("C");
		btnGun = new JButton("G");
		btnFlare = new JButton("F");
		btnSpecial = new JButton("*");
		*/
		
		java.net.URL urlRope = GamePanel.class.getResource("images/rope.png");
		java.net.URL urlShovel = GamePanel.class.getResource("images/shovel.png");
		java.net.URL urlFood = GamePanel.class.getResource("images/food.png");
		java.net.URL urlCartridge = GamePanel.class.getResource("images/cartridge.png");
		java.net.URL urlGun = GamePanel.class.getResource("images/gun.png");
		//java.net.URL urlBeacon = GamePanel.class.getResource("images/beacon.png");
		java.net.URL urlSpecial = GamePanel.class.getResource("images/explore.png");
		
		ImageIcon iconRope = new ImageIcon(urlRope);
		ImageIcon iconShovel = new ImageIcon(urlShovel);
		ImageIcon iconFood = new ImageIcon(urlFood);
		ImageIcon iconCartridge = new ImageIcon(urlCartridge);
		ImageIcon iconGun = new ImageIcon(urlGun);
		//ImageIcon iconBeacon = new ImageIcon(urlBeacon);
		ImageIcon iconSpecial = new ImageIcon(urlSpecial);
		
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
		
		//btnBeacon = new JButton("");
		//btnBeacon.setIcon(iconBeacon);
		
		btnSpecial = new JButton("");
		temp = iconSpecial.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		btnSpecial.setIcon(new ImageIcon(temp));
		btnSpecial.setBackground(btnBackgroundColour);
		btnSpecial.setFocusPainted(false);
		
		buildPanel();
		buildListeners();
	}
	
	private void buildPanel() throws IOException {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1;
        
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(btnRope);
        buttons.add(btnShovel);
        buttons.add(btnFood);
        buttons.add(btnCartridge);
        buttons.add(btnGun);
        //buttons.add(btnBeacon);
        buttons.add(btnSpecial);
        
        //buttons.setOpaque(false);
        
        //buttons.add(new TileView(baseGameController), gbc);
       
		this.setLayout(baseLayout);
		this.add(buttons, gbc);	
	}
	
	/**
	 * Add listener to the button, notifies controller
	 */
	private void buildListeners() {

	} 
	
	
	@Override
	  protected void paintComponent(Graphics g) {  
      super.paintComponent(g);
      //setBackground(Color.BLUE);
      java.net.URL imgWaterDeep = GamePanel.class.getResource("images/iceWaterDeep.png");
      java.net.URL imgWaterDeepAlt = GamePanel.class.getResource("images/iceWaterDeepAlt.png");
      java.net.URL imgWaterDeepStar = GamePanel.class.getResource("images/iceWaterDeepStars.png");
      java.net.URL imgWaterDeepStarAlt = GamePanel.class.getResource("images/iceWaterDeepStarsAlt.png");
      
	    if (imgWaterDeep != null && imgWaterDeepAlt != null) {
	    	ImageIcon waterDeep = new ImageIcon(imgWaterDeep);
	    	ImageIcon waterDeepAlt = new ImageIcon(imgWaterDeepAlt);
	    	ImageIcon waterDeepStars = new ImageIcon(imgWaterDeepStar);
	    	ImageIcon waterDeepStarsAlt = new ImageIcon(imgWaterDeepStarAlt);
	    	
	    	for (int i = 0; i < 20; i++) {
	    		for (int j = 0; j < 11; j++) {
	    			if (i % 2 != 0) {
	    				g.drawImage(waterDeep.getImage(), i*70, j*70, null);
	    			} else {
	    				g.drawImage(waterDeepAlt.getImage(), i*70, j*70, null);
	    			} 
	    		}
	    	}
	    }
	}
}
