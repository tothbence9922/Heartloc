package view.entity;

import java.io.IOException;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben az
 * OptionalItem megjeleniteseert felel.
 * @author cserik
 *
 */

import controller.GameController;

public class OptionalItemView extends ItemView {

	private static final long serialVersionUID = 36638265809682864L;

	public OptionalItemView(GameController baseGameController) throws IOException {
		super(baseGameController);
	}

}
