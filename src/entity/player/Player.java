package entity.player;

import java.util.ArrayList;

import entity.Entity;
import entity.item.Item;
import model.Drawable;
import tiles.Tile;

public abstract class Player extends Entity implements Drawable{
	
	protected Tile curTile;
	public ArrayList<Item> items = new ArrayList<Item>();
	protected Tile curTile;
	protected boolean isActive;

	protected int energy= 4;
	protected int bodyTemp= 4;
	/**
	 * @return energy - Visszatér a játékos munkakedvével.
	 */
	public int getEnergy() {
		System.out.println("Player\tint getEnergy()\tparam: -");
		return energy;
	}

	public int getTemp() {
		return bodyTemp;
	}
	/**
	 * 	A játékos adott körben történő cselekvéseit beindító függvény.
	 *  Visszatérési értéke megadja, hogy mennyi munkakedve van még a
	 *	játékosnak. Mivel a Player absztrakt osztály, így itt csak deklarálásra kerül, a
	 *	pontos működés a leszármazottakban valósul meg.
	 *  @return energy - A megmaradt munkakedv értéke
	 * 
	 */
	@Override
	public int  step() {
		System.out.println("Player\tint step()\tparam: -");
		return energy;
	}
	
	public void step() {
		System.out.println("Player\tvoid step()\tparam: -");
	}
	
	public boolean hit() {
		bodyTemp--;
		if (bodyTemp == 0) return true;
		return false;
	}
  
	/**
	 *  ezzel a metódussal kerül át a játékos egyik jégtábláról a
	 *  másikra. Mivel a Player absztrakt osztály, így itt csak deklarálásra kerül, a
	 *  pontos működés a leszármazottakban valósul meg.
	 * @param t - A Tile amire a játékos mozogni szeretne
	 */
	public void move(Tile t) {
		System.out.println("Player\tvoid move(Tile)\tparam: " + t);
  }
	
	public void pushToWater() {
		System.out.println("Player\tvoid pushToWater()\tparam: -");
	}
	
	public void setInWater(boolean b) {
		System.out.println("Player\tvoid setInWater(boolean)\tparam:"+b);
	}
	
	public void feed(Player p) {
		p.bodyTemp += 1;
	}
	
	public void fall() {
		scream();
	}

	public int scream() {
		System.out.println("Player\tint scream()\tparam: -");
		return 1;
	}
	
	public void useItem() {
		
	}
	
	public void useRocket() {
		
	}
	
	public boolean savePlayer(Player p) {
		System.out.println("Player\tboolean savePlayer(Player)\tparam: ex");
		return false;
	}
	
	public void die() {
		System.out.println("Player\tvoid die()\tparam: -");
	}
	
	public abstract void die();
	
	/**
	 * megjelenitjuk a lehetseges cselekveseket,
	 * ha 0 az ereje ne tudja kivalasztani, ne kivalasztas utan ellenorizze
	 * minden activity (dig, useItem, stb) hogy tud-e.
	 */
	public void showActions() {
		
	}
	public void pushToWater() {
		System.out.println("Player\tvoid pushToWater()\tparam: -");
	}
	public void setInWater(boolean inWater) {
		System.out.println("Player\t void setInWater()\tparam: -");
	}
	public void savePlayer(Player p) {
		System.out.println("Player\t void savePlayer(Player)\t param: Player");
	}
	
	public boolean buildIgloo(Tile chosenTile) {
		System.out.println("Player\tboolean buildIgloo(Tile\tparam: " + chosenTile);
		return false;
	}
	
	public void pushToWater() {
		System.out.println("Player\tvoid pushToWater()\tparam: -");
	}
	
	public void setInWater(boolean inWater) {
		System.out.println("Player\t void setInWater()\tparam: -");
	}
	
	public void savePlayer(Player p) {
		System.out.println("Player\t void savePlayer(Player)\t param: Player");
	}	
}