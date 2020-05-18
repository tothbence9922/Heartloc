package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben az
 * Igloo megjeleniteseert felel.
 * @author cserik
 *
 */

public class IglooView extends BuildingView {

	private static final long serialVersionUID = -4177955676451536165L;

	public IglooView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(this.getClass().getResource("../images/igloo.png"));
		this.setIcon(icon);
	}

}
