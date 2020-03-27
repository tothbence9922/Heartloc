package model;

import java.util.ArrayList;
import java.util.Random;

import entity.item.Item;
import entity.player.Player;

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
}
