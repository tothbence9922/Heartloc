package view;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameController;

/**
 * View: display UI and data, detect events from the user 
 *
 */
public class GameFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel baseGamePanel;
	
	public GameFrame(GameController baseGameController) {
		baseGamePanel = new GamePanel(baseGameController);
		buildFrame();
	}
	
	private void buildFrame() {
		this.setContentPane(baseGamePanel);
		this.setSize(1366, 768);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void changePanel(JPanel newGamePanel) {
		Container parent = baseGamePanel.getParent();
		
		this.getContentPane().remove(baseGamePanel);
		this.getContentPane().validate();
		this.getContentPane().repaint();
		
		this.baseGamePanel = newGamePanel;
		buildFrame();
	}
}
