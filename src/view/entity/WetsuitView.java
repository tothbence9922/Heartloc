package view.entity;

import javax.swing.ImageIcon;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Wetsuit megjeleniteseert felel.
 * @author cserik
 *
 */

import controller.GameController;

public class WetsuitView extends ItemView {

	private static final long serialVersionUID = -5378569920028842024L;

	public WetsuitView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(WetsuitView.class.getResource("../images/wetsuit-24x24.png"));
		this.setIcon(icon);
	}

}
