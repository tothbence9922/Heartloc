package tiles;

import java.util.ArrayList;
import java.util.Random;
import entity.Entity;
import entity.Hole;
import entity.Igloo;
import entity.item.Item;
import entity.player.Player;
import model.Drawable;
import model.PolarBear;

/**
 * A jatek egyik alapegyseget kepezo objektum, ezeken helyezkednek el a
 * kulonfele entitasok: jatekosok, targyak, igluk, lyukak es ho.
 */
public abstract class Tile implements Drawable {

	protected String id;

	protected int amountOfSnow;
	protected int numOfTargetItems;
	protected int capacity;

	protected boolean hasHole = false;
	protected boolean hasItem = false;
	protected boolean hasIgloo = false;
	protected boolean hasTent = false;
	protected boolean hasPolarBear = false;
	protected boolean showCapacity = false; // TODO beirni a holland dokumentumba

	protected ArrayList<Player> players; // TODO beirni a holland dokumentumba
	protected ArrayList<PolarBear> bears; // TODO beirni a holland dokumentumba
	protected ArrayList<Tile> neighbours; // TODO beirni a holland dokumentumba
	protected ArrayList<Item> items; // TODO beirni a holland dokumentumba

	protected Igloo igloo;

	/**
	 * A Tile osztaly alapertelmezett konstruktora, mely egy ures ArrayList-tel
	 * inicializalja a players attributumot.
	 */
	public Tile(String id) {
		this.id = id;
		this.players = new ArrayList<Player>();
	}

	/**
	 * A metodus hasznalataval ashato ki targy, illetve takarithato el ho.
	 * Parameterkent atadhato, hogy mennyit asson egy munka felhasznalasaval. Ha a
	 * jatekos rendelkezik lapattal, akkor 2 egysegnyit tud asni egy munkavegzessel,
	 * egyebkent 1 egysegnyit. Ha egy targy lathato, akkor asas utan azzal a
	 * targgyal ter vissza, egyebkent null ertekkel.
	 * 
	 * @param amount
	 * @return Item
	 */
	public ArrayList<Item> dig(int amount) {
		this.removeSnow(amount);
		if (this.amountOfSnow <= 0) {
			for (int i = 0; i < items.size(); i++) {
				items.get(i).setIsVisible(true);
			}
			return this.items;
		}
		return null;
	}

	/**
	 * Az adott jegtablan elerheto TargetItemek szamaval ter vissza. Ennek a
	 * metodusnak a felhasznalasaval deritheto ki, hogy a jatek veget jelento
	 * jelzoraketa osszeszerelese es elsutese megkezdheto-e, azaz egy jegtablan
	 * van-e mind a harom.
	 * 
	 * @return int
	 */
	public int getNumOfTargetItems() {
		System.out.println("Tile\tint getNumOfTargetItems()\tparam: -");
		return this.numOfTargetItems;
	}

	/**
	 * Jegtabla letrehozasa utan annak inicializalast vegzo metodus, ebben dol el,
	 * hogy lesz-e lyuk vagy targy az adott jegtablan.
	 * 
	 * @return boolean
	 */
	public boolean initTile() {
		return true;
	}

	/**
	 * A parameterben kapott entitast a jegtablara mozgatja
	 * 
	 * @param e
	 * @return boolean
	 */
	public boolean receive(Entity e) {
		players.add((Player) e);
		if (players.get(players.size() - 1) == (Player) e) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * A parameterben kapott entitast a jegtablarol eltavolitja.
	 * 
	 * @param e - Az Entity, amit el szeretnenk eltavolitani a mezorol.
	 */
	public void remove(Entity e) {
		players.remove((Player) e);
	}

	/**
	 * A parameterben kapott entitast a jegtablarol eltavolitja.
	 * 
	 * @param e
	 * @return boolean
	 */
	public boolean getHasHole() {
		if (this.hasHole) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Visszater azzal, hogy az adott jegtablan van-e lyuk.
	 * 
	 * @return boolean
	 */
	public boolean assembleRocket() {
		if (getNumOfTargetItems() == 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * True ertekkel ter vissza, ha az adott jegtablan osszeszerelheto a
	 * jelzoraketa, egyebkent false.
	 * 
	 * @return boolean
	 */

	/**
	 * Jatekos sikitasa eseten hivodik meg, parameterkent a vizbe esett jatekossal,
	 * akit igy egy megfelelo tavolsagra levo, masik jegtablan tartozkodo jatek – ha
	 * van kotele – ki tud menteni.
	 * 
	 * @param p
	 * @return boolean
	 */
	public boolean alarmTile(Player p) {
		/*
		 * TODO for(int i = 0; i < neighbours.size(); i++) { for(int j = 0; j <
		 * neighbours.get(i).players.size(); j++) { for(int k = 0; k <
		 * neighbours.get(i).players.get(j).inventory.size(); k++) {
		 * if(neighbours.get(i).players.get(j).inventory.get(k) == ) {
		 * 
		 * } }
		 * 
		 * }
		 * 
		 * }
		 */
		return false;
	}

	/**
	 * Parameterkent megadott mennyisegu havat rak az adott jegtablara.
	 * 
	 * @param amount
	 */
	public void addSnow(int amount) {
		amountOfSnow += amount;
		System.out.println("Tile\tvoid addSnow(int)\tparam: " + amount);
	}

	/**
	 * Parameterkent megadott mennyisegu havat tavolit el az adott jegtablarol.
	 * 
	 * @param amount
	 */
	public void removeSnow(int amount) {
		amountOfSnow -= amount;
		System.out.println("Tile\tvoid removeSnow(int)\tparam: " + amount);
	}

	/**
	 * Hovihar kezdetet jelenti
	 */
	public void storm(Random r) {
		System.out.println("Tile\tvoid storm(Random)\tparam: " + r);
		amountOfSnow += r.nextInt(3);
		if (amountOfSnow > 5)
			amountOfSnow = 5;
		if (this.hasIgloo == false || this.hasTent == false) {
			for (Player p : players) {
				p.damage(1);
			}
		}
	}
	
	public void addPolarBear(PolarBear polarBear) {
		// TODO
	}

	public void addIgloo(Igloo igloo2) {
		// TODO
	}

	public void addHole(Hole hole) {
		// TODO
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

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	public boolean getDefense() {
		if (this.hasIgloo || this.hasTent) {
			return true;
		} else {
			return false;
		}
	}

	public void addNeighbour(Tile tile) {
		// TODO Auto-generated method stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCapacityVisible(boolean b) {
		this.showCapacity = b;
	}

	public int getDistance() {
		return 0;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public boolean isHasItem() {
		return hasItem;
	}

	public void setHasItem(boolean hasItem) {
		this.hasItem = hasItem;
	}

	public boolean isHasIgloo() {
		return hasIgloo;
	}

	public void setHasIgloo(boolean hasIgloo) {
		this.hasIgloo = hasIgloo;
	}

	public boolean isHasTent() {
		return hasTent;
	}

	public void setHasTent(boolean hasTent) {
		this.hasTent = hasTent;
	}

	public boolean isHasPolarBear() {
		return hasPolarBear;
	}

	public void setHasPolarBear(boolean hasPolarBear) {
		this.hasPolarBear = hasPolarBear;
	}

	public int getAmountOfSnow() {
		return amountOfSnow;
	}

	public void setAmountOfSnow(int amountOfSnow) {
		this.amountOfSnow = amountOfSnow;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public ArrayList<Tile> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<Tile> neighbours) {
		this.neighbours = neighbours;
	}

	public boolean isShowCapacity() {
		return showCapacity;
	}

	public void setShowCapacity(boolean showCapacity) {
		this.showCapacity = showCapacity;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void setHasHole(boolean hasHole) {
		this.hasHole = hasHole;
	}

	public void setNumOfTargetItems(int numOfTargetItems) {
		this.numOfTargetItems = numOfTargetItems;
	}
	
}
