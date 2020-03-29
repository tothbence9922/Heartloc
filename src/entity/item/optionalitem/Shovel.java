package entity.item.optionalitem;

import entity.player.Player;

public class Shovel extends OptionalItem{
	@Override
	public boolean use() {
			System.out.println("Shovel is usable");
		return false;
	}

	public boolean dig() {
		System.out.println("Shovel\tboolean dig()\tparam: -");
		return true;
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
