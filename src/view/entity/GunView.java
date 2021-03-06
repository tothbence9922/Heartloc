package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az
 * esetben a Gun megjeleniteseert felel.
 * 
 * @author cserik
 *
 */

public class GunView extends ItemView {

	private static final long serialVersionUID = -7983495518142460870L;

	public GunView(GameController baseGameController) {
		super(baseGameController);
		ImageIcon tmp = new ImageIcon(GunView.class.getResource("../images/gun-24x24.png"));
		if (tmp != null) {
			icon = tmp;
			this.setIcon(icon);
		}
	}

}
