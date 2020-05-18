package view.entity;

import javax.swing.ImageIcon;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Tent megjeleniteseert felel.
 * @author cserik
 *
 */

import controller.GameController;

public class TentView extends BuildingView {

	private static final long serialVersionUID = 7669658819771612706L;

	public TentView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(TentView.class.getResource("../images/tent.png"));
		this.setIcon(icon);
	}

}
