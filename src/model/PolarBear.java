package model;

import entity.Entity;
import tiles.StableTile;
import tiles.Tile;

public class PolarBear extends Entity {

	private Tile currentTile = new StableTile("");
	
	public PolarBear(String id) {
		super(id);
	}
	
	public void setCurrentTile(Tile t) {
		this.currentTile = t;
	}

	@Override
	public int step() {
		return 0;
	}

}
