package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.GameController;

public class MapSelectionView extends JPanel {

	private static final long serialVersionUID = -7780612029288723490L;
	private GameController baseGameController;
	private JLabel labelSelect;
	private JButton btnStartGame;
	private JButton btnBack;
	private GridBagLayout baseLayout;
	private JTextField mapTextField;
	
	public MapSelectionView(GameController baseGameController) {
		this.baseGameController = baseGameController;
		
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/CHILLER.TTF"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}  

		
		labelSelect = new JLabel("Select a map!");
		labelSelect.setFont(font.deriveFont(Font.PLAIN, 120f));
		labelSelect.setForeground(Color.WHITE);
		
		baseLayout = new GridBagLayout();
    
		// TODO Megoldani a beolvasast!!!
		mapTextField = new JTextField();
		mapTextField.setFont(font.deriveFont(Font.PLAIN, 60f));
		
		
		btnStartGame = new JButton("Start");
		btnStartGame.setForeground(Color.DARK_GRAY);
		btnStartGame.setFont(font.deriveFont(Font.PLAIN, 48f));
		/* disable background color and focus outline */
		btnStartGame.setOpaque(false);
		btnStartGame.setContentAreaFilled(false);
		btnStartGame.setBorderPainted(false);
		btnStartGame.setFocusPainted(false);
		
		btnBack = new JButton("Exit");
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setFont(font.deriveFont(Font.PLAIN, 48f));
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
	
		
		buildPanel();
		buildLayout();
		buildListeners();
	}
	
	private void buildLayout() {
			
	}

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
        buttons.setOpaque(false);	// do not display background over the other panel
       
		this.setLayout(baseLayout);
		this.add(labelSelect, gbc);
		this.add(mapTextField, gbc);
		this.add(buttons, gbc);	
	}
	
	/**
	 * Add listener to the button, notifies controller
	 */
	private void buildListeners() {
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				/*
				 * Create game here
				 * sample code: 
				 * 
				 * Widget temp = new Widget();
				 * baseGameController.getGameFactory.getWidgetList().add(temp);
				 */
				String selectedMap = mapTextField.getText();
				String[] tokens = {"loadMap", selectedMap};
				baseGameController.setGame(tokens);
				//JOptionPane.showMessageDialog(baseGameController.getGameFrame(), "Yey a new window!");
				
				baseGameController.getGameFrame().changePanel(GameView.getInstance(baseGameController));
			}
		});
		
		mapTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedMap = mapTextField.getText();
				String[] tokens = {"loadMap", selectedMap};
				baseGameController.setGame(tokens);
				//JOptionPane.showMessageDialog(baseGameController.getGameFrame(), "Yey a new window!");
				
				baseGameController.getGameFrame().changePanel(GameView.getInstance(baseGameController));
		    }
		});

		/* add hover effect */
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