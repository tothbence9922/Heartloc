package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Gun megjeleniteseert felel.
 * @author cserik
 *
 */

public class GunView extends ItemView {

	private static final long serialVersionUID = -7983495518142460870L;

	public GunView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(this.getClass().getResource("../images/gun-24x24.png"));
		this.setIcon(icon);
	}

}
