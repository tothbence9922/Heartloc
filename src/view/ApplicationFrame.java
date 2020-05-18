package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameController;

/**
 * View: display UI and data, detect events from the user
 *
 */
public class ApplicationFrame extends JFrame {
	/**
	 * Auto-generated serial variable
	 */
	private static final long serialVersionUID = 1781190319316282567L;

	private JPanel baseGamePanel;

	/**
	 * Letrehozza a jatek soran hasznalt alap frame-t
	 * 
	 * @param baseGameController
	 */
	public ApplicationFrame(GameController baseGameController) {
		baseGamePanel = new MenuView(baseGameController);
		buildFrame();
	}

	/**
	 * Beallitja a jatek soran hasznalt alap frame parametereit meret: 1366x768 nem
	 * atmeretezheto kepernyo kozepen jelenik meg
	 */
	private void buildFrame() {
		this.setContentPane(baseGamePanel);
		this.setSize(1366, 768);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * Kicsereli az aktualis panelt az ujonnan megjelenitendore, igy lehet nezetet
	 * valtani. Peldaul: menu - map selection menu - game view
	 */
	public void changePanel(JPanel newGamePanel) {
		this.getContentPane().remove(baseGamePanel);
		this.getContentPane().validate();
		this.getContentPane().repaint();

		this.baseGamePanel = newGamePanel;
		buildFrame();
	}
}
