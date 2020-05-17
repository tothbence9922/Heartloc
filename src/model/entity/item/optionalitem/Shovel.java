package model.entity.item.optionalitem;

import java.io.IOException;

import controller.GameRunner;
import view.entity.ShovelView;

/**
 * Az egyik opcion�lis t�rgyat, az �s�t (Shovel) megval�s�t� �s reprezent�l�
 * oszt�ly.
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
	 * A j�t�kos, ha rendelkezik Shovel-lel, haszn�lhatja azt, hogy �sson vele.
	 * Ezzel k�t egys�gnyi havat takar�that el, azonban Itemet nem vehet fel Shovel
	 * haszn�lat�val.
	 * 
	 * @return Visszat�r�si �rt�ke a logikai Igaz (true), ezzel jelezve hogy a
	 *         j�t�kos sikeresen haszn�lta az �s� (Shovel) Itemet.
	 */
	@Override
	public boolean dig() {
		return true;
	}

}
