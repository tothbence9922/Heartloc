package tiles;

import java.util.ArrayList;
import java.util.Random;

import entity.Entity;
import entity.Igloo;
import entity.item.Item;
import entity.player.Player;
import model.Drawable;

/**
 * A játék egyik alapegységét képezõ objektum, ezeken helyezkednek el a
 * különféle entitások: játékosok, tárgyak, igluk, lyukak és hó.
 * 
 * @author tothbence9922 & komendamate
 *
 */
public abstract class Tile implements Drawable {

	// beirni a holland dokumentumba
	protected ArrayList<Player> players;
	//protected Item item = null; nem kell ?
	protected ArrayList<Item> items;

	public ArrayList<Item> getItems() {
		return items;
	}

	public void addItems(Item items) {
		this.items.add(items);
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

	public ArrayList<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
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

	protected boolean hasHole = false;
	protected boolean hasItem = false;
	protected boolean hasIgloo = false;
	protected boolean hasTent = false;
	protected boolean hasPolarBear = false;
	protected int amountOfSnow;
	protected int numOfTargetItems;
	protected int capacity;
	protected ArrayList<Tile> tiles;
	// beirni a holland dokumentumba
	protected boolean showCapacity;

	/**
	 * A Tile osztály alapértelmezett konstruktora, mely egy üres ArrayList<Player>
	 * -rel inicializálja a players attribútumot.
	 */
	public Tile() {
		this.players = new ArrayList<Player>();
	}

	/**
	 * A metódus használatával ásható ki tárgy, illetve takarítható el hó.
	 * Paraméterként átadható, hogy mennyit ásson egy munka felhasználásával. Ha a
	 * játékos rendelkezik lapáttal, akkor 2 egységnyit tud ásni egy munkavégzéssel,
	 * egyébként 1 egységnyit. Ha egy tárgy látható, akkor ásás után azzal a
	 * tárggyal tér vissza, egyébként null értékkel.
	 * 
	 * @param amount
	 * @return Item
	 */
	public ArrayList<Item> dig(int amount) {
		this.removeSnow(amount);
		if(this.amountOfSnow <= 0) {
			for(int i = 0; i < items.size(); i++) {
				items.get(i).setIsVisible(true);
			}
			return this.items;
		}
		return null;
	}

	/**
	 * Az adott jégtáblán elérhetõ TargetItemek számával tér vissza. Ennek a
	 * metódusnak a felhasználásával deríthetõ ki, hogy a játék végét jelentõ
	 * jelzõrakéta összeszerelése és elsütése megkezdhetõ-e, azaz egy jégtáblán
	 * van-e mind a három.
	 * 
	 * @return int
	 */
	public int getNumOfTargetItems() {
		System.out.println("Tile\tint getNumOfTargetItems()\tparam: -");
		return this.numOfTargetItems;
	}

	/**
	 * Jégtábla létrehozása után annak inicializálást végzõ metódus, ebben dõl el,
	 * hogy lesz-e lyuk vagy tárgy az adott jégtáblán.
	 * 
	 * @return boolean
	 */
	public boolean initTile() {
		System.out.println("Tile\tboolean initTile()\tparam: -");
		return true;
	}

	/**
	 * A paraméterben kapott entitást a jégtáblára mozgatja
	 * 
	 * @param e
	 * @return boolean
	 */
	public boolean receive(Entity e) {
		System.out.println("Tile\tboolean receive(Entity)\tparam: " + e);
		players.add((Player) e);
		if (players.get(players.size() - 1) == (Player) e) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * A paraméterben kapott entitást a jégtábláról eltávolítja.
	 * 
	 * @param e - Az Entity, amit el szeretnénk eltávolítani a mezõrõl.
	 */
	public void remove(Entity e) {
		System.out.println("Tile\tvoid remove(Entity)\tparam: " + e);
		players.remove((Player) e);
	}

	/**
	 * A paraméterben kapott entitást a jégtábláról eltávolitja.
	 * 
	 * @param e
	 * @return boolean
	 */
	public boolean getHasHole() {
		System.out.println("Tile\tboolean getHasHole()\tparam: -");
		if (this.hasHole) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Visszatér azzal, hogy az adott jégtáblán van-e lyuk.
	 * 
	 * @return boolean
	 */
	public boolean assembleRocket() {
		System.out.println("Tile\tbooelan assembleRocket()\tparam: -");
		if(getNumOfTargetItems() == 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * True értékkel tér vissza, ha az adott jégtáblán összeszerelhetõ a
	 * jelzõrakéta, egyébként false.
	 * 
	 * @return boolean
	 */
	public ArrayList<Tile> getNeighbours() {
		System.out.println("Tile\tTile[] getNeighbours()\tparam: -");

		Tile t1 = new StableTile();
		Tile t2 = new StableTile();
		Tile[] tiles = { t1, t2 };
		return null;
	}

	/**
	 * Játékos sikítása esetén hívódik meg, paraméterként a vízbe esett játékossal,
	 * akit így egy megfelelõ távolságra lévõ, másik jégtáblán tartózkodó játék – ha
	 * van kötele – ki tud menteni.
	 * 
	 * @param p
	 * @return boolean
	 */
	public boolean alarmTile(Player p) {
		System.out.println("Tile\tboolean alarmTile(Entity)\tparam: " + p);
		ArrayList<Tile> neighbours = getNeighbours();
		for(int i = 0; i < neighbours.size(); i++) {
			for(int j = 0; j < neighbours.get(i).players.size(); j++) {
				for(int k = 0; k < neighbours.get(i).players.get(j).inventory.size(); k++) {
					if(neighbours.get(i).players.get(j).inventory.get(k) == ) {
						
					}
				}
				
			}
			
		}
	}

	/**
	 * Paraméterként megadott mennyiségû havat rak az adott jégtáblára.
	 * 
	 * @param amount
	 */
	public void addSnow(int amount) {
		amountOfSnow += amount;
		System.out.println("Tile\tvoid addSnow(int)\tparam: " + amount);
	}

	/**
	 * Paraméterként megadott mennyiségû havat távolít el az adott jégtábláról.
	 * 
	 * @param amount
	 */
	public void removeSnow(int amount) {
		amountOfSnow -= amount;
		System.out.println("Tile\tvoid removeSnow(int)\tparam: " + amount);
	}

	/**
	 * Láthatóvá teszi az adott jégtáblán, hogy mekkora a kapacitása (az Explorer
	 * képességének használata során).
	 * 
	 * @param b
	 */
	public void setCapacityVisible(boolean b) {
		System.out.println("Tile\tvoid setCapacityVisible(boolean)\tparam: -" + b);
		this.showCapacity = b;
	}

	/**
	 * Visszatér egy jégtáblának az aktuális jégtáblától való távolságával.
	 * 
	 * @return int
	 */
	public int getDistance() {
		System.out.println("Tile\tint getDistance()\tparam: -");
		return 0;
	}

	/**
	 * Hóvihar kezdetét jelenti
	 */
	public void storm(Random r) {
		System.out.println("Tile\tvoid storm(Random)\tparam: " + r);
		amountOfSnow += r.nextInt(3);
		if (amountOfSnow > 5)
			amountOfSnow = 5;
		if(this.hasIgloo == false || this.hasTent == false) {
			for (Player p : players) {
				p.damage(1);
			}
		}
	}

	/**
	 * Visszatér az adott jégtáblán tartózkodó játékosokkal
	 * 
	 * @return Player[]
	 */
	public ArrayList<Player> getPlayers() {
		System.out.println("Tile\tPlayer[] getPlayers()\tparam: -");
		return this.players;
	}
	
	public boolean getDefense() {
		if(this.hasIgloo || this.hasTent) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Visszatér az adott jégtáblán lévõ igluval, ha nincs null értékkel.
	 * 
	 * @return Igloo
	 */
	/*public Igloo getIgloo() {
		System.out.println("Tile\tIgloo getIgloo()\tparam: -");
		if(this.hasIgloo) {
			for(int i = 0 ; i < items.size(); i++) {
				if(items.get(i) == "Igloo") {
					return items.get(i);
				}
			}
		}else {
			return null;
		}
	}*/

}
