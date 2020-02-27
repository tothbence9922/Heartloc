package model;

import java.util.ArrayList;

public abstract class Player implements Drawable{
	
	protected Tile curTile;
	
	protected ArrayList<Item> items = new ArrayList<Item>();

	protected boolean isActive;
	
	protected int workCap = 4;
	protected int bodyTemp= 4;
	
	public int getCap() {
		return workCap;
	}
	
	public int getTemp() {
		return bodyTemp;
	}
	
	public boolean hit() {
		bodyTemp --;
		if (bodyTemp == 0) return true;
		return false;
	}
	
	public void move() {
		
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