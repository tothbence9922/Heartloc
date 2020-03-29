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

	public void move(Tile t) {
		System.out.println("Eskimo\tvoid move(Tile)\tparam: " + t);
	}

	public void step() {
		System.out.println("Eskimo\tint step()\tparam: -");
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}
}
