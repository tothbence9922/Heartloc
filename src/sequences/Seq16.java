package sequences;

import java.util.Scanner;

import entity.item.optionalitem.Wetsuit;
import entity.player.Explorer;
import tiles.UnstableTile;

public class Seq16 {
	Explorer ex = new Explorer();
	UnstableTile ut = new UnstableTile(5);
	UnstableTile ut2 = new UnstableTile(4);
	Wetsuit w = new Wetsuit();
	
	public Seq16(Scanner sc) {
		System.out.println("Seq: Explorer moves to UnstableTile with Wetsuit without hole and it turns over");
		ex.step();
		
		ut.receive(ex);
		ut.getHasHole();
		System.out.println("\t(getHasHole returned)");
		ut.getLoad();
		System.out.println("\t(getLoad returned)");
		
		System.out.println("Is load larger than capacity? Enter 0 or 1");
		
		int in = -1;
		if (sc.hasNext()) in = sc.nextInt();
		
		if (in == 1) {
			ex.pushToWater();
			w.wear();
			System.out.println("\t(wear returned)");
			ex.setInWater(true);
			
			System.out.println("\t(pushToWater returned)");
		}
		
		System.out.println("\t(receive returned)");
		
		ut2.remove(ex);
		System.out.println("\t(remove returned)");
		System.out.println("\t(step returned)");
	}
}
