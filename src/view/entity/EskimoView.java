package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben az
 * Eskimo megjeleniteseert felel.
 * @author cserik
 *
 */

public class EskimoView extends PlayerView{
	
	private static final long serialVersionUID = -8448321802798258694L;

	public EskimoView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(this.getClass().getResource("../images/eskimo.png"));
		this.setIcon(icon);
	}

}
