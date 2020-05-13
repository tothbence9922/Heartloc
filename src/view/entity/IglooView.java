package view.entity;

import java.io.IOException;

import javax.swing.ImageIcon;

import controller.GameController;
import view.tiles.TileView;

public class IglooView extends BuildingView {

	private static final long serialVersionUID = -4177955676451536165L;
	protected static final ImageIcon icon = new ImageIcon(IglooView.class.getResource("../images/igloo.png"));

	public IglooView(GameController baseGameController) throws IOException {
		super(baseGameController);
		this.setIcon(icon);
	}

}
