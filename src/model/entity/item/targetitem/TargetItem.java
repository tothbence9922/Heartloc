package model.entity.item.targetitem;

import controller.GameRunner;
import model.entity.item.Item;
import view.entity.ItemView;

public abstract class TargetItem extends Item {
	
	public TargetItem(String id) {
		super(id);
		view = new ItemView(GameRunner.baseGameController);
	}	
}
