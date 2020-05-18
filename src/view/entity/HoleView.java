package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Hole megjeleniteseert felel.
 * @author cserik
 *
 */

public class HoleView extends EntityView {

	private static final long serialVersionUID = -3299152365267062000L;

	public HoleView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(GunView.class.getResource("../images/gun.png")); // TODO MAKE IT A HOLE!!
	}

}
