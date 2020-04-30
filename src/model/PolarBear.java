package model;

import java.util.Random;

import entity.Entity;
import entity.player.Player;
import tiles.StableTile;
import tiles.Tile;

public class PolarBear extends Entity {
	
	private Tile currentTile = new StableTile("");
	
	private boolean inWater = false;

	public PolarBear(String id) {
		super(id);
	}
	
	public void move(Tile t) {
		currentTile.remove(this);
		
		t.receive(this);
		
		setCurrentTile(t);
		
		if(currentTile.getCapacity() != -1 && currentTile.getCapacity() < currentTile.getLoad()) {
			for(Player p : currentTile.getPlayers()) {
				p.pushToWater();
			}
			inWater = true;
		}
		else{
			if(currentTile.getHasHole()) inWater = true;
			else inWater = false;
		}
	}

	@Override
	public int step() {
		Random r = new Random();
		for(Tile t : currentTile.getNeighbours()) {
			int go = r.nextInt()%2;
			if(go == 0) {
				move(t);
				return 0;
			}
		}
		return -1;
	}
	
	public void setCurrentTile(Tile t) {
		this.currentTile = t;
	}

}
