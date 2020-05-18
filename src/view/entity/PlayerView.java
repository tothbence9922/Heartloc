package view.entity;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Player megjeleniteseert felel.
 * @author cserik
 *
 */

public class PlayerView extends EntityView {

	private static final long serialVersionUID = -2507997227357079201L;
	
	public PlayerView(GameController baseGameController){
		super(baseGameController);
	}
	
}
