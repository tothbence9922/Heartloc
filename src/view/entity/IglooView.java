package view.entity;

import java.awt.Image;

import javax.swing.ImageIcon;

import controller.GameController;

public class IglooView extends BuildingView {

	private static final long serialVersionUID = -4177955676451536165L;

	public IglooView(GameController baseGameController){
		super(baseGameController);
		icon = new ImageIcon(IglooView.class.getResource("../images/igloo.png"));
		this.setIcon(icon);
	}

}
