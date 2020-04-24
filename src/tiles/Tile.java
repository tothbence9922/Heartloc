package tiles;

import java.util.ArrayList;
import java.util.Random;

import entity.Entity;
import entity.Igloo;
import entity.item.Item;
import entity.player.Player;
import model.Drawable;

/**
 * A j�t�k egyik alapegys�g�t k�pez� objektum, ezeken helyezkednek el a
 * k�l�nf�le entit�sok: j�t�kosok, t�rgyak, igluk, lyukak �s h�.
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
	 * A Tile oszt�ly alap�rtelmezett konstruktora, mely egy �res ArrayList<Player>
	 * -rel inicializ�lja a players attrib�tumot.
	 */
	public Tile() {
		this.players = new ArrayList<Player>();
	}

	/**
	 * A met�dus haszn�lat�val �shat� ki t�rgy, illetve takar�that� el h�.
	 * Param�terk�nt �tadhat�, hogy mennyit �sson egy munka felhaszn�l�s�val. Ha a
	 * j�t�kos rendelkezik lap�ttal, akkor 2 egys�gnyit tud �sni egy munkav�gz�ssel,
	 * egy�bk�nt 1 egys�gnyit. Ha egy t�rgy l�that�, akkor �s�s ut�n azzal a
	 * t�rggyal t�r vissza, egy�bk�nt null �rt�kkel.
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
	 * Az adott j�gt�bl�n el�rhet� TargetItemek sz�m�val t�r vissza. Ennek a
	 * met�dusnak a felhaszn�l�s�val der�thet� ki, hogy a j�t�k v�g�t jelent�
	 * jelz�rak�ta �sszeszerel�se �s els�t�se megkezdhet�-e, azaz egy j�gt�bl�n
	 * van-e mind a h�rom.
	 * 
	 * @return int
	 */
	public int getNumOfTargetItems() {
		System.out.println("Tile\tint getNumOfTargetItems()\tparam: -");
		return this.numOfTargetItems;
	}

	/**
	 * J�gt�bla l�trehoz�sa ut�n annak inicializ�l�st v�gz� met�dus, ebben d�l el,
	 * hogy lesz-e lyuk vagy t�rgy az adott j�gt�bl�n.
	 * 
	 * @return boolean
	 */
	public boolean initTile() {
		System.out.println("Tile\tboolean initTile()\tparam: -");
		return true;
	}

	/**
	 * A param�terben kapott entit�st a j�gt�bl�ra mozgatja
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
	 * A param�terben kapott entit�st a j�gt�bl�r�l elt�vol�tja.
	 * 
	 * @param e - Az Entity, amit el szeretn�nk elt�vol�tani a mez�r�l.
	 */
	public void remove(Entity e) {
		System.out.println("Tile\tvoid remove(Entity)\tparam: " + e);
		players.remove((Player) e);
	}

	/**
	 * A param�terben kapott entit�st a j�gt�bl�r�l elt�volitja.
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
	 * Visszat�r azzal, hogy az adott j�gt�bl�n van-e lyuk.
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
	 * True �rt�kkel t�r vissza, ha az adott j�gt�bl�n �sszeszerelhet� a
	 * jelz�rak�ta, egy�bk�nt false.
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
	 * J�t�kos sik�t�sa eset�n h�v�dik meg, param�terk�nt a v�zbe esett j�t�kossal,
	 * akit �gy egy megfelel� t�vols�gra l�v�, m�sik j�gt�bl�n tart�zkod� j�t�k � ha
	 * van k�tele � ki tud menteni.
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
	 * Param�terk�nt megadott mennyis�g� havat rak az adott j�gt�bl�ra.
	 * 
	 * @param amount
	 */
	public void addSnow(int amount) {
		amountOfSnow += amount;
		System.out.println("Tile\tvoid addSnow(int)\tparam: " + amount);
	}

	/**
	 * Param�terk�nt megadott mennyis�g� havat t�vol�t el az adott j�gt�bl�r�l.
	 * 
	 * @param amount
	 */
	public void removeSnow(int amount) {
		amountOfSnow -= amount;
		System.out.println("Tile\tvoid removeSnow(int)\tparam: " + amount);
	}

	/**
	 * L�that�v� teszi az adott j�gt�bl�n, hogy mekkora a kapacit�sa (az Explorer
	 * k�pess�g�nek haszn�lata sor�n).
	 * 
	 * @param b
	 */
	public void setCapacityVisible(boolean b) {
		System.out.println("Tile\tvoid setCapacityVisible(boolean)\tparam: -" + b);
		this.showCapacity = b;
	}

	/**
	 * Visszat�r egy j�gt�bl�nak az aktu�lis j�gt�bl�t�l val� t�vols�g�val.
	 * 
	 * @return int
	 */
	public int getDistance() {
		System.out.println("Tile\tint getDistance()\tparam: -");
		return 0;
	}

	/**
	 * H�vihar kezdet�t jelenti
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
	 * Visszat�r az adott j�gt�bl�n tart�zkod� j�t�kosokkal
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
	 * Visszat�r az adott j�gt�bl�n l�v� igluval, ha nincs null �rt�kkel.
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
