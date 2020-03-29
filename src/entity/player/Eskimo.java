package entity.player;

import tiles.Tile;

public class Eskimo extends Player {

	public Eskimo() {
		this.bodyTemp = 5;
		this.energy = 4;
	}
	
	public boolean buildIgloo(Tile chosenTile) {
		System.out.println("Eskimo\tboolean buildIgloo(Tile)\tparam: " + chosenTile);
		return true;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	public void step() {
		System.out.println("Eskimo\tint step()\tparam: -");
	}
}
