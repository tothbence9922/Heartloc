package model.entity.item.optionalitem;

import controller.GameRunner;
import view.entity.FoodView;

/**
 * A jatekosok szamara lehetoseget nyujt testhomersekletuk novelesere, ha esznek
 * valamit. Ez a valami az étel - Food, melyet ez az osztály reprezentál.
 */
public class Food extends OptionalItem {

	public Food(String id) {
		super(id);
		view = new FoodView(GameRunner.baseGameController);
	}

	/**
	 * A jatekos, ha rendelkezik Food-al, hasznalhatja azt, hogy novelje
	 * testhomersekletet (bodyTemperature). Az etel (Food) eltunik a jatekos
	 * taskajabol hasznalat után.
	 * 
	 * @return A visszateresi erteke a logikai igaz (true), ezzel jelzi hogy
	 *         sikeresen használta a Food Itemet a jatekos.
	 */
	@Override
	public boolean eat() {
		return true;
	}

}
