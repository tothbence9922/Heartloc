package model.entity.item.optionalitem;

import controller.GameRunner;
import view.entity.TentView;

public class TentItem extends OptionalItem {

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
