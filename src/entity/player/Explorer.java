package entity.player;

import tiles.Tile;

public class Explorer extends Player{

	public Explorer() {
		this.bodyTemperature = 4;
		this.energy = 4;
	}
	
	public void move(Tile t) {
		System.out.println("Explorer\tvoid move(Tile)\tparam: " + t);
	}

	public int step() {
		System.out.println("Explorer\tvoid step()\tparam: -");
		return 0;
	}

	@Override
	public int exploreTile(Tile chosenTile) {
		System.out.println("Explorer\tint ExploreTile()\tparam: " + chosenTile);
		return 5;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
