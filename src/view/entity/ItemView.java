package view.entity;

import controller.GameController;


/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben az
 * Item megjeleniteseert felel.
 * @author cserik
 *
 */
public class ItemView extends EntityView {
	private static final long serialVersionUID = 2596795939753461326L;

	public ItemView(GameController baseGameController){
		super(baseGameController);
	}

}
