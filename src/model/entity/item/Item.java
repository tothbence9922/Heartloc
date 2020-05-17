package model.entity.item;

import controller.GameRunner;
import model.entity.Entity;
import model.entity.player.Player;
import view.entity.ItemView;

public abstract class Item extends Entity {

	protected boolean visible = false;

	public Item(String id) {
		super(id);
		view = new ItemView(GameRunner.baseGameController);
	}

	public void setVisible(boolean b) {
		this.visible = b;
		view.setVisible(b);
	}

	/**
	 * A kotel targy hasznalatat vegzo metodus.
	 * 
	 * @param p - Melyik jatekost akarjuk kihuzni.
	 * @return - Ha az Item (-bol szarmazo objektum) kotel, akkor visszateresi
	 *         erteke True/Igaz, ellenkezo esetben False/Hamis, mivel huzni csak a
	 *         kotel targgyal tudunk a programban.
	 */
	public boolean pull(Player p) {
		return false;
	}

	/**
	 * A jatekos, ha rendelkezik Item-mel, annak hasznalataval kulonbozo modokon
	 * juthat elonyhoz - vagy nyerheti meg a jatekot
	 * 
	 * @return Az eves sikersseget true, ellenkezojet false jelzi.
	 */
	public boolean eat() {
		return false;
	}

	/**
	 * A jatekos, ha rendelkezik Item-mel, annak hasznalataval kulonbozo modokon
	 * juthat elonyhoz - vagy nyerheti meg a jatekot.
	 * 
	 * @return Ha van mit felvenni akkor true, elenezoleg false.
	 */
	public boolean wear() {
		return false;
	}

	/**
	 * A jatekos, ha rendelkezik Item-mel, annak hasznalataval kulonbozo modokon
	 * juthat elonyhoz - vagy nyerheti meg a jatekot.
	 * 
	 * @return Ha az asas sikeres akkor true, elenezoleg false.
	 */
	public boolean dig() {
		return false;
	}

	/**
	 * A jatekos, ha rendelkezik Item-mel, annak hasznalataval kulonbozo modokon
	 * juthat elonyhoz - vagy nyerheti meg a jatekot.
	 * 
	 * @return Ha az asas sikeres akkor true, elenezoleg false.
	 */
	public boolean digWithFragileShovel() {
		return false;
	}

	/**
	 * A jatekos, ha rendelkezik Item-mel, annak hasznalataval kulonbozo modokon
	 * juthat elonyhoz - vagy nyerheti meg a jatekot.
	 * 
	 * @return Az eszkoz sikeres hasznalatanal true ellenkezoleg false.
	 */
	public boolean useTargetItem() {
		return false;
	}

	public boolean buildTent() {
		return false;
	}

	/**
	 * A step() metodus oly modon megvalositva, hogy jelezze, ez az objektum nem
	 * jatekost reprezental.
	 */
	@Override
	public int step(String msg) {
		return -1;
	}

	public int getNumOfUses() {
		return -1;
	}

}
