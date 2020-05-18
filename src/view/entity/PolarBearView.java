package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;


/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * PolarBear megjeleniteseert felel.
 * @author cserik
 *
 */
public class PolarBearView extends EntityView {

	private static final long serialVersionUID = 559740303949629090L;

	public PolarBearView(GameController baseGameController) throws IOException {
		super(baseGameController);
		icon = new ImageIcon(PolarBearView.class.getResource("../images/bear.png"));
		this.setIcon(icon);
	}

}
