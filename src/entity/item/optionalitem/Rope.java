package entity.item.optionalitem;

import entity.player.Player;

public class Rope extends OptionalItem{
  
	@Override	
	public boolean pull(Player p) {
		System.out.println("Rope\tboolean pull(Player)\tparam: " + p);
		return true;
	}
	
}
