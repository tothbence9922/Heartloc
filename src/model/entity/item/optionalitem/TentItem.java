package model.entity.item.optionalitem;

import controller.GameRunner;
import view.entity.TentView;

/**
 * A TentItem osztaly reprezentalja a jatekos egy lehetséges targyat, mellyel
 * kepes egy Tentet felallitani.
 */
public class TentItem extends OptionalItem {
	
	/**
	 * A TentItem letrehozásakor egy TentViewt is letrhozunk, amit elhelyezunk a palyan.
	 */
	public TentItem(String id) {
		super(id);
		view = new TentView(GameRunner.baseGameController);
		view.getBounds().width = view.getBounds().height = 32;
	}

	/**
	 * A jatekos, ha rendelkezik Item-mel, annak hasznalataval kulonbozo modokon
	 * juthat elonyhoz - vagy nyerheti meg a jatekot.
	 * 
	 * @return Ha az epites sikeres true-val ter vissza.
	 */
	@Override
	public boolean buildTent() {
		return true;
	}

}
