package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class BuildingView extends EntityView {

	private static final long serialVersionUID = -2319738206946074929L;

	public BuildingView(GameController baseGameController){
		super(baseGameController);
		h = 64;
		w = 64;
		icon = new ImageIcon(BuildingView.class.getResource("../images/igloo.png"));
}

}
