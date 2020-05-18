package model.entity.item.optionalitem;

import controller.GameRunner;
import model.entity.player.Player;
import view.entity.RopeView;

/**
 * Az egyik opcionalis targyat, a kotelet (Rope) megvalosito és reprezentalo
 * osztaly. Segitsegevel a jatekosok megmenthetik bajbajuttott tarsaikat.
 */
public class Rope extends OptionalItem {

	public Rope(String id) {
		super(id);
		view = new RopeView(GameRunner.baseGameController);

	}

	/**
	 * A jatekos, ha rendelkezik Rope-pal, hasznalhatja azt, hogy megmentse
	 * bajbajutott tarsat. Miutan a bajbajuttott sikit (Player::scream()), a
	 * szomszedos jegtablan (Tile) allo jatekos, ha rendelkezik kotellel,
	 * automatikusan kimenti a masik jatekost aki ennek hatasara arra a jegtablara
	 * (Tile) kerul, melyen a megmentoje all.
	 * 
	 * @param Player p - A parameterul kapott jatekos a kimentendo jatekos.
	 * @return true A visszateresi erteke a logikai Igaz (true), ezzel jelezve hogy
	 *         jatekos sikeresen hasznalta a kotelet (Rope).
	 */
	@Override
	public boolean pull(Player p) {
		return true;
	}
}
