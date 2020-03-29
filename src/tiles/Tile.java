package tiles;

import java.util.ArrayList;
import java.util.Random;

import entity.Entity;
import entity.Igloo;
import entity.item.Item;
import entity.player.Player;
import model.Drawable;

public abstract class Tile implements Drawable {
	
	protected ArrayList<Player> players;
	protected Item item = null;
	
	protected boolean hasHole = false;
	protected boolean hasItem = false;
	protected int amountOfSnow;
	protected int numOfTargetItems;
	protected int capacity;
	
	protected boolean showCapacity;
	
	public Item dig(int amount) {
		return null;
	}
	
	/**
	 * Megkaphatjuk a TargetItem-ek számát.
	 * @return Visszatér a TargetItem-ek számával.
	 */
	public int getNumOfTargetItems() {
		System.out.println("Tile\tint getNumOfTargetItems()\tparam: -");
		return this.numOfTargetItems;
	}
	
	public boolean initTile() {
		System.out.println("Tile\tboolean initTile()\tparam: -");
		return true;
	}
	
	/**
	 * a paraméterben kapott entitást a jégtáblára mozgatja.
	 * @param e - Egy Entity változó amit hozzáadunka Tile-hoz.
	 * @return - Az elhelyezés sikeressége true, ellenkezõleg false.
	 */
	public boolean receive(Entity e) {
		System.out.println("Tile\tboolean receive(Entity)\tparam: " + e);
		return true;
	}
	
	public boolean getHasHole() {
		System.out.println("Tile\tboolean getHasHole()\tparam: -");
		return true;
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
	
	public Tile[] getNeighbours() {
		System.out.println("Tile\tTile[] getNeighbours()\tparam: -");
		
		Tile t1 = new StableTile();
		Tile t2 = new StableTile();
		Tile[] tiles = {t1,t2};
		return tiles;
	}
	
	public boolean alarmTile(Player p) {
		System.out.println("Tile\tboolean alarmTile(Entity)\tparam: " + p);
		return false;
	}
	
	public void addSnow(int amount) {
		amountOfSnow += amount;
		System.out.println("Tile\tvoid addSnow(int)\tparam: " + amount);
	}
	
	public void removeSnow(int amount) {
		amountOfSnow -= amount;
		System.out.println("Tile\tvoid removeSnow(int)\tparam: " + amount);
	}
	
	public void setCapacityVisible(boolean b) {
		System.out.println("Tile\tvoid setCapacityVisible(boolean)\tparam: -" + b);
		this.showCapacity = b;
	}
	
	public int getDistance() {
		System.out.println("Tile\tint getDistance()\tparam: -");
		return 2;
	}

	public void storm(Random r) {
		System.out.println("Tile\tvoid storm(Random)\tparam: " + r);
		amountOfSnow += r.nextInt(3);
		if (amountOfSnow > 5) amountOfSnow = 5;
		for (Player p : players) {
			p.damage(1);
		}
	}
	
	public Player[] getPlayers() {
		System.out.println("Tile\tPlayer[] getPlayers()\tparam: -");
		return null;
	}
	
	public Igloo getIgloo() {
		System.out.println("Tile\tIgloo getIgloo()\tparam: -");
		return null;
	}
	
	/**
	 *  a paraméterben kapott entitást a jégtábláról eltávolítja.
	 * @param e - Az Entity, amit el szeretnénk távolítani a mezõrõl.
	 */
	public void remove(Entity e) {
		System.out.println("Tile\tvoid remove(Entity)\tparam: " + e);
	}

	
	
	
	
	
	
	
	
	
}
