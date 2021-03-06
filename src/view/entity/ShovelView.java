package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Shovel megjeleniteseert felel.
 * @author cserik
 *
 */

public class ShovelView extends ItemView {

	private static final long serialVersionUID = 4934129432033430008L;

	public ShovelView(GameController baseGameController) throws IOException {
		super(baseGameController);
		ImageIcon tmp = new ImageIcon(ShovelView.class.getResource("../images/shovel-24x24.png"));
		if (tmp != null) {
			icon = tmp;
			this.setIcon(icon);
		}
	}

}
