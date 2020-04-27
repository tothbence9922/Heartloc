package entity.player;

import java.util.ArrayList;

import entity.Entity;
import entity.item.Item;
import model.Drawable;
import model.Game;
import tiles.StableTile;
import tiles.Tile;

/**
 * Absztrakt ososztaly a jatekban szereplo karaktereknek. Deklaralja az alapveto
 * mukodeshez szukseges attributumokat es metodusokat, melyek a
 * leszarmazottakban kerulnek kifejtesre
 */
public abstract class Player extends Entity implements Drawable {

	protected int energy = 4;
	protected int bodyTemperature = 4;

	protected boolean inWater = false;

	protected ArrayList<Item> inventory = new ArrayList<Item>();

	protected Tile currentTile = new StableTile("");

	public Player(String id) {
		super(id);
	}
	
	public void setCurrentTile(Tile t) {
		currentTile = t;
	}

	@Override
	public String toString() {
		String itemString = "";
		if (inventory.isEmpty())
			itemString = "empty";
		else {
			itemString = "[";
			int i;
			for (i = 0; i < inventory.size() - 1; i++)
				itemString = itemString + (inventory.get(i).getId()) + ", ";
			itemString = itemString + (inventory.get(i).getId());

			itemString = itemString + "]";
		}
		String playerString = id + "(" + String.valueOf(bodyTemperature) + ", " + String.valueOf(energy) + ", "
				+ itemString + ")" + "\n";
		return playerString;

	}

	/**
	 * Ezzel a metodussal kerul at a jatekos egyik jegtablarol a masikra.
	 * 
	 * @param t az a Tile amelyikre a jatekos mozogni kivan
	 */
	public void move(Tile t) {
		currentTile.remove(this);
		t.receive(this);
		setCurrentTile(t);
		this.energy--;
		if (t.getHasHole()) {
			this.pushToWater();
			boolean success = false;
			for (Item i : inventory) {
				if (i.wear())
					success = true;
				System.out.println("asd");

			}
			if (success) return;
			else {
				this.setInWater(true);
				this.scream();
				success = false;
				for (Tile nt : t.getNeighbours()) {
					if (nt.alarmTile(this))
						success = true;
				}
				if (success)
					return;
				else {
					this.die();
				}

			}
		}
	}

	/**
	 * Ha bizonyos szint ala csokken a jatekos testhomerseklete, akkor fagyhalalt
	 * hal. Ez a metodus kezdemenyezi ezt a folyamatot.
	 */
	public void die() {
		this.bodyTemperature = 0;
		Game.getInstance();
		Game.Defeat();
		Game.EndGame();
	}

	/**
	 * Ha egy jatekos a vizbe esik, es nincs rajta Wetsuit, akkor sikit, hogy a
	 * szomszedos jegtablan allo tarsai meghalljak
	 */
	public int scream() {
		return 1;
	}

	public boolean isInWater() {
		return inWater;
	}

	/**
	 * Ha egy jatekos olyan jegtablan tartozkodik, melyen hallja egy masik jatekos
	 * sikitasat, es van a taskajaban (Inventory) egy kötel (Rope), akkor kimenti a
	 * jatekost.
	 * 
	 * @param p a kimentendo jatekos
	 * @return ki tudja-e menteni a jatekos
	 */
	public boolean savePlayer(Player p) {
		boolean success = false;
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).pull(p))
				success = true;
		}
		if (!success)
			return false;
		else {
			p.move(this.currentTile);
			return true;
		}
	}

	/**
	 * Ha egy jatekos lyukba lep, vagy instabil jegtablara, ami atfordul, akkor ez a
	 * fuggveny jelzi, hogy vizbe kerult.
	 * 
	 * @param inWater beallitja, hogy vizben van-e az adott jatekos
	 */
	public void setInWater(boolean value) {
		inWater = value;
		if (!getWetsuit()) {
			scream();
			// Tile[] t = currentTile.getNeighbours();
			// for (int i = 0; i < t.length(); i++) {
			// t[i].alarmTile(this);
			// }
		}
	}

	/**
	 * Visszater a parameterben atadott Tile teherbirasaval
	 * 
	 * @param chosenTile - a megfigyelni kivant Tile ID-je
	 * @return capacity - a Tile teherbirasa, -1 eseten stabil, -2 eseten Eskimo
	 *         hivta
	 */
	abstract public int exploreTile(String chosenTile);

	/**
	 * Igloo-t epit a parameterben megadott Tile-ra
	 * 
	 * @param chosenTile
	 * @return
	 */
	abstract public boolean buildIgloo(Tile chosenTile);

	/**
	 * Jatekost a vizbe loki, beallija a setInWater erteket igazra
	 */
	public void pushToWater() {
		for (int i = 0; i < inventory.size(); i++) {
			inventory.get(i).wear();
		}
		setInWater(true);
	}

	/**
	 * A jatekos testhomersekletet noveli a parameterben megadott ertekkel.
	 * 
	 * @param amount
	 */
	public void heal(int amount) {
		bodyTemperature += amount;
	}

	/**
	 * A jatekos testhomersekletet csokkeni a parameterben megadott ertekkel
	 * 
	 * @param amount
	 */
	public void damage(int amount) {
		bodyTemperature -= amount;
	}

	/**
	 * A parameterkent kapott Itemet az Inventory-ba teszi
	 * 
	 * @param i: Item
	 */
	public void addToInventory(Item i) {
		this.inventory.add(i);
	}

	/*******************************
	 *
	 * 
	 * 
	 * Getters and setters
	 * 
	 * 
	 * 
	 *******************************/

	/**
	 * Ha van a jatekos birtokaban Wetsuit (a fuggveny visszateresi erteke true),
	 * akkor azt felveszi es ezaltal megmenekul vizbeeses eseten, kesobb kiuszhat.
	 * 
	 * @return rendelkezik-e Wetsuittal az adott jatekos
	 */
	public boolean getWetsuit() {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).wear()) {
				return true;
			}
		}
		return false;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int amount) {
		energy = amount;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public int getTemperature() {
		return bodyTemperature;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(int bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public Tile getCurrentTile() {
		return currentTile;
	}

	@Override
	public int step() {
		return energy;
	}

}