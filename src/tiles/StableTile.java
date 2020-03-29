package tiles;

import java.util.ArrayList;

import entity.Entity;
import entity.player.Explorer;
import entity.player.Player;

public class StableTile extends Tile {

	public StableTile() {
		this.players = new ArrayList<Player>();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	

	public void dig(int i) {
		System.out.println("StableTile\tvoid dig(int)\tparam:" + i );
		
	}

	public void removeSnow(int i) {
		System.out.println("StableTile\tvoid removeSnow(int)\tparam:" + i);
	}
}
