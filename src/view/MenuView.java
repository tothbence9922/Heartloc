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

public class MenuView extends JPanel {

	private static final long serialVersionUID = -5113606236074548822L;
	private GameController baseGameController;
	private JLabel labelGame;
	private JButton btnStartGame;
	private JButton btnExit;
	private GridBagLayout baseLayout;
	
	public MenuView(GameController baseGameController) {
		this.baseGameController = baseGameController;
		
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/CHILLER.TTF"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}  

		
		labelGame = new JLabel("Heartloc");
		labelGame.setFont(font.deriveFont(Font.PLAIN, 120f));
		labelGame.setForeground(Color.WHITE);
		
		baseLayout = new GridBagLayout();
    
		btnStartGame = new JButton("Start");
		btnStartGame.setForeground(Color.DARK_GRAY);
		btnStartGame.setFont(font.deriveFont(Font.PLAIN, 48f));
		/* disable background color and focus outline */
		btnStartGame.setOpaque(false);
		btnStartGame.setContentAreaFilled(false);
		btnStartGame.setBorderPainted(false);
		btnStartGame.setFocusPainted(false);
		
		btnExit = new JButton("Exit");
		btnExit.setForeground(Color.DARK_GRAY);
		btnExit.setFont(font.deriveFont(Font.PLAIN, 48f));
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setFocusPainted(false);
		
		buildPanel();
		buildListeners();
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
        buttons.add(btnExit, gbc);		
        buttons.setOpaque(false);	// do not display background over the other panel
       
		this.setLayout(baseLayout);
		this.add(labelGame, gbc);
		this.add(buttons, gbc);	
	}
	
	/**
	 * Add listener to the button, notifies controller
	 */
	private void buildListeners() {
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
								
				baseGameController.getGameFrame().changePanel(new MapSelectionView(baseGameController));
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
