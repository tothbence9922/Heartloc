package entity.player;
import tiles.Tile;

/**
 * A játékban szereplõ egyik entitás. Kezdésként 5 egységnyi testhõje van, 
 * valamint egy különleges képessége is: tud iglut építeni, amiben megbújva 
 * a hóvihar nem tesz kárt bennük.
 */
public class Eskimo extends Player {

	public Eskimo() {
		this.bodyTemperature = 5;
		this.energy = 4;
	}
	
	/**
	 * bool buildIgloo(Tile chosenTile): Az Å‘sosztÃ¡lybÃ³l szÃ¡rmazÃ³ metÃ³dus, mely
	 * itt az EszkimÃ³ kÃ©pessÃ©gÃ©t valÃ³sÃ­tja meg: Ã©pÃ­t egy iglut arra a jÃ©gtÃ¡blÃ¡ra, ahol
	 * az EszkimÃ³ Ã¡ll.
	 * @param t - Az a Tile ami Ã¡ll az EszkimÃ³
	 * @return - A sikeresen felÃ©pÃ­tett Iglu esetÃ©n true, ellenkezÅ‘ esetben false.
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
