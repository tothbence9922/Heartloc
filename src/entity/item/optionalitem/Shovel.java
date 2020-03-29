package entity.item.optionalitem;

import entity.player.Player;

public class Shovel implements OptionalItem{
	@Override
	public boolean use() {
			System.out.println("Shovel is usable");
		return false;
	}
	public boolean wear() {return false;}
	public boolean pull(Player p) {return false;}

}
