package model.entity.player;

import java.io.IOException;

import controller.GameRunner;
import model.temp.Game;
import model.tiles.Tile;
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
		try {
			view = new ExplorerView(GameRunner.baseGameController);
			view.setLayout(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
					
					energy--;					
					return t.getCapacity();
				}
			}
		}
		return -3;
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}
}

