package entity.item.optionalitem;

import entity.player.Player;

public class Rope implements OptionalItem{
	@Override
	public boolean use() {
		return true;
	}
	public boolean wear() {return false;}
	
	public boolean pull(Player p) {
		System.out.println("Rope\tboolean pull(Player)\tparam: Player");
		return true;
	}
}
