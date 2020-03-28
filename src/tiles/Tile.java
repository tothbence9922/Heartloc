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
	
	protected int numOfTargetItems;
	
	public boolean getHasHole() {
		System.out.println("Tile\tboolean getHasHole()\tparam: -");
		return this.hasHole;
	}

	public void storm(Random r) {
		snow += r.nextInt(3);
		if (snow > 5) snow = 5;
		for (Player p : players) {
			p.hit();
		}
	}

	public boolean receive(Entity e) {
		System.out.println("Tile\tboolean receive()\tparam: Entity");
		return false;
	}
	public void remove(Entity e) {
		System.out.println("Tile\tvoid remove()\tparam: Entity");
	}
	public boolean assembleRocket() {
		System.out.println("Tile\tbooelan assembleRocket()\tparam: -");
		return false;
	}
	public int getNumOfTargetItems() {
		System.out.println("Tile\tint getNumOfTargetItems()\tparam: -");
		return this.numOfTargetItems;
	}
}
