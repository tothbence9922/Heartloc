package tiles;

import java.util.ArrayList;
import java.util.Random;

import entity.Entity;
import entity.item.Item;
import entity.player.Player;
import model.Drawable;

public abstract class Tile implements Drawable {
	
	protected ArrayList<Player> players;

	protected int snow = 0; 
	
	protected Item item = null;
	
	protected boolean hasHole = false;	// Felesleges szerintem k�l�n oszt�lyt sz�nni neki TB
	
	protected int numOfTargetItems;
	/**
	 * Megadja, hogy tal�lhat�-e a lyuk a Tile-on.
	 * 
	 * @return Ha van Hole akkor true, ha nincs akkor false.
	 */
	public boolean getHasHole() {
		System.out.println("Tile\tboolean getHasHole()\tparam: -");
		return this.hasHole;
	}
	/**
	 * Megkaphatjuk a TargetItem-ek sz�m�t.
	 * @return Visszat�r a TargetItem-ek sz�m�val.
	 */
	public int getNumOfTargetItems() {
		System.out.println("Tile\tint getNumOfTargetItems()\tparam: -");
		return this.numOfTargetItems;
	}

	public void storm(Random r) {
		snow += r.nextInt(3);
		if (snow > 5) snow = 5;
		for (Player p : players) {
			p.hit();
		}
	}
	/**
	 * a param�terben kapott entit�st a j�gt�bl�ra mozgatja.
	 * @param e - Egy Entity v�ltoz� amit hozz�adunka Tile-hoz.
	 * @return - Az elhelyez�s sikeress�ge true, ellenkez�leg false.
	 */
	public boolean receive(Entity e) {
		System.out.println("Tile\tboolean receive()\tparam: Entity");
		return false;
	}
	/**
	 *  a param�terben kapott entit�st a j�gt�bl�r�l elt�vol�tja.
	 * @param e - Az Entity, amit el szeretn�nk t�vol�tani a mez�r�l.
	 */
	public void remove(Entity e) {
		System.out.println("Tile\tvoid remove()\tparam: Entity");
	}
	/**
	 * A rak�ta �sszeszerel�s�t v�gzi el a f�ggv�ny.
	 * 
	 * @return  true �rt�kkel t�r vissza, ha az adott j�gt�bl�n
		�sszeszerelhet� a jelz�rak�ta, egy�bk�nt false.
	 */
	public boolean assembleRocket() {
		System.out.println("Tile\tbooelan assembleRocket()\tparam: -");
		return false;
	}
}
