package entity.item.optionalitem;

import entity.player.Player;

public class Rope implements OptionalItem{
	@Override
	public boolean use() {
		return true;
	}
  
	@Override
	public boolean wear() {
		// TODO Auto-generated method stub
		return false;
  }
	
	public boolean pull(Player p) {
		System.out.println("Rope\tboolean pull(Player)\tparam: " + p);
		return true;
	}
}
