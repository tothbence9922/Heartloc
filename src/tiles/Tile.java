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
	
	protected boolean hasHole = false;	// Felesleges szerintem k�l�n oszt�lyt sz�nni neki TB

	public boolean getHasHole() {
		System.out.println("Tile\tboolean getHasHole()\tparam: -");
		return hasHole;
	}
	public void storm(Random r) {
		snow += r.nextInt(3);
		if (snow > 5) snow = 5;
		for (Player p : players) {
			p.hit();
		}
	}
	public boolean receive(Entity e) {
		System.out.println("Tile\tboolean recieve(Entity)\tparam: Entity");
		return false;
	}
	public ArrayList<Tile> getNeighbours(){
		System.out.println("Tile\tArrayList<Tile> getNeighbours()\tparams: -");
		return null;
	}
	public void alarmTile(Player p) {
		System.out.println("Tile\t void alarmTile(Player)\tparam: player");
	}
	public void remove(Entity e) {
		System.out.println("Tile\t void remove(Entity)\t param: Entity");
	}
	
}
