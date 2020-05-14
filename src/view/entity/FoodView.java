package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;

public class FoodView extends ItemView {

	private static final long serialVersionUID = 4392885773958212933L;
	protected static final ImageIcon icon = new ImageIcon(FoodView.class.getResource("../images/food.png"));

	public FoodView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}

}
