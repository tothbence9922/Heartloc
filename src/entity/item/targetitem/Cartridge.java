package entity.item.targetitem;

import entity.player.Player;

public class Cartridge extends TargetItem {
	@Override
	public boolean use() {
			System.out.println("Patron is not yet usable");
		return false;
	}

	@Override
	public boolean wear() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean pull(Player p) {return false;}

	@Override
	public boolean useTargetItem() {
		// TODO Auto-generated method stub
		return false;
	}
}
