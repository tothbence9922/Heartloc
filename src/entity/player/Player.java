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
	 * @return energy - Visszat�r a j�t�kos munkakedv�vel.
	 */
	public int getEnergy() {
		System.out.println("Player\tint getEnergy()\tparam: -");
		return energy;
	}

	public int getTemp() {
		return bodyTemp;
	}
	/**
	 * 	A j�t�kos adott k�rben t�rt�n� cselekv�seit beind�t� f�ggv�ny.
	 *  Visszat�r�si �rt�ke megadja, hogy mennyi munkakedve van m�g a
	 *	j�t�kosnak. Mivel a Player absztrakt oszt�ly, �gy itt csak deklar�l�sra ker�l, a
	 *	pontos m�k�d�s a lesz�rmazottakban val�sul meg.
	 *  @return energy - A megmaradt munkakedv �rt�ke
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
	 *  ezzel a met�dussal ker�l �t a j�t�kos egyik j�gt�bl�r�l a
	 *  m�sikra. Mivel a Player absztrakt oszt�ly, �gy itt csak deklar�l�sra ker�l, a
	 *  pontos m�k�d�s a lesz�rmazottakban val�sul meg.
	 * @param t - A Tile amire a j�t�kos mozogni szeretne
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