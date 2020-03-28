package sequences;

import entity.player.Explorer;
import tiles.UnstableTile;

public class Seq10 {
	Explorer ex = new Explorer();
	UnstableTile ut = new UnstableTile(2);
	UnstableTile ut2 = new UnstableTile(2);
	
	public Seq10() {
		System.out.println("Seq: Explorer moves to UnstableTile without hole and it doesn’t turn over");
		ex.move(ut);
		ut.receive(ex);
		ut.getHasHole();
		System.out.println("\t(getHasHole) returned");
		ut.getLoad();
		System.out.println("\t(getLoad) returned");
		System.out.println("\t(receive) returned");
		ut2.remove(ex);
		System.out.println("\t(remove) returned");
		System.out.println("\t(move) returned");
		}
}
