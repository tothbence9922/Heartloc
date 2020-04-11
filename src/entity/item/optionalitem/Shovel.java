package entity.item.optionalitem;
/**
 * Az egyik opcion�lis t�rgyat, az �s�t (Shovel) megval�s�t� �s reprezent�l� oszt�ly.
 * @author tothbence9922
 *
 */
public class Shovel extends OptionalItem{
	/**
	 * A j�t�kos, ha rendelkezik Shovel-lel, haszn�lhatja azt, hogy �sson vele. Ezzel k�t egys�gnyi havat takar�that el, azonban Itemet nem vehet fel Shovel haszn�lat�val.
	 * @return Visszat�r�si �rt�ke a logikai Igaz (true), ezzel jelezve hogy a j�t�kos sikeresen haszn�lta  az �s� (Shovel) Itemet.
	 */
	@Override
	public boolean dig() {
		System.out.println("Shovel\tboolean dig()\tparam: -");
		return true;
	}
	
}
