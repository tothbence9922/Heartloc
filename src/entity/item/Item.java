package entity.item;
import entity.Entity;
import entity.player.Player;

public abstract class Item extends Entity {
	public Item(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 *	Egy targy (Item) lehet lathato es nem lathato. Ha lathato
	 *	(isVisible == true), akkor kiashato es felveheto, mig ellenkezo esetben nem.
	 */
	public boolean isVisible = false;
	private int weight = 0;
	
	/**
	 * Lathatova teszi a mezot masok szamara.
	 * 
	 * @param b - Ha lathatova akarjuk tenni a mezot masok szamara true parameter, ha nem akkor false.
	 */
	public void setIsVisible(boolean b) {
		this.isVisible = b;
	}
	/**
	 *  A jatekos, ha rendelkezik Item-mel, annak
	 *	hasznalataval kulonbozo modokon juthat elonyoz - vagy nyerheti meg a
	 *	jatekot.
	 * @param p - Melyik jatekost akarjuk kihuzni.
	 * @return - Ha sikeres true, ha nem false.
	 */
	public boolean pull(Player p) {
		return false;
	}
	/**
	 *  A targyak (Item-ek) eldobhatok, ekkor arra a Tile-re kerulnek
	 *	amin az a Player all aki eldobta.
	 * 
	 */
	public void drop() {
	}
	/**
	 *  A targyak a jaték kezdeten a jegtablakba vannak fagyva.
	 *	Miutan kiastak oket es lathatoak, fel lehet venni a targyakat. 
	 * 
	 */
	public void pickup() {
	}
	/**
	 * A jelzoraketa (Rocket) tobb alkatreszbol
	 *	(TargetItem-bol) all ossze. Ketfele Item letezik: TargetItem es OptionalItem. A
	 *	TargetItem-ek erdemlegesen megvalositjak ezt a metodust, mig az
	 *	OptionalItem-ek csak technikai okok miatt (mivel oroklik es nem absztrakt
	 *	osztalyok) valositjak meg ezt a metodust.
	 * 
	 * @return Az osszeszereles sikeresseget true visszateres jelzi, ellenkezoleg false.
	 */
	public boolean assembleRocket() {
		return false;
	}
	/**
	 *  A jatekos, ha rendelkezik Item-mel, annak hasznalataval
	 *	kulonbozo modokon juthat elonyhoz - vagy nyerheti meg a jatekot
	 * @return Az eves sikersseget true, ellenkezojet false jelzi.
	 */
	public boolean eat() {
		return false;
	}
	/**
	 *  A jatekos, ha rendelkezik Item-mel, annak hasznalataval
	 *  kulonbozo modokon juthat elonyhoz - vagy nyerheti meg a jatekot.
	 * 
	 * @return Ha van mit felvenni akkor true, elenezoleg false.
	 */
	public boolean wear() {
		return false;
	}
	/**
	 *  A jatekos, ha rendelkezik Item-mel, annak hasznalataval
	 *  kulonbozo modokon juthat elonyhoz - vagy nyerheti meg a jatekot.
	 * 
	 * @return Ha az asas sikeres akkor true, elenezoleg false.
	 */
	public boolean dig() {
		return false;
	}
	/**
	 * A jatekos, ha rendelkezik Item-mel, annak
	 *	hasznalataval kulonbozo modokon juthat elonyhoz - vagy nyerheti meg a
	 *	jatekot.
	 * 
	 * @return Az eszkoz sikeres hasznalatanal true ellenkezoleg false.
	 */
	public boolean useTargetItem() {
		return false;
	}
	public int step() {
		return 0;
	}
	public boolean buildTent() {
		return false;
	}
}

