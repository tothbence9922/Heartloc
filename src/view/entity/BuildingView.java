package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Building megjeleniteseert felel.
 * @author cserik
 *
 */

public class BuildingView extends EntityView {

	private static final long serialVersionUID = -2319738206946074929L;

	public BuildingView(GameController baseGameController){
		super(baseGameController);
		h = 40;
		w = 50;
		icon = new ImageIcon(this.getClass().getResource("../images/igloo.png"));
		this.setIcon(icon);

}

}
