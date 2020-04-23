package entity.item.optionalitem;

import entity.player.Player;

public class FragileShovel extends OptionalItem{
		int numofUses;
		public FragileShovel(String id) {
		super(id);
		numofUses = 3;
	}
	
	/**
	 * Felulirja az õsosztálybeli dig() függvényt. Amennyiben numOfUses változó értéke 0-ra csökken, akkor az ásó megsemmisül
	 * @return boolean
	 */
	@Override
	public boolean dig() {
		System.out.println("Dig");
		if(numofUses > 0) {
			numofUses--;
			return true;
		}
		return false;
	}
	/**
	 * Mivel a FragileShovel az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása
	 * technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean pull(Player p) {
		System.out.println("Pull");
		return false;
	}
	
	/**
	 * Mivel a FragileShovel az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása
	 * technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean eat() {
		System.out.println("Food\tvoid setIsVisible()\t param: - ");
		return false;
	}
	/**
	 * Mivel a FragileShovel az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása
	 * technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean wear() {
		System.out.println("Wear");
		return false;
	}
	/**
	 * Mivel a FragileShovel az Entity õsosztályból származtatott osztály, és minden õsosztálya absztrakt
	 * így implementálnia kell ezt a metódust is. A metódus nem módosít semmin, azonban megvalósítása
	 * technikai okok miatt kötelezõ.
	 * @return boolean
	 */
	@Override
	public boolean buildTent() {
		System.out.println("BuildTent");
		return false;
	}
}
