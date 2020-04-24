package entity.player;

import java.util.ArrayList;

import entity.Entity;
import entity.item.Item;
import model.Drawable;
import tiles.Tile;

/**
 * Absztrakt õsosztálya a játékban szereplõ karaktereknek. Deklarálja az
 * alapvetõ mûködéshez szükséges attribútumokat és metódusokat, melyek a
 * leszármazottakban kerülnek kifejtésre
 */
public abstract class Player extends Entity implements Drawable {

	private ArrayList<Item> inventory = new ArrayList<Item>();
	protected int energy = 4;
	protected int bodyTemperature = 4;
	protected boolean inWater = false;

	public Player(String id) {
		super(id);
	}

	/**
	 * Ezzel a metódussal kerül át a játékos egyik jégtábláról a másikra.
	 * 
	 * @param t az a Tile amelyikre a játékos mozogni kíván
	 */
	public void move(Tile t) {
		System.out.println("Player\tvoid move(Tile)\tparam: " + t);
	}

	/**
	 * Visszatér az adott játékos aktuális munkakedvével.
	 * 
	 * @return energy a játékos munkakedve
	 */
	public int getEnergy() {
		System.out.println("Player\tint getEnergy()\tparam: -");
		return energy;
	}

	/**
	 * Ha bizonyos szint alá csökken a játékos testhõmérséklete, akkor fagyhalált
	 * hal. Ez a metódus kezdeményezi ezt a folyamatot.
	 */
	public void die() {
		System.out.println("Player\tvoid die()\tparam: -");
	}

	/**
	 * Ha egy játékos a vízbe esik, és nincs rajta Wetsuit, akkor sikít, hogy a
	 * szomszédos jégtáblán álló társai meghallják
	 */
	public int scream() {
		System.out.println("Player\tint scream()\tparam: -");
		return 1;
	}

	/**
	 * Ha egy játékos olyan jégtáblán tartózkodik, melyen hallja egy másik játékos
	 * sikítását, és van a táskájában (Inventory) egy kötél (Rope), akkor kimenti a
	 * játékost.
	 * 
	 * @param p a kimentendõ játékos
	 * @return ki tudja-e menteni a játékos
	 */
	public boolean savePlayer(Player p) {
		System.out.println("Player\tvoid savePlayer(Player)\t param: " + p);
		return true;
	}

	/**
	 * Ha egy játékos lyukba lép, vagy instabil jégtáblára, ami átfordul, akkor ez a
	 * függvény jelzi, hogy vízbe került.
	 * 
	 * @param inWater beállítja, hogy vízben van-e az adott játékos
	 */
	public void setInWater(boolean inWater) {
		System.out.println("Player\tvoid setInWater()\tparam: " + inWater);
	}

	/**
	 * Ha van a játékos birtokában Wetsuit (a függvény visszatérési értéke true),
	 * akkor azt felveszi és ezáltal megmenekül vízbeesés esetén, késõbb kiúszhat.
	 * 
	 * @return rendelkezik-e Wetsuittal az adott játékos
	 */
	public boolean getWetsuit() {
		System.out.println("Player\tboolean getWetsuit()\tparam: -");
		return false;
	}

	/**
	 * Az õsosztályból származó metódus, mely itt az Explorer képességét valósítja
	 * meg: a játékos pozíciójától legfeljebb 3 távolságra lévõ jégtáblák közül
	 * egyrõl megállapítja a teherbírását.
	 * 
	 * @param chosenTile a felfedezendõ jégtábla
	 * @return a felfedezett jégtáblának a teherbírása
	 */
	public int exploreTile(Tile chosenTile) {
		return -1;
	}

	/**
	 * Az õsosztályból származó metódus, mely itt az Eszkimó képességét valósítja
	 * meg: épít egy iglut arra a jégtáblára, ahol az Eszkimó áll.
	 * 
	 * @param chosenTile az a jégtábla, melyre az Eskimo Igloo-t épít
	 * @return sikerrel járt-e az építés
	 */
	public boolean buildIgloo(Tile chosenTile) {
		System.out.println("Player\tboolean buildIgloo(Tile\tparam: " + chosenTile);
		return false;
	}

	/**
	 * Ha olyan jégtáblára lép a játékos (jelent esetben Eszkimó), mely instabil
	 * vagy lyuk van rajta, akkor ez a függvény indítja el az ilyenkor lezajló
	 * eseményeket.
	 */
	public void pushToWater() {
		System.out.println("Player\tvoid pushToWater()\tparam: -");
	}

	/**
	 * Visszatér a játékos (ez esetben Eszkimó) aktuális testhõmérsékletével.
	 * 
	 * @return
	 */
	public int getTemperature() {
		System.out.println("Player\tvoid getTemperature()\tparam: -");
		return bodyTemperature;
	}

	/**
	 * A játékos testhõmérsékletét növeli a paraméterben megadott értékkel.
	 * 
	 * @param amount az a mennyiség, amivel a játékos élete növelve lesz
	 */
	public void heal(int amount) {
		System.out.println("Player\tvoid heal()\tparam: " + amount);
		bodyTemperature += amount;
	}

	/**
	 * A játékos testhõmérsékletét csökkenti a paraméterben megadott értékkel.
	 * 
	 * @param amount az a mennyiség, amivel a játékos élete csökken
	 * @return
	 */
	public void damage(int amount) {
		System.out.println("Player\tboolean damage()\tparam: " + amount);
		bodyTemperature -= amount;
	}

	/**
	 * Játékos munkakedvét (energy) a paraméterben megadott értékre állítja.
	 * 
	 * @param amount beállítja a játékos munkakedvét
	 */
	public void setEnergy(int amount) {
		System.out.println("Player\tvoid setEnergy()\tparam: " + amount);
		energy += amount;
	}

	/**
	 * A játékos adott körben történõ cselekvéseit beindító függvény. Visszatérési
	 * értéke megadja, hogy mennyi munkakedve van még a játékosnak.
	 * 
	 * @return a játékos maradék munkakedve
	 */
	@Override
	public int step() {
		System.out.println("Player\tint step()\tparam: -");
		return energy;
	}
}