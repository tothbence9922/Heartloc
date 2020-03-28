package entity.player;
import tiles.Tile;

public class Eskimo extends Player {

	public Eskimo() {
		this.bodyTemp = 5;
		this.energy = 4;
	}
	public void step() {
		System.out.println("Eskimo\tvoid step()\tparam: -");
	}
	
	public void build(Tile t) {
		System.out.println("Eskimo\tvoid build()\tparam: Tile");
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
