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
		System.out.println("Player\tvoid move(Tile)\tparam: st1");
	}

	@Override
	public void draw() {
		
	}

	
	public void step() {
		System.out.println("Player\tvoid step()\tparam: -");
	}

	public int getEnergy() {
		System.out.println("Player\tint getEnergy()\tparam: -");
		return this.workCap;
	}
	
	public void heal(int amount) {
		//this.bodyTemp+=amount; nem tudom kell-e bele
		System.out.println("Player\tvoid heal(int)\tparam:" + amount);
		
	}


}
