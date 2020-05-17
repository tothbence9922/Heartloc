package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class FragileShovelView extends ItemView {

	private static final long serialVersionUID = -6760217020665515466L;

	public FragileShovelView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(FragileShovelView.class.getResource("../images/shovel-24x24.png"));
		this.setIcon(icon);
}

}
