package view.entity;

import javax.swing.ImageIcon;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben az
 * Eskimo megjeleniteseert felel.
 * @author cserik
 *
 */

import controller.GameController;

/**
 * 
 * Az felfedezo megjeleniteseert felelos osztaly.
 * 
 * @author Gabor
 *
 */
public class ExplorerView extends PlayerView {

	private static final long serialVersionUID = -8448321802798258694L;

	public ExplorerView(GameController baseGameController) {
		super(baseGameController);
		/**
		 * A felfedezo megjeleniteseert felelos kep betoltese
		 */
		ImageIcon tmp = new ImageIcon(ExplorerView.class.getResource("../images/explorer.png"));
		if (tmp != null) {
			icon = tmp;
			this.setIcon(icon);
		}
	}

}
