package entity.item.targetitem;

import entity.player.Player;

public class Beacon implements TargetItem {
	@Override
	public boolean use() {
			System.out.println("Beacon is not yet usable!");
		return false;
	}

	@Override
	public boolean wear() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean pull(Player p) {return false;}
}
