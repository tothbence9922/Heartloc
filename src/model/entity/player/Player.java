package model.entity.player;

import java.util.ArrayList;

import controller.GameRunner;
import model.entity.Entity;
import model.entity.Tent;
import model.entity.item.Item;
import model.tiles.StableTile;
import model.tiles.Tile;
import view.entity.ExplorerView;

/**
 * Absztrakt ososztaly a jatekban szereplo karaktereknek. Deklaralja az alapveto
 * mukodeshez szukseges attributumokat es metodusokat, melyek a
 * leszarmazottakban kerulnek kifejtesre
 */
public abstract class Player extends Entity {
		
	protected int energy = 4;
	protected int bodyTemperature = 4;

	protected boolean inWater = false;

	protected ArrayList<Item> inventory = new ArrayList<Item>();

	protected Tile currentTile = new StableTile("");

	public Player(String id) {
		super(id);
		view = new ExplorerView(GameRunner.baseGameController);
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
	 * A targyak (Item-ek) eldobhatok, ekkor arra a Tile-re kerulnek amin az a
	 * Player all aki eldobta.
	 * 
	 */
	public void drop(Item i) {
		currentTile.getItems().add(i);
		inventory.remove(i);
	}

	/**
	 * A targyak a jaték kezdeten a jegtablakba vannak fagyva. Miutan kiastak oket
	 * es lathatoak, fel lehet venni a targyakat.
	 * 
	 */
	public void pickup() {
		for(Item i : currentTile.getItems()) {
			inventory.add(i);
		}
		currentTile.getItems().clear();
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

		if (currentTile.getCapacity()!= (-1) && currentTile.getCapacity() < currentTile.getLoad()) {
			for (Player p : currentTile.getPlayers()) {
				if(!p.equals(this)) p.pushToWater();
			}
			this.pushToWater();
		}

		else if (t.getHasHole()) {
			this.pushToWater();

		}
	}


	/**
	 * Ha bizonyos szint ala csokken a jatekos testhomerseklete, akkor fagyhalalt
	 * hal. Ez a metodus kezdemenyezi ezt a folyamatot.
	 */
	public void die() {
		this.bodyTemperature = 0;
		//Game.getInstance();
		//Game.Defeat();
		//Game.EndGame();
	}

	/**
	 * Ha egy jatekos a vizbe esik, es nincs rajta Wetsuit, akkor sikit, hogy a
	 * szomszedos jegtablan allo tarsai meghalljak
	 */
	public int scream() {
		for (Tile nt : currentTile.getNeighbours())
			if (nt.alarmTile(this)) return 1;
		
		return -1;	
	}

	public boolean isInWater() {
		return inWater;
	}

	/**
	 * Ha egy jatekos olyan jegtablan tartozkodik, melyen hallja egy masik jatekos
	 * sikitasat, es van a taskajaban (Inventory) egy kÃ¶tel (Rope), akkor kimenti a
	 * jatekost.
	 * 
	 * @param p a kimentendo jatekos
	 * @return ki tudja-e menteni a jatekos
	 */
	public boolean savePlayer(Player p) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).pull(p))
				return true;
		}
		return false;
	}
	
	/**
	 * A jelzoraketa (Rocket) tobb alkatreszbol (TargetItem-bol) all ossze. Ketfele
	 * Item letezik: TargetItem es OptionalItem. A TargetItem-ek erdemlegesen
	 * megvalositjak ezt a metodust, mig az OptionalItem-ek csak technikai okok
	 * miatt (mivel oroklik es nem absztrakt osztalyok) valositjak meg ezt a
	 * metodust.
	 * 
	 * @return Az osszeszereles sikeresseget true visszateres jelzi, ellenkezoleg
	 *         false.
	 */
	public boolean assembleRocket() {
		int cnt = 0;
		for(Item i : inventory) {
			if (i.useTargetItem()) cnt++;
		}
		if (cnt >= 3) return true;
		return false;
	}

	/**
	 * Ha egy jatekos lyukba lep, vagy instabil jegtablara, ami atfordul, akkor ez a
	 * fuggveny jelzi, hogy vizbe kerult.
	 * 
	 * @param inWater beallitja, hogy vizben van-e az adott jatekos
	 */
	public void setInWater(boolean value) {
		inWater = value;		
	}

	/**
	 * Visszater a parameterben atadott Tile teherbirasaval
	 * 
	 * @param chosenTile - a megfigyelni kivant Tile ID-je
	 * @return capacity - a Tile teherbirasa, -1 eseten stabil, -2 eseten nem Explorer
	 *         hivta
	 */
	public int exploreTile(String chosenTile) {
		return -2;
	}

	/**
	 * Igloo-t epit a parameterben megadott Tile-ra. Mivel ez eszkimo kepesseg, alapvetoen false-t ad vissza,
	 *  Eskimo eseten true-t.
	 * 
	 * @param chosenTile
	 * @return
	 */
	public boolean buildIgloo(Tile chosenTile) { return false;}

	/**
	 * Jatekost a vizbe loki, beallija a setInWater erteket igazra
	 */
	public void pushToWater() {
			setInWater(true);
			
			boolean success = false;
			for (Item i : inventory) {
				if (i.wear())
				success = true;
			}
			if (success) return;
			

			if (scream() > 0) return;

			die();
	}

	/**
	 * Tentet epit a parameterben megadott Tile-ra
	 * 
	 * @param chosenTile
	 * @return
	 */
	public boolean buildTent(Tile chosenTile) {
		if (energy > 0) {
			chosenTile.addTent(new Tent("Tent1"));

			if (chosenTile.getCapacity() < chosenTile.getPlayers().size() + 1) {
				for (int i = 0; i < chosenTile.getPlayers().size(); i++) {
					chosenTile.getPlayers().get(i).pushToWater();
				}
			}

			this.energy--;
			return true;
		}
		return false;
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

	public void setCurrentTile(Tile t) {
		currentTile = t;
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