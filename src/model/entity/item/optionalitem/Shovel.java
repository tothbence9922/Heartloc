package model.entity.item.optionalitem;

import java.io.IOException;

import controller.GameRunner;
import view.entity.ShovelView;

/**
 * Az egyik opcionális tárgyat, az ásót (Shovel) megvalósító és reprezentáló
 * osztály.
 */
public class Shovel extends OptionalItem {

	public Shovel(String id) {
		super(id);
		try {
			view = new ShovelView(GameRunner.baseGameController);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * A játékos, ha rendelkezik Shovel-lel, használhatja azt, hogy ásson vele.
	 * Ezzel két egységnyi havat takaríthat el, azonban Itemet nem vehet fel Shovel
	 * használatával.
	 * 
	 * @return Visszatérési értéke a logikai Igaz (true), ezzel jelezve hogy a
	 *         játékos sikeresen használta az Ásó (Shovel) Itemet.
	 */
	@Override
	public boolean dig() {
		return true;
	}

}
