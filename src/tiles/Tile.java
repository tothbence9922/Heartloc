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
	/**
	 * Megadja, hogy található-e a lyuk a Tile-on.
	 * 
	 * @return Ha van Hole akkor true, ha nincs akkor false.
	 */
	public boolean getHasHole() {
		System.out.println("Tile\tboolean getHasHole()\tparam: -");
		return this.hasHole;
	}
	/**
	 * Megkaphatjuk a TargetItem-ek számát.
	 * @return Visszatér a TargetItem-ek számával.
	 */
	public int getNumOfTargetItems() {
		System.out.println("Tile\tint getNumOfTargetItems()\tparam: -");
		return this.numOfTargetItems;
	}

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
	
	/**
	 * a paraméterben kapott entitást a jégtáblára mozgatja.
	 * @param e - Egy Entity változó amit hozzáadunka Tile-hoz.
	 * @return - Az elhelyezés sikeressége true, ellenkezõleg false.
	 */
	public boolean receive(Entity e) {
		System.out.println("Tile\tboolean recieve(Entity)\tparam: " + e);
		return false;
	}
	/**
	 *  a paraméterben kapott entitást a jégtábláról eltávolítja.
	 * @param e - Az Entity, amit el szeretnénk távolítani a mezõrõl.
	 */
	public void remove(Entity e) {
		System.out.println("Tile\tvoid remove()\tparam: " + e);
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
	public ArrayList<Tile> getNeighbours(){
		System.out.println("Tile\tArrayList<Tile> getNeighbours()\tparams: -");
		return null;
	}
	public void alarmTile(Player p) {
		System.out.println("Tile\t void alarmTile(Player)\tparam: player");
	}
}
