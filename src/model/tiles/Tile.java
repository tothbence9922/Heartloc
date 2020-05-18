package model.tiles;

import java.util.ArrayList;
import java.util.Random;

import model.entity.Building;
import model.entity.Entity;
import model.entity.Igloo;
import model.entity.Tent;
import model.entity.item.Item;
import model.entity.player.Player;
import model.Drawable;
import model.Game;
import model.entity.PolarBear;
import model.entity.Snow;
import view.tiles.TileView;

/**
 * A jatek egyik alapegyseget kepezo objektum, ezeken helyezkednek el a
 * kulonfele entitasok: jatekosok, targyak, igluk, lyukak es ho.
 */
public abstract class Tile implements Drawable {

	public TileView view;

	protected String id;
	protected int load = 0;

	protected int amountOfSnow;
	protected int numOfTargetItems;
	protected int capacity;

	protected boolean hasHole = false;
	protected boolean hasIgloo = false;
	protected boolean hasTent = false;
	protected boolean hasPolarBear = false;
	protected boolean showCapacity = false;

	protected ArrayList<Entity> entities = new ArrayList<Entity>();
	protected ArrayList<Player> players = new ArrayList<Player>();
	protected ArrayList<PolarBear> bears = new ArrayList<PolarBear>();
	protected ArrayList<Tile> neighbours = new ArrayList<Tile>();
	protected ArrayList<Item> items = new ArrayList<Item>();
	protected ArrayList<Building> buildings = new ArrayList<Building>();
	protected ArrayList<Snow> snows = new ArrayList<Snow>();

	protected Igloo igloo;

	/**
	 * A Tile osztaly alapertelmezett konstruktora, mely egy ures ArrayList-tel
	 * inicializalja a players attributumot.
	 */
	public Tile(String id, int load) {
		this.id = id;
		this.load = load;
	}

	private String getEntitesString() {
		String playerIds = "[";
		if (entities.isEmpty())
			return "empty";
		else {
			int i;
			for (i = 0; i < entities.size() - 1; i++) {
				playerIds = playerIds + (entities.get(i).getId()) + ", ";
			}
			playerIds = playerIds + (entities.get(i).getId());
		}
		return playerIds + "]";
	}

	private String getItemsString() {
		String itemIds = "[";
		if (items.isEmpty())
			return "empty";
		else {
			int i;
			for (i = 0; i < items.size() - 1; i++)
				itemIds = itemIds + (items.get(i).getId()) + ", ";
			itemIds = itemIds + (items.get(i).getId());
		}
		return itemIds + "]";
	}

	public String toJSON() {
		String idJSON = "\"" + id + "\"";
		String snowJSON = String.valueOf(amountOfSnow);
		String capacityJSON = String.valueOf(capacity);
		String holeJSON = (hasHole) ? "1" : "0";
		String neighboursJSON = "";
		int i;
		if (neighbours.size() > 0) {
			for (i = 0; i < neighbours.size() - 1; i++) {
				neighboursJSON = neighboursJSON + "\t\t\t\t\"" + neighbours.get(i).id + "\"" + ",\n";
			}
			neighboursJSON = neighboursJSON + "\t\t\t\t\"" + neighbours.get(i).id + "\"";
		}

		String entityJSON = "";
		if (entities.size() > 0) {
			for (i = 0; i < entities.size() - 1; i++) {
				entityJSON = entityJSON + "\t\t\t\t\"" + entities.get(i).getId() + "\"" + ",\n";
			}
			entityJSON = entityJSON + "\t\t\t\t\"" + entities.get(i).getId() + "\"";
		}
		String itemJSON = "";

		if (items.size() > 0) {
			for (i = 0; i < items.size() - 1; i++) {
				itemJSON = itemJSON + "\t\t\t\t\"" + items.get(i).getId() + "\"" + ",\n";
			}
			itemJSON = itemJSON + "\t\t\t\t\"" + items.get(i).getId() + "\"";
		}
		return "\t\t\t\"id\":" + idJSON + ",\n\t\t\t\"snow\":" + snowJSON + ",\n\t\t\t\"capacity\":" + capacityJSON
				+ ",\n\t\t\t\"hole\":" + holeJSON + ",\n\t\t\t\"neighbours\": [\n" + neighboursJSON
				+ "\n\t\t\t],\n\t\t\t\"entities\": [\n" + entityJSON + "\n\t\t\t],\n\t\t\t\"items\": [\n" + itemJSON
				+ "\n\t\t\t]";
	}

	@Override
	public String toString() {
		String building = "empty";
		if (hasIgloo)
			building = "Igloo";
		else if (hasTent)
			building = "Tent";
		return (id + " - " + ((capacity > 0) ? String.valueOf(capacity) : "(" + String.valueOf(capacity) + ")") + " - "
				+ String.valueOf(amountOfSnow) + " - " + String.valueOf(hasHole) + " - " + getEntitesString() + " - "
				+ building + " - " + getItemsString() + "\n");
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
				items.get(i).setVisible(true);
			}

			ArrayList<Item> ret = new ArrayList<Item>();
			for (int i = 0; i < items.size(); i++) {
				ret.add(items.get(i));
				Game.view.remove(items.get(i).view);
			}
			items.clear();
			return ret;
		}

		return null;
	}

	/**
	 * Visszatér az adott instabil jégtábla aktuális terhével.
	 * 
	 * @return int
	 */
	public int getLoad() {
		return this.load;
	}

	/**
	 * 
	 * Bealitja a jegtabla aktualis terheleset
	 * 
	 * @param load
	 */
	public void setLoad(int load) {
		this.load = load;
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
		this.load++;
		entities.add(e);
		return true;
	}

	/**
	 * A parameterben kapott entitast a jegtablara mozgatja
	 * 
	 * @param e
	 * @return boolean
	 */
	public boolean receive(PolarBear e) {
		this.load++;
		if (!bears.isEmpty() && !players.isEmpty())
			players.get(0).die("A bear ate a player...");
		bears.add(e);
		return true;
	}

	public boolean receive(Player p) {
		this.load++;
		if (!bears.isEmpty() && !players.isEmpty())
			players.get(0).die("A bear ate a player...");
		players.add(p);
		return true;
	}

	/**
	 * A parameterben kapott entitast a jegtablarol eltavolitja.
	 * 
	 * @param e - Az Entity, amit el szeretnenk eltavolitani a mezorol.
	 */
	public void remove(Entity e) {
		entities.remove(e);
	}

	public void remove(PolarBear pb) {
		entities.remove(pb);
		bears.remove(pb);
		this.setLoad(getLoad() - 1);

	}

	/**
	 * A parameterben kapott jatekost a jegtablarol eltavolitja.
	 * 
	 * @param p
	 */
	public void remove(Player p) {
		players.remove(p);
		entities.remove(p);
		this.setLoad(getLoad() - 1);

	}

	/**
	 * Visszater azzal, hogy az adott jegtablan van-e lyuk.
	 * 
	 * @return boolean
	 */
	public boolean getHasHole() {
		return this.hasHole;
	}

	/**
	 * Jatekos sikitasa eseten hivodik meg, parameterkent a vizbe esett jatekossal,
	 * akit igy egy megfelelo tavolsagra levo, masik jegtablan tartozkodo jatek – ha
	 * van kotele – ki tud menteni.
	 * 
	 * @param p
	 * @return boolean
	 */
	public boolean alarmTile(Player p) {
		for (Player player : players) {
			if (!(p.equals(player)) && player.savePlayer(p)) {
				p.move(player.getCurrentTile());
				return true;
			}
		}
		return false;
	}

	/**
	 * Parameterkent megadott mennyisegu havat rak az adott jegtablara.
	 * 
	 * @param amount
	 */
	public void addSnow(int amount) {
		amountOfSnow += amount;
		if(amountOfSnow > 5) amountOfSnow = 5;
		for (int i = 0; i < amount; i++) {
			snows.clear();
			snows.add(new Snow("Sno" + snows.size()));
		}
		Game.view.updatePanel();
	}

	/**
	 * Parameterkent megadott mennyisegu havat tavolit el az adott jegtablarol.
	 * 
	 * @param amount
	 */
	public void removeSnow(int amount) {
		if (amountOfSnow > 0) amountOfSnow -= amount;

		for (int i = 0; i < amount; i++) {
			if (snows.size() != 0) {
				snows.remove(0);
			}
		}
		if (amountOfSnow < 0)
			amountOfSnow = 0;
	}

	/**
	 * Hovihar kezdetet jelenti
	 */
	public void storm(Random r) {
		int newSnowAmount = r.nextInt(3);
		amountOfSnow += newSnowAmount;
		for (int i = 0; i < newSnowAmount; i++) {
			snows.add(new Snow("Sno" + snows.size()));
		}

		if (amountOfSnow > 5) {
			amountOfSnow = 5;
			for (int i = snows.size() - 1; i > 5; i--) {
				snows.remove(i);
			}
		}
		if (this.hasIgloo == false || this.hasTent == false) {
			for (Player p : players) {
				p.damage(1);
			}
		}
	}

	public void addIgloo(Igloo igloo) {
		load++;
		hasIgloo = true;
		buildings.add(igloo);
		igloo.view.setBounds(this.view.getBounds());

		Game.view.addView(igloo.view);
		igloo.view.setVisible(true);
		Game.view.updatePanel();
	}

	public void addHole() {
		this.hasHole = true;
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

	public ArrayList<Building> getBuildings() {
		return this.buildings;
	}

	public boolean getDefense() {
		if (this.hasIgloo || this.hasTent) {
			return true;
		} else {
			return false;
		}
	}

	public void addNeighbour(Tile tile) {
		neighbours.add(tile);
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

	public ArrayList<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		this.items.add(item);
		Game.addItem(item);
	}

	public void setItems(ArrayList<Item> i) {
		this.items.clear();
		this.items.addAll(i);

	}

	public boolean hasIgloo() {
		return hasIgloo;
	}

	public void setHasIgloo(boolean hasIgloo) {
		this.hasIgloo = hasIgloo;
	}

	public boolean hasTent() {
		return hasTent;
	}

	public void setHasTent(boolean hasTent) {
		this.hasTent = hasTent;
	}

	public boolean hasPolarBear() {
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
		this.snows.clear();
		for (int i = 0; i < amountOfSnow; i++) {
			snows.add(new Snow("Sno" + snows.size()));
		}
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

	public boolean getShowCapacity() {
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

	public void addTent(Tent tent) {
		hasTent = true;
		buildings.add(tent);
		Game.view.addView(tent.view);
		tent.view.setBounds(this.view.getBounds());
		tent.view.setVisible(true);
		Game.view.updatePanel();
	}

	public ArrayList<PolarBear> getBears() {
		return bears;
	}

	public void setBears(ArrayList<PolarBear> bears) {
		this.bears = bears;
	}

	public ArrayList<Snow> getSnows() {
		return snows;
	}

	public void setSnows(ArrayList<Snow> snows) {
		this.snows = snows;
		this.amountOfSnow = snows.size();
	}

}
