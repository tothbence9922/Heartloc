package model.entity.player;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;

import controller.GameRunner;
import model.Game;
import model.tiles.Tile;
import view.GameView;
import view.entity.ExplorerView;

/**
 * A jatekban szereplo egyik entitas. Kezdeskent 4 egysegnyi testhoje van,
 * valamint egy kulonleges kepessege is: meg tudja nezni a legfeljebb 3
 * tavolsagra levo jegtablarol, hogy mekkora a teherbirasa. Ez fontos es hasznos
 * kepesseg, ugyanis az instabil jegtablak nagy veszelyt jelentenek.
 */
public class Explorer extends Player {

	public Explorer(String id) {
		super(id);
		this.bodyTemperature = 4;
		this.energy = 4;
		view = new ExplorerView(GameRunner.baseGameController);
		view.setLayout(null);
	}

	/**
	 * Az ososztalybol szarmazo metodus, mely itt az Explorer kepesseget valositja
	 * meg: a jatekos poziciojatol legfeljebb 3 tavolsagra levo jegtablak kozul
	 * egyrol megallapitja a teherbirasat
	 * 
	 * @param chosenTile a kivalasztott Tile
	 * @return a Tile teherbirasa
	 */
	@Override
	public int exploreTile(String chosenTile) {

		if (energy > 0) {
			for (Tile t : Game.getTiles()) {
				if (t.getId().equals(chosenTile)) {
					String cap ="FIX";
					if (t.getCapacity() > 1) cap = String.valueOf(t.getCapacity());
					JLabel capacityLabel = new JLabel(cap);
					capacityLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
					capacityLabel.setForeground(Color.BLACK);
					capacityLabel.setBounds(t.view.getX() - 10, t.view.getY(), 30, 30);
					Game.view.addLabel(capacityLabel);
					Game.view.updatePanel();

					return t.getCapacity();
				}
			}
		}
		return -3;
	}
}
