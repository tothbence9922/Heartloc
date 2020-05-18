package model.entity.item.targetitem;

import controller.GameRunner;
import model.entity.item.Item;
import view.entity.ItemView;
/**
 * 
 * A jatek soran talalhato (Item-ek) egyik resze.
 * Ezen targyak megszerzese,osszeszerelese,majd haszalata
 * szukseges a jatek megnyeresehez.
 * Az ilyen TargetItem-ek kozos, absztrakt ososztalya a TargetItem osztaly.
 * 
 */
public abstract class TargetItem extends Item {
	
	public TargetItem(String id) {
		super(id);
		view = new ItemView(GameRunner.baseGameController);
	}	
}
