package entity.player;

import java.util.ArrayList;

import entity.Entity;
import entity.item.Item;
import model.Drawable;
import tiles.Tile;

public abstract class Player extends Entity implements Drawable{
	
	private ArrayList<Item> inventory = new ArrayList<Item>();
	protected int energy = 4;
	protected int bodyTemperature = 4;
	protected boolean inWater = false;
	
	public void move(Tile t) {
		System.out.println("Player\tvoid move(Tile)\tparam: " + t);
	}
	
	/**
	 * @return energy - Visszater a jatekos munkakedvevel.
	 */
	public int getEnergy() {
		System.out.println("Player\tint getEnergy()\tparam: -");
		return energy;
	}
	
	public void die() {
		System.out.println("Player\tvoid die()\tparam: -");
	}
	
	public int scream() {
		System.out.println("Player\tint scream()\tparam: -");
		return 1;
	}
	
	public boolean savePlayer(Player p) {
		System.out.println("Player\tvoid savePlayer(Player)\t param: " + p);
		return true;
	}

	public void setInWater(boolean inWater) {
		System.out.println("Player\tvoid setInWater()\tparam: " + inWater);
	}
	
	public boolean getWetsuit() {
		System.out.println("Player\tboolean getWetsuit()\tparam: -");
		return false;
	}
	
	public int exploreTile(Tile chosenTile) {
		return -1;
	}
	
	public boolean buildIgloo(Tile chosenTile) {
		System.out.println("Player\tboolean buildIgloo(Tile\tparam: " + chosenTile);
		return false;
	}
	
	public void pushToWater() {
		System.out.println("Player\tvoid pushToWater()\tparam: -");
	}
	
	public int getTemperature() {
		System.out.println("Player\tvoid getTemperature()\tparam: -");
		return bodyTemperature;
	}
	
	public void heal(int amount) {
		System.out.println("Player\tvoid heal()\tparam: " + amount);
		bodyTemperature += amount;
	}
	
	public boolean damage(int amount) {
		System.out.println("Player\tboolean damage()\tparam: " + amount);
		bodyTemperature -= amount;
		if (bodyTemperature == 0) return true;
		return false;
	}
	
	public void setEnergy(int amount) {
		System.out.println("Player\tvoid setEnergy()\tparam: " + amount);
		energy += amount;
	}
	
	/**
	 * 	A jakos adott korben t�rteno cselekvéseit beindító függvény.
	 *  Visszatérési értéke megadja, hogy mennyi munkakedve van még a
	 *	játékosnak. Mivel a Player absztrakt osztály, így itt csak deklarálásra kerül, a
	 *	pontos működés a leszármazottakban valósul meg.
	 *  @return energy - A megmaradt munkakedv értéke
	 * 
	 */
	@Override
	public int step() {
		System.out.println("Player\tint step()\tparam: -");
		return energy;
	}
}