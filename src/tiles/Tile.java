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
	
	protected int numOfTargetItems;
	
	/**
	 * Megkaphatjuk a TargetItem-ek számát.
	 * @return Visszatér a TargetItem-ek számával.
	 */
	public int getNumOfTargetItems() {
		System.out.println("Tile\tint getNumOfTargetItems()\tparam: -");
		return this.numOfTargetItems;
	}

	public void storm(Random r) {
		snow += r.nextInt(3);
		if (snow > 5) snow = 5;
		for (Player p : players) {
			p.hit();
		}
	}
	
	/**
	 * a paraméterben kapott entitást a jégtáblára mozgatja.
	 * @param e - Egy Entity változó amit hozzáadunka Tile-hoz.
	 * @return - Az elhelyezés sikeressége true, ellenkezõleg false.
	 */
	public abstract boolean receive(Entity e);
	
	/**
	 *  a paraméterben kapott entitást a jégtábláról eltávolítja.
	 * @param e - Az Entity, amit el szeretnénk távolítani a mezõrõl.
	 */
	public abstract boolean remove(Entity e);
	
	public abstract boolean getHasHole();
	
	public abstract boolean alarmTile(Player p);

	public Tile[] getNeighbours() {
		System.out.println("Tile\tTile[] getNeighbours()\tparam: -");
		
		Tile t1=new StableTile();
		Tile t2=new StableTile();
		Tile[] tiles= {t1,t2};
		return tiles;
	}
	
	public boolean alarmTile(Entity e) {
		System.out.println("Tile\tboolean alarmTile(Entity)\tparam: " + e);
		return false;
	}
	
	/**
	 * A rakéta összeszerelését végzi el a függvény.
	 * 
	 * @return  true értékkel tér vissza, ha az adott jégtáblán
		összeszerelhetõ a jelzõrakéta, egyébként false.
	 */
	public boolean assembleRocket() {
		System.out.println("Tile\tbooelan assembleRocket()\tparam: -");
		return false;
	}
	
	public int getDistance() {
		System.out.println("StableTile\t int getDistance()\tparam: -");
		return 2;
	}
	
	public abstract void setCapacityVisible(boolean b);
}
