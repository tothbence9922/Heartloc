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
	
	public int getEnergy() {
		System.out.println("Player\tint getCap()\tparam: -");
		return energy;
	}
	
	public int getTemp() {
		return bodyTemp;
	}
	
	public void step() {
		System.out.println("Player\tvoid step()\tparam: -");
	}
	
	public boolean hit() {
		bodyTemp --;
		if (bodyTemp == 0) return true;
		return false;
	}
	
	public void move() {
		
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
	/**
	 * megjelenitjuk a lehetseges cselekveseket,
	 * ha 0 az ereje ne tudja kivalasztani, ne kivalasztas utan ellenorizze
	 * minden activity (dig, useItem, stb) hogy tud-e.
	 */
	public void showActions() {
		
	}
	
}