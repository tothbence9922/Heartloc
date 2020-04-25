package entity.item.optionalitem;

/**
 * A Wetsuit oszt�ly reprezent�lja a j�t�kos egy lehets�ges t�rgy�t, mellyel
 * k�pes t�l�lni v�zbee�s ut�n, s�r�l�s n�lk�l.
 */
public class Wetsuit extends OptionalItem {
	
	public Wetsuit(String id) {
		super(id);
	}

	/**
	 * A Wetsuit haszn�lata automatikus, ha a j�t�kosnak van Wetsuitja �s v�zbe
	 * esik, automatikusan haszn�lja.
	 * 
	 * @return Visszat�r�si �rt�ke a logikai Igaz (true), ezzel jelezve hogy a
	 *         j�t�kosnak van ilyen Item-e �s sz�ks�g eset�n sikeresen haszn�lta.
	 */
	@Override
	public boolean wear() {
		return true;
	}
	
}
