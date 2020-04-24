package entity.player;

import java.util.ArrayList;

import entity.Entity;
import entity.item.Item;
import model.Drawable;
import tiles.Tile;

/**
 * Absztrakt �soszt�lya a j�t�kban szerepl� karaktereknek. Deklar�lja az
 * alapvet� m�k�d�shez sz�ks�ges attrib�tumokat �s met�dusokat, melyek a
 * lesz�rmazottakban ker�lnek kifejt�sre
 */
public abstract class Player extends Entity implements Drawable {

	private ArrayList<Item> inventory = new ArrayList<Item>();
	protected int energy = 4;
	protected int bodyTemperature = 4;
	protected boolean inWater = false;

	/**
	 * Ezzel a met�dussal ker�l �t a j�t�kos egyik j�gt�bl�r�l a m�sikra.
	 * 
	 * @param t az a Tile amelyikre a j�t�kos mozogni k�v�n
	 */
	public void move(Tile t) {
		t.receive(this);
		ot.remove(this);

	}

	/**
	 * Visszat�r az adott j�t�kos aktu�lis munkakedv�vel.
	 * 
	 * @return energy a j�t�kos munkakedve
	 */
	public int getEnergy() {
		return energy;
	}

	/**
	 * Ha bizonyos szint al� cs�kken a j�t�kos testh�m�rs�klete, akkor fagyhal�lt
	 * hal. Ez a met�dus kezdem�nyezi ezt a folyamatot.
	 */
	public void die() {
		game.getInstance();
		game.Defeat();
		game.EndGame();
	}

	/**
	 * Ha egy j�t�kos a v�zbe esik, �s nincs rajta Wetsuit, akkor sik�t, hogy a
	 * szomsz�dos j�gt�bl�n �ll� t�rsai meghallj�k
	 */
	public int scream() {
		return 1;
	}

	/**
	 * Ha egy j�t�kos olyan j�gt�bl�n tart�zkodik, melyen hallja egy m�sik j�t�kos
	 * sik�t�s�t, �s van a t�sk�j�ban (Inventory) egy k�t�l (Rope), akkor kimenti a
	 * j�t�kost.
	 * 
	 * @param p a kimentend� j�t�kos
	 * @return ki tudja-e menteni a j�t�kos
	 */
	public boolean savePlayer(Player p) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).pull(p)) {
				p.move(t);
			}
		}

	}

	/**
	 * Ha egy j�t�kos lyukba l�p, vagy instabil j�gt�bl�ra, ami �tfordul, akkor ez a
	 * f�ggv�ny jelzi, hogy v�zbe ker�lt.
	 * 
	 * @param inWater be�ll�tja, hogy v�zben van-e az adott j�t�kos
	 */
	public void setInWater(boolean value) {
		inWater = value;
		if (!getWetsuit()) {
			scream();
			Tile[] t = tile.getNeighbours();
			for (int i = 0; i < t.length(); i++) {
				t[i].alarmTile(this);
			}

		}
	}

	/**
	 * Ha van a j�t�kos birtok�ban Wetsuit (a f�ggv�ny visszat�r�si �rt�ke true),
	 * akkor azt felveszi �s ez�ltal megmenek�l v�zbees�s eset�n, k�s�bb ki�szhat.
	 * 
	 * @return rendelkezik-e Wetsuittal az adott j�t�kos
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
	 * Az �soszt�lyb�l sz�rmaz� met�dus, mely itt az Explorer k�pess�g�t val�s�tja
	 * meg: a j�t�kos poz�ci�j�t�l legfeljebb 3 t�vols�gra l�v� j�gt�bl�k k�z�l
	 * egyr�l meg�llap�tja a teherb�r�s�t.
	 * 
	 * @param chosenTile a felfedezend� j�gt�bla
	 * @return a felfedezett j�gt�bl�nak a teherb�r�sa
	 */
	abstract public int exploreTile(Tile chosenTile);

	/**
	 * Az �soszt�lyb�l sz�rmaz� met�dus, mely itt az Eszkim� k�pess�g�t val�s�tja
	 * meg: �p�t egy iglut arra a j�gt�bl�ra, ahol az Eszkim� �ll.
	 * 
	 * @param chosenTile az a j�gt�bla, melyre az Eskimo Igloo-t �p�t
	 * @return sikerrel j�rt-e az �p�t�s
	 */
	abstract public boolean buildIgloo(Tile chosenTile);

	/**
	 * Ha olyan j�gt�bl�ra l�p a j�t�kos , mely instabil vagy lyuk van rajta, akkor
	 * ez a f�ggv�ny ind�tja el az ilyenkor lezajl� esem�nyeket.
	 */
	public void pushToWater() {
		for (int i = 0; i < inventory.size(); i++) {
			inventory.get(i).wear();
		}
		setInWater(true);
	}

	/**
	 * Visszat�r a j�t�kos aktu�lis testh�m�rs�klet�vel.
	 * 
	 * @return
	 */
	public int getTemperature() {
		return bodyTemperature;
	}

	/**
	 * A j�t�kos testh�m�rs�klet�t n�veli a param�terben megadott �rt�kkel.
	 * 
	 * @param amount az a mennyis�g, amivel a j�t�kos �lete n�velve lesz
	 */
	public void heal(int amount) {
		bodyTemperature += amount;
	}

	/**
	 * A j�t�kos testh�m�rs�klet�t cs�kkenti a param�terben megadott �rt�kkel.
	 * 
	 * @param amount az a mennyis�g, amivel a j�t�kos �lete cs�kken
	 * @return
	 */
	public void damage(int amount) {
		bodyTemperature -= amount;
	}

	/**
	 * J�t�kos munkakedv�t (energy) a param�terben megadott �rt�kre �ll�tja.
	 * 
	 * @param amount be�ll�tja a j�t�kos munkakedv�t
	 */
	public void setEnergy(int amount) {
		energy = amount;
	}

	/**
	 * A j�t�kos adott k�rben t�rt�n� cselekv�seit beind�t� f�ggv�ny. Visszat�r�si
	 * �rt�ke megadja, hogy mennyi munkakedve van m�g a j�t�kosnak.
	 * 
	 * @return a j�t�kos marad�k munkakedve
	 */
	@Override
	public int step() {
		return energy;
	}
}