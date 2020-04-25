package entity.player;

import java.util.ArrayList;

import entity.Entity;
import entity.item.Item;
import model.Drawable;
import model.Game;
import tiles.Tile;

/**
 * Absztrakt ősosztálya a játékban szereplő karaktereknek. Deklarálja az
 * alapvető működéshez szükséges attribútumokat és metódusokat, melyek a
 * leszármazottakban kerülnek kifejtésre
 */
public abstract class Player extends Entity implements Drawable {

	public Player(String id) {
		super(id);
	}

	private ArrayList<Item> inventory = new ArrayList<Item>();
	protected int energy = 4;
	protected int bodyTemperature = 4;
	protected boolean inWater = false;

	/**
	 * Ezzel a metódussal kerül át a játékos egyik jégtábláról a másikra.
	 * 
	 * @param t az a Tile amelyikre a játékos mozogni kíván
	 */
	public void move(Tile t) {
		t.receive(this);
		//ot.remove(this);

	}

	/**
	 * Visszatér az adott játékos aktuális munkakedvével.
	 * 
	 * @return energy a játékos munkakedve
	 */
	public int getEnergy() {
		return energy;
	}

	/**
	 * Ha bizonyos szint alá csökken a játékos testhőmérséklete, akkor fagyhalált
	 * hal. Ez a metódus kezdeményezi ezt a folyamatot.
	 */
	public void die() {
		Game.getInstance();
		Game.Defeat();
		Game.EndGame();
	}

	/**
	 * Ha egy játékos a vízbe esik, és nincs rajta Wetsuit, akkor sikít, hogy a
	 * szomszédos jégtáblán álló társai meghallják
	 */
	public int scream() {
		return 1;
	}

	/**
	 * Ha egy játékos olyan jégtáblán tartózkodik, melyen hallja egy másik játékos
	 * sikítását, és van a táskájában (Inventory) egy kötél (Rope), akkor kimenti a
	 * játékost.
	 * 
	 * @param p a kimentendő játékos
	 * @return ki tudja-e menteni a játékos
	 */
	public boolean savePlayer(Player p) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).pull(p)) {
				//p.move(currentTile);
			}
		}
		return true;
	}

	/**
	 * Ha egy játékos lyukba lép, vagy instabil jégtáblára, ami átfordul, akkor ez a
	 * függvény jelzi, hogy vízbe került.
	 * 
	 * @param inWater beállítja, hogy vízben van-e az adott játékos
	 */
	public void setInWater(boolean value) {
		inWater = value;
		if (!getWetsuit()) {
			scream();
			//Tile[] t = currentTile.getNeighbours();
			//for (int i = 0; i < t.length(); i++) {
				//t[i].alarmTile(this);
			//}

		}
	}

	/**
	 * Ha van a játékos birtokában Wetsuit (a függvény visszatérési értéke true),
	 * akkor azt felveszi és ezáltal megmenekül vízbeesés esetén, később kiúszhat.
	 * 
	 * @return rendelkezik-e Wetsuittal az adott játékos
	 */
	public boolean getWetsuit() {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).wear()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Az ősosztályból származó metódus, mely itt az Explorer képességét valósítja
	 * meg: a játékos pozíciójától legfeljebb 3 távolságra lévő jégtáblák közül
	 * egyről megállapítja a teherbírását.
	 * 
	 * @param chosenTile a felfedezendő jégtábla
	 * @return a felfedezett jégtáblának a teherbírása
	 */
	abstract public int exploreTile(Tile chosenTile);

	/**
	 * Az ősosztályból származó metódus, mely itt az Eszkimó képességét valósítja
	 * meg: épít egy iglut arra a jégtáblára, ahol az Eszkimó áll.
	 * 
	 * @param chosenTile az a jégtábla, melyre az Eskimo Igloo-t épít
	 * @return sikerrel járt-e az építés
	 */
	abstract public boolean buildIgloo(Tile chosenTile);

	/**
	 * Ha olyan jégtáblára lép a játékos , mely instabil vagy lyuk van rajta, akkor
	 * ez a függvény indítja el az ilyenkor lezajló eseményeket.
	 */
	public void pushToWater() {
		for (int i = 0; i < inventory.size(); i++) {
			inventory.get(i).wear();
		}
		setInWater(true);
	}

	/**
	 * Visszatér a játékos aktuális testhőmérsékletével.
	 * 
	 * @return
	 */
	public int getTemperature() {
		return bodyTemperature;
	}

	/**
	 * A játékos testhőmérsékletét növeli a paraméterben megadott értékkel.
	 * 
	 * @param amount az a mennyiség, amivel a játékos élete növelve lesz
	 */
	public void heal(int amount) {
		bodyTemperature += amount;
	}

	/**
	 * A játékos testhőmérsékletét csökkenti a paraméterben megadott értékkel.
	 * 
	 * @param amount az a mennyiség, amivel a játékos élete csökken
	 * @return
	 */
	public void damage(int amount) {
		bodyTemperature -= amount;
	}

	/**
	 * Játékos munkakedvét (energy) a paraméterben megadott értékre állítja.
	 * 
	 * @param amount beállítja a játékos munkakedvét
	 */
	public void setEnergy(int amount) {
		energy = amount;
	}
  
  /**
	 * Beletesz egy item-et az inventory-ba
	 * @param i: Item
	 */
	public void addToInventory(Item i) {
		this.inventory.add(i);
	}
  
  public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
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

	public boolean isInWater() {
		return inWater;
	}

	/**
	 * A játékos adott körben történő cselekvéseit beindító függvény. Visszatérési
	 * értéke megadja, hogy mennyi munkakedve van még a játékosnak.
	 * 
	 * @return a játékos maradék munkakedve
	 */
	@Override
	public int step() {
		return energy;
	}

	public String getCurrentTile() {
		// TODO Auto-generated method stub
		return null;
	}
}