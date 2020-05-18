package view.entity;

import controller.GameController;
import view.View;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben az
 * Entitiy megjeleniteseert felel.
 * @author cserik
 *
 */

public class EntityView extends View {

	private static final long serialVersionUID = -1649204326123260256L;

	public EntityView(GameController baseGameController) {
		super(baseGameController);

	}

}
