package entity.item.targetitem;

import entity.player.Player;

public class Cartridge implements TargetItem {
	@Override
	public boolean use() {
			System.out.println("Patron is not yet usable");
		return false;
	}
	public boolean wear() {return false;}
	public boolean pull(Player p) {return false;}

}
