package view.entity;

import java.io.IOException;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * TargetItem megjeleniteseert felel.
 * @author cserik
 *
 */

import controller.GameController;
/**
 * A jatek megnyeresehez feltetlenul szukseges eszkozoket reprezentalja grafikusan az ososztaly a felasznalo szamara
 * jatek kozben.
 * @author Gabor
 *
 */
public class TargetItemView extends ItemView {
	
	private static final long serialVersionUID = 7695195257329494544L;

	public TargetItemView(GameController baseGameController) throws IOException {
		super(baseGameController);
	}

}
