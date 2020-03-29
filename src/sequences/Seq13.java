package sequences;

import java.util.Scanner;

import entity.item.optionalitem.Rope;
import entity.item.optionalitem.Wetsuit;
import entity.player.Explorer;
import tiles.StableTile;
import tiles.UnstableTile;

public class Seq13 {
	Explorer ex = new Explorer();
	UnstableTile ut = new UnstableTile(5);
	Wetsuit w = new Wetsuit();
	StableTile st = new StableTile();
	Explorer ex2 = new Explorer();
	Rope r = new Rope();
	
	public Seq13(Scanner sc) {
		System.out.println("Seq: explorer moves to UnstableTile with Hole without Wetsuit and survives");
		ex.move(ut);
		ut.receive(ex);
		ut.getHasHole();
		System.out.println("\tgetHasHole returned");
		ex.pushToWater();
		w.wear();
		System.out.println("\twear returned");
		ex.setInWater(true);
		ex.scream();
		System.out.println("\tscream returned");
		ut.getNeighbours();
		System.out.println("\tgetNeighbours returned");
		st.alarmTile(ex);
		ex2.savePlayer(ex);
		r.pull(ex);
		System.out.println("\tpull returned");
		ex.move(st);
		ut.remove(ex);
		System.out.println("\tremove returned");
		st.receive(ex);
		System.out.println("\treceive(2) returned");
		System.out.println("\tmove returned");
		System.out.println("\tsavePlayer returned");
		System.out.println("\talarmTile returned");
		System.out.println("\tsetInWater returned");
		System.out.println("\tpushToWater returned");
		System.out.println("\treceive returned");
		System.out.println("\tmove returned");


	}
}
