package model.entity.item.targetitem;

import model.entity.item.Item;
import view.entity.TargetItemView;

public abstract class TargetItem extends Item {

	public TargetItemView view;
	
	public TargetItem(String id) {
		super(id);
	}	
}
