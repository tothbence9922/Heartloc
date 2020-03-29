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
	
	protected boolean hasHole = false;

	public void storm(Random r) {
		snow += r.nextInt(3);
		if (snow > 5) snow = 5;
		for (Player p : players) {
			p.hit();
		}
	}
	
	public abstract boolean receive(Entity e);
	
	public abstract boolean remove(Entity e);
	
	public abstract boolean getHasHole();
}
