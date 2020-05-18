package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az
 * esetben a Food megjeleniteseert felel.
 * 
 * @author cserik
 *
 */

public class FoodView extends ItemView {

	private static final long serialVersionUID = 4392885773958212933L;

	public FoodView(GameController baseGameController) {
		super(baseGameController);
		ImageIcon tmp = new ImageIcon(FoodView.class.getResource("../images/food-24x24.png"));
		if (tmp != null) {
			icon = tmp;
			this.setIcon(icon);
		}
	}

}
