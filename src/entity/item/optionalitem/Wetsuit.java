package entity.item.optionalitem;
/**
 * A Wetsuit oszt�ly reprezent�lja a j�t�kos egy lehets�ges t�rgy�t, mellyel k�pes t�l�lni v�zbee�s ut�n, s�r�l�s n�lk�l.
 * @author tothbence9922
 *
 */
public class Wetsuit extends OptionalItem{
/**
 * A Wetsuit haszn�lata automatikus, ha a j�t�kosnak van Wetsuitja �s v�zbe esik, automatikusan haszn�lja.
 * @return Visszat�r�si �rt�ke a logikai Igaz (true), ezzel jelezve hogy a j�t�kosnak van ilyen Item-e �s sz�ks�g eset�n sikeresen haszn�lta.
 */
  @Override
	public boolean wear() {
		System.out.println("Wetsuit\t boolean wear()\tparam: -");
		return true;
	}

}
