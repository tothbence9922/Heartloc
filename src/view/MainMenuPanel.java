package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2034218213270068850L;
	
	Image imageOrg = null; 
	Image image = null; 
	
	{
		addComponentListener(new ComponentAdapter() { 
		    public void componentResized(ComponentEvent e) { 
		        int w = MainMenuPanel.this.getWidth(); 
		        int h = MainMenuPanel.this.getHeight(); 
		        image = w>0&&h>0?imageOrg.getScaledInstance(w,h,  
		                java.awt.Image.SCALE_SMOOTH):imageOrg; 
		        MainMenuPanel.this.repaint(); 
		    } 
		}); 
	} 

	public MainMenuPanel(Image i) { 
	  imageOrg=i; 
	  image=i; 
	  setOpaque(false); 
	} 
	public void paint(Graphics g) { 
	  if (image!=null) g.drawImage(image, 0, 0, null); 
	  super.paint(g); 
	} 
}
