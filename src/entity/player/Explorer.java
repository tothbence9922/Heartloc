package entity.player;

import tiles.Tile;

public class Explorer extends Player{

	public Explorer() {
		this.bodyTemp = 4;
		this.energy = 4;
	}
	
	public void explore(Tile t) {
		
	}
	
	public void move(Tile t) {
		System.out.println("Explorer\tvoid move(Tile)\tparam: " + t);
	}

	public void step() {
		System.out.println("Player\tvoid step()\tparam: -");
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void draw() {
		
	}
}
