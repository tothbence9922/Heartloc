package model;

import entity.Entity;
import tiles.StableTile;
import tiles.Tile;

public class PolarBear extends Entity {
	
	private Tile currentTile = new StableTile("");

	public PolarBear(String id) {
		super(id);
	}

	@Override
	public int step() {
		return 0;
	}
	
	public void setCurrentTile(Tile t) {
		this.currentTile = t;
	}

}
