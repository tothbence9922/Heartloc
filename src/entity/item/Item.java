package entity.item;

import entity.player.Player;

public abstract class Item {
	public boolean isVisible = false;
	
	public abstract boolean use();

	public abstract boolean wear();
	public abstract boolean pull(Player p);

	public abstract boolean useTargetItem();
	
	public void setIsVisible(boolean b) {
		System.out.println("Food\tvoid setIsVisible()\t param: - ");
	}
}
