package entity.item.optionalitem;

import entity.player.Player;

public class Food implements OptionalItem {
	@Override
	public boolean use() {
			System.out.println("Food :3");
		return false;
	}

	public void pickup() {
		System.out.println("Food\tvoid pickup()\tparam: -");
	}
	public boolean wear() {return false;}
	public boolean pull(Player p) {return false;}
}
