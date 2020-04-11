package tiles;

import java.util.ArrayList;
import java.util.Random;

import entity.Entity;
import entity.Igloo;
import entity.item.Item;
import entity.player.Player;
import model.Drawable;
/**
 * A játék egyik alapegységét képezõ objektum, ezeken helyezkednek el a különféle entitások: játékosok, tárgyak, igluk, lyukak és hó.
 * @author tothbence9922 & komendamate
 *
 */
public abstract class Tile implements Drawable {
	
	protected ArrayList<Player> players;
	protected Item item = null;
	protected ArrayList<Tile> neighbours;
	
	protected boolean hasHole = false;
	protected boolean hasItem = false;
	protected int amountOfSnow;
	protected int numOfTargetItems;
	protected int capacity;
	
	protected boolean showCapacity;
	/**
	 *A metódus használatával ásható ki tárgy, illetve
	 *takarítható el hó. Paraméterként átadható, hogy mennyit ásson egy munka
	 *felhasználásával. Ha a játékos rendelkezik lapáttal, akkor 2 egységnyit tud
	 *ásni egy munkavégzéssel, egyébként 1 egységnyit. Ha egy tárgy látható,
	 *akkor ásás után azzal a tárggyal tér vissza, egyébként null értékkel.
	 *@param amount
	 *@return Item
	 */
	public Item dig(int amount) {
		return null;
	}
	/**
	 * A Tile osztály alapértelmezett konstruktora, mely egy üres ArrayList<Player> -rel inicializálja a players attribútumot.
	 */
	public Tile() {
		this.players = new ArrayList<Player>();
		this.neighbours = new ArrayList<Tile>();
	}
	
	/**
	 *Az adott jégtáblán elérhetõ TargetItemek
	 *számával tér vissza. Ennek a metódusnak a felhasználásával deríthetõ ki,
	 *hogy a játék végét jelentõ jelzõrakéta összeszerelése és elsütése
	 *megkezdhetõ-e, azaz egy jégtáblán van-e mind a három.
	 *@return int
	 */
	public int getNumOfTargetItems() {
		System.out.println("Tile\tint getNumOfTargetItems()\tparam: -");
		return this.numOfTargetItems;
	}
	/**
	 *Jégtábla létrehozása után annak inicializálást végzõ
	 *metódus, ebben dõl el, hogy lesz-e lyuk vagy tárgy az adott jégtáblán.
	 *@return boolean
	 */
	public boolean initTile() {
		System.out.println("Tile\tboolean initTile()\tparam: -");
		return true;
	}
	
	/**
	 *A paraméterben kapott entitást a jégtáblára mozgatja
	 *@param e
	 *@return boolean
	 */
	public boolean receive(Entity e) {
		System.out.println("Tile\tboolean receive(Entity)\tparam: " + e);
		return true;
	}
	/**
	 *A paraméterben kapott entitást a jégtábláról eltávolitja.
	 *@param e
	 *@return boolean
	 */
	public boolean getHasHole() {
		System.out.println("Tile\tboolean getHasHole()\tparam: -");
		return true;
	}
	
	/**
	 *Visszatér azzal, hogy az adott jégtáblán van-e lyuk.
	 *@return boolean
	 */
	public boolean assembleRocket() {
		System.out.println("Tile\tbooelan assembleRocket()\tparam: -");
		return false;
	}
	/**
	 *True értékkel tér vissza, ha az adott jégtáblán
	 *összeszerelhetõ a jelzõrakéta, egyébként false.
	 *@return boolean
	 */
	public Tile[] getNeighbours() {
		System.out.println("Tile\tTile[] getNeighbours()\tparam: -");
		
		Tile t1 = new StableTile();
		Tile t2 = new StableTile();
		Tile[] tiles = {t1,t2};
		return tiles;
	}
	/**
	 *Játékos sikítása esetén hívódik meg,
	 *paraméterként a vízbe esett játékossal, akit így egy megfelelõ távolságra lévõ,
	 *másik jégtáblán tartózkodó játék – ha van kötele – ki tud menteni.
	 *@param p
	 *@return boolean
	 */
	public boolean alarmTile(Player p) {
		System.out.println("Tile\tboolean alarmTile(Entity)\tparam: " + p);
		return false;
	}
	/**
	 *Paraméterként megadott mennyiségû havat rak
	 *az adott jégtáblára.
	 *@param amount
	 */
	public void addSnow(int amount) {
		amountOfSnow += amount;
		System.out.println("Tile\tvoid addSnow(int)\tparam: " + amount);
	}
	/**
	 *Paraméterként megadott mennyiségû havat
	 *távolít el az adott jégtábláról.
	 *@param amount
	 */
	public void removeSnow(int amount) {
		amountOfSnow -= amount;
		System.out.println("Tile\tvoid removeSnow(int)\tparam: " + amount);
	}
	/**
	 *Láthatóvá teszi az adott jégtáblán, hogy
	 *mekkora a kapacitása (az Explorer képességének használata során).
	 *@param b
	 */
	public void setCapacityVisible(boolean b) {
		System.out.println("Tile\tvoid setCapacityVisible(boolean)\tparam: -" + b);
		this.showCapacity = b;
	}
	/**
	 *Visszatér egy jégtáblának az aktuális jégtáblától való
	 *távolságával.
	 *@return int
	 */
	public int getDistance() {
		System.out.println("Tile\tint getDistance()\tparam: -");
		return 2;
	}
	/**
	 *Hóvihar kezdetét jelenti
	 */
	public void storm(Random r) {
		System.out.println("Tile\tvoid storm(Random)\tparam: " + r);
		amountOfSnow += r.nextInt(3);
		if (amountOfSnow > 5) amountOfSnow = 5;
		for (Player p : players) {
			p.damage(1);
		}
	}
	/**
	 *Visszatér az adott jégtáblán tartózkodó játékosokkal
	 *@return Player[]
	 */
	public Player[] getPlayers() {
		System.out.println("Tile\tPlayer[] getPlayers()\tparam: -");
		return null;
	}
	/**
	 *Visszatér az adott jégtáblán lévõ igluval, ha nincs null
	 *értékkel.
	 *@return Igloo
	 */
	public Igloo getIgloo() {
		System.out.println("Tile\tIgloo getIgloo()\tparam: -");
		return null;
	}
	
	/**
	 *A paraméterben kapott entitást a jégtábláról eltávolítja.
	 * @param e - Az Entity, amit el szeretnénk eltávolítani a mezõrõl.
	 */
	public void remove(Entity e) {
		System.out.println("Tile\tvoid remove(Entity)\tparam: " + e);
	}

	
	public void addNeighbour(Tile t) {
		this.neighbours.add(t);
	}
	
	
	
	
	
	
	
}
