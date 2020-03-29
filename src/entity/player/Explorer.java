package entity.player;

import tiles.Tile;

public class Explorer extends Player{

	public Explorer() {
		this.bodyTemp = 4;
		this.energy = 4;
	}
	
	public void move(Tile t) {
		System.out.println("Explorer\tvoid move(Tile)\tparam: " + t);
	}

	public int step() {
		System.out.println("Player\tvoid step()\tparam: -");
		return 0;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void draw() {
		
	}
	public int getEnergy() {
		System.out.println("Player\tint getEnergy()\tparam: -");
		return this.energy;
	}
	
	public void heal(int amount) {
		//this.bodyTemp+=amount; nem tudom kell-e bele
		System.out.println("Player\tvoid heal(int)\tparam:" + amount);
		
	}

	@Override
	public int exploreTile(Tile chosenTile) {
		System.out.println("Explorer\tint ExploreTile()\tparam: " + chosenTile);
		return 5;
	}
}
