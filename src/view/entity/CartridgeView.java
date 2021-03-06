package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Cartridge megjeleniteseert felel.
 * @author cserik
 *
 */
public class CartridgeView extends ItemView {

	
	private static final long serialVersionUID = 1875909257496554807L;

	public CartridgeView(GameController baseGameController){
		super(baseGameController);
		ImageIcon tmp = new ImageIcon(CartridgeView.class.getResource("../images/cartridge-24x24.png"));
		if(tmp != null) {
			icon = tmp;
			this.setIcon(icon);
		}
	}

}
