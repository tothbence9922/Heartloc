package model.entity.item.optionalitem;

/**
 * A j�t�kosok sz�m�ra lehet�s�get ny�jt testh�m�rs�klet�k n�vel�s�re, ha esznek
 * valamit. Ez a valami az �tel - Food, melyet ez az oszt�ly reprezent�l.
 */
public class Food extends OptionalItem {
	
	public Food(String id) {
		super(id);
	}

	/**
	 * A j�t�kos, ha rendelkezik Food-al, haszn�lhatja azt, hogy n�velje
	 * testh�m�rs�klet�t (bodyTemperature). Az �tel (Food) elt�nik a j�t�kos
	 * t�sk�j�b�l haszn�lat ut�n.
	 * 
	 * @return A visszat�r�si �rt�ke a logikai igaz (true), ezzel jelzi hogy
	 *         sikeresen haszn�lta a Food Itemet a j�t�kos.
	 */
	@Override
	public boolean eat() {
		return true;
	}
	
}
