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
	
	public boolean receive(Explorer e){
		System.out.println("StableTile\tboolean receive(Explorer)\tparam: ex");
		return true;
	}
	
	public boolean remove(Explorer e){
		System.out.println("StableTile\tboolean remove(Explorer)\tparam: ex");
		return true;
	}

	public void dig(int i) {
		System.out.println("StableTile\tvoid dig(int)\tparam:" + i );
		
	}
	
	public boolean getHasHole(){
		System.out.println("StableTile\tboolean getHasHole()\tparam: -");
		return this.hasHole;
	}

	public void removeSnow(int i) {
		System.out.println("StableTile\tvoid removeSnow(int)\tparam:" + i);
	}
}
