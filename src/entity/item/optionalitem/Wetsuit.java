package entity.item.optionalitem;

import entity.player.Player;

public class Wetsuit implements OptionalItem{

	@Override
	public boolean use() {
			System.out.println("Wetsuit is not usable");
		return false;
	}

  @Override
	public boolean wear() {
		System.out.println("Wetsuit\t boolean wear()\tparam: -");
		return true;
	}
	public boolean pull(Player p) {return false;}
}
