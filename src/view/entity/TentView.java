package view.entity;

import javax.swing.ImageIcon;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Tent megjeleniteseert felel.
 * @author cserik
 *
 */

import controller.GameController;
/**
 * A megepitett satrat mutatja a felhasznalonak grafikusan ez az osztaly.
 * @author Gabor
 *
 */
public class TentView extends BuildingView {

	private static final long serialVersionUID = 7669658819771612706L;

	public TentView(GameController baseGameController){
		super(baseGameController);
		//A sator megepitese utan ez a beolvasott png felel a grafikus reprezentaciert.
		icon = new ImageIcon(this.getClass().getResource("../images/tent.png"));
		this.setIcon(icon);
	}

}
