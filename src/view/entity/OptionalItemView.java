package view.entity;

import java.io.IOException;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben az
 * OptionalItem megjeleniteseert felel.
 * @author cserik
 *
 */

import controller.GameController;
/**
 * 
 * Az OptionalItem megjeleniteseert felelos ososztaly, ez jeleniti meg a gyozelemhez nem feltetlenul
 * szukseges itemeket jatek kozben a felasznalo szamara. 
 * @author Gabor
 *
 */
public class OptionalItemView extends ItemView {

	private static final long serialVersionUID = 36638265809682864L;

	public OptionalItemView(GameController baseGameController) throws IOException {
		super(baseGameController);
	}

}
