package entity.item;

import entity.player.Player;

public interface Item {
	public boolean use();
	public boolean wear();
	public boolean pull(Player p);
}
