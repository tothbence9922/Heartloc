package entity.item.targetitem;

public class Rocket implements TargetItem {
	@Override
	public boolean use() {
			System.out.println("Rocket is not yet usable");
		return false;
	}
	/**
	 *  A f�ggv�nyt megh�vva az �sszerakott TargetItem
	 *	(Rocket) els�l, ez�ltal jelezve a j�t�k v�g�t, hogy nyertek a j�t�kosok. 
	 */
	@Override
	public boolean useTargetItem() {
		System.out.println("Rocket\tboolean useTargetItem()\tparam: -");
		return false;
	}
}
