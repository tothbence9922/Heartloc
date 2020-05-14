package view.entity;

import javax.swing.ImageIcon;

import controller.GameController;

public class ExplorerView extends PlayerView{
	
	private static final long serialVersionUID = -8448321802798258694L;
	
	public ExplorerView(GameController baseGameController){
		super(baseGameController);		
		icon = new ImageIcon(ExplorerView.class.getResource("../images/explorer.png"));

		this.setIcon(icon);
}

}
