package entity.player;

import tiles.Tile;

public class Explorer extends Player{

	public Explorer() {
		this.bodyTemp = 4;
		this.workCap = 4;
	}
	
	public void explore(Tile t) {
		
	}

	@Override
	public void draw() {
		
	}

	public void step() {
		System.out.println("Player\tvoid step()\tparam: -");
	}
}
