package model.entity.item.optionalitem;

import controller.GameRunner;
import view.entity.WetsuitView;

/**
 * A Wetsuit osztaly reprezentalja a jatekos egy lehetseges targyat, mellyel
 * kepes tulelni vizbeeses utan, serules nelkul.
 */
public class Wetsuit extends OptionalItem {

	public Wetsuit(String id) {
		super(id);
		view = new WetsuitView(GameRunner.baseGameController);
	}

	/**
	 * A Wetsuit hasznalata automatikus, ha a jatekosnak van Wetsuitja és vizbe
	 * esik, automatikusan hasznalja.
	 * 
	 * @return Visszateresi erteke a logikai Igaz (true), ezzel jelezve hogy a
	 *         jatekosnak van ilyen Item-e es szukseg eseten sikeresen hasznalta.
	 */
	@Override
	public boolean wear() {
		return true;
	}

}
