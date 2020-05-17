package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class FoodView extends ItemView {

	private static final long serialVersionUID = 4392885773958212933L;

	public FoodView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(FoodView.class.getResource("../images/food-24x24.png"));
		this.setIcon(icon);
	}

}
