package entity.item;

import entity.player.Player;

public abstract class Item {
	public boolean isVisible = false;

	public void setIsVisible(boolean b) {
		
	}
	
	public boolean pull(Player p) {
		return false;
	}

	public void drop() {
		
	}
	
	public void pickup() {
		
	}
	
	public boolean assembleRocket() {
		return false;
	}
	
	public boolean eat() {
		return false;
	}
	
	public boolean wear() {
		return false;
	}
	
	public boolean dig() {
		return false;
	}

	public boolean useTargetItem() {
		return false;
	}
}
