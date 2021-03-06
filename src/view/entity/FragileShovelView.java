package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az
 * esetben a FragileShovel megjeleniteseert felel.
 * 
 * @author cserik
 *
 */

public class FragileShovelView extends ItemView {

	private static final long serialVersionUID = -6760217020665515466L;

	public FragileShovelView(GameController baseGameController) {
		super(baseGameController);
		ImageIcon tmp = new ImageIcon(FragileShovelView.class.getResource("../images/shovel-24x24.png"));
		if (tmp != null) {
			icon = tmp;
			this.setIcon(icon);
		}
	}

}
