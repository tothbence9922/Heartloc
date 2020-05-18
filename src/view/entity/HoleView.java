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

	private static final long serialVersionUID = 7810509466025772430L;

	public HoleView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(HoleView.class.getResource("../images/hole.png"));
	}

}
