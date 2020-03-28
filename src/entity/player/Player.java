package entity.player;

import java.util.ArrayList;

import entity.Entity;
import entity.item.Item;
import model.Drawable;
import tiles.Tile;

public abstract class Player extends Entity implements Drawable{
	
	protected Tile curTile;
	
	public ArrayList<Item> items = new ArrayList<Item>();

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
	 * 	A játékos adott körben történõ cselekvéseit beindító függvény.
	 *  Visszatérési értéke megadja, hogy mennyi munkakedve van még a
	 *	játékosnak. Mivel a Player absztrakt osztály, így itt csak deklarálásra kerül, a
	 *	pontos mûködés a leszármazottakban valósul meg.
	 *  @return energy - A megmaradt munkakedv értéke
	 * 
	 */
	@Override
	public int  step() {
		System.out.println("Player\tint step()\tparam: -");
		return energy;
	}
	
	public boolean hit() {
		bodyTemp --;
		if (bodyTemp == 0) return true;
		return false;
	}
	/**
	 *  ezzel a metódussal kerül át a játékos egyik jégtábláról a
	 *  másikra. Mivel a Player absztrakt osztály, így itt csak deklarálásra kerül, a
	 *  pontos mûködés a leszármazottakban valósul meg.
	 * @param t - A Tile amire a játékos mozogni szeretne
	 */
	public void move(Tile t) {
		System.out.println("Player\tvoid move()\tparam: Tile");
	}
	
	public void feed(Player p) {
		p.bodyTemp += 1;
	}
	
	public void fall() {
		scream();
	}
	
	public void scream() {
		
	}
	
	public void useItem() {
		
	}
	
	public void useRocket() {
		
	}
	
	public void dig() {
		
	}
	/**
	 * megjelenitjuk a lehetseges cselekveseket,
	 * ha 0 az ereje ne tudja kivalasztani, ne kivalasztas utan ellenorizze
	 * minden activity (dig, useItem, stb) hogy tud-e.
	 */
	public void showActions() {
		
	}
	
}