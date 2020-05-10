package view;

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
	private GamePanel baseGamePanel;
	
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
		remove(baseGamePanel);
		add(newGamePanel);
		validate();
	}
}
