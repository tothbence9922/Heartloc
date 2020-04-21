package entity.player;
import tiles.Tile;

/**
 * A j�t�kban szerepl� egyik entit�s. Kezd�sk�nt 5 egys�gnyi testh�je van, 
 * valamint egy k�l�nleges k�pess�ge is: tud iglut �p�teni, amiben megb�jva 
 * a h�vihar nem tesz k�rt benn�k.
 */
public class Eskimo extends Player {

	public Eskimo() {
		this.bodyTemperature = 5;
		this.energy = 4;
	}
	
	/**
	 * bool buildIgloo(Tile chosenTile): Az ősosztályból származó metódus, mely
	 * itt az Eszkimó képességét valósítja meg: épít egy iglut arra a jégtáblára, ahol
	 * az Eszkimó áll.
	 * @param t - Az a Tile ami áll az Eszkimó
	 * @return - A sikeresen felépített Iglu esetén true, ellenkező esetben false.
	 */
	public boolean buildIgloo(Tile chosenTile) {
		System.out.println("Eskimo\tvoid build()\tparam: " + chosenTile);
		return false;
	}
 
	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}
}
