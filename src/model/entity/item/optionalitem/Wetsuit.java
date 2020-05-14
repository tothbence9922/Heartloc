package model.entity.item.optionalitem;

import controller.GameRunner;
import view.entity.WetsuitView;

/**
 * A Wetsuit osztály reprezentálja a játékos egy lehetséges tárgyát, mellyel
 * képes túlélni vízbeeés után, sérülés nélkül.
 */
public class Wetsuit extends OptionalItem {
	
	
	public Wetsuit(String id) {
		super(id);
		view = new WetsuitView(GameRunner.baseGameController);
	}

	/**
	 * A Wetsuit használata automatikus, ha a játékosnak van Wetsuitja és vízbe
	 * esik, automatikusan használja.
	 * 
	 * @return Visszatérési értéke a logikai Igaz (true), ezzel jelezve hogy a
	 *         játékosnak van ilyen Item-e és szükség esetén sikeresen használta.
	 */
	@Override
	public boolean wear() {
		return true;
	}
	
}
