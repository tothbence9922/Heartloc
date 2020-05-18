package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Rope megjeleniteseert felel.
 * @author cserik
 *
 */

public class RopeView extends ItemView {

	private static final long serialVersionUID = -7899741607513882606L;

	public RopeView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(RopeView.class.getResource("../images/rope-24x24.png"));
		this.setIcon(icon);
	}

}
