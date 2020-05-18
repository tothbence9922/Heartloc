package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;
/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Beacon megjeleniteseert felel.
 * @author cserik
 *
 */
public class BeaconView extends ItemView {

	private static final long serialVersionUID = -7578455206214664207L;

	public BeaconView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(this.getClass().getResource("./images/beacon-24x24.png"));

		this.setIcon(icon);
	}

}
