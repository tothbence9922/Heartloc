package tiles;

import java.util.ArrayList;
import java.util.Random;

import entity.Entity;
import entity.item.Item;
import entity.player.Player;
import model.Drawable;

public abstract class Tile implements Drawable {
	
	protected ArrayList<Player> players;

	protected int snow = 0; 
	
	protected Item item = null;
	
	protected boolean hasHole = false;	// Felesleges szerintem külön osztályt szánni neki TB

	public void storm(Random r) {
		snow += r.nextInt(3);
		if (snow > 5) snow = 5;
		for (Player p : players) {
			p.hit();
		}
	}

	public Tile[] getNeighbours() {
		System.out.println("Tile\tTile[] getNeighbours()\tparam: -");
		
		Tile t1=new StableTile();
		Tile t2=new StableTile();
		Tile[] tiles= {t1,t2};
		return tiles;
	}
	
	public boolean alarmTile(Entity e) {
		System.out.println("Tile\tboolean alarmTile(Entity)\tparam: ex");
		return false;
	}
	
	public boolean getHasHole(){
		System.out.println("Tile\tboolean getHasHole()\tparam: -");
		return this.hasHole;
	}
	
	public boolean receive(Entity e){
		System.out.println("Tile\tboolean receive(Entity)\tparam: ex");
		return true;
	}
	
	public boolean remove(Entity e){
		System.out.println("Tile\tboolean remove(Entity)\tparam: ex");
		return true;
	}
	
}
