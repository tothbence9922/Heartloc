package tiles;

import java.util.ArrayList;

import entity.Entity;
import entity.player.Explorer;
import entity.player.Player;

public class StableTile extends Tile {

	public StableTile() {
		this.players = new ArrayList<Player>();
	}

	public void dig(int i) {
		System.out.println("StableTile\tvoid dig(int)\tparam: " + i );
		
	}
	
	public boolean receive(Entity e) {
		System.out.println("StableTile\tboolean receive(Entity)\tparam: " + e);
		return true;
	}
	
	public boolean remove(Entity e) {
		System.out.println("StableTile\tboolean remove(Entity)\tparam: " + e);
		return true;
	}

	public void removeSnow(int i) {
		System.out.println("StableTile\tvoid removeSnow(int)\tparam:" + i);
	}
	
	@Override
	public boolean getHasHole() {
		System.out.println("UnstableTile\tboolean getHasHole()\tparam: -");
		return true;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	


	@Override
	public Tile getNeighbours() {
		return null;
  }

	@Override
	public boolean alarmTile(Player p) {
		// TODO Auto-generated method stub
		return false;
	}
}
