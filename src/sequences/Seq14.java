package sequences;

import java.util.Scanner;

import entity.item.optionalitem.Wetsuit;
import entity.player.Explorer;
import tiles.StableTile;
import tiles.UnstableTile;

public class Seq14 {
	Explorer ex = new Explorer();
	Explorer ex2 = new Explorer();
	UnstableTile ut = new UnstableTile(5);
	StableTile st = new StableTile();
	Wetsuit w = new Wetsuit();
	
	public Seq14() {
		System.out.println("Seq: Explorer moves to UnstableTile without Hole without Wetsuit and it turns over and exp dies");
		
		ex.move(ut);
		ut.receive(ex);
		
		ut.getLoad();
		System.out.println("\t(getLoad returned)");
		
		System.out.println("Is load larger than capacity? Enter 0 or 1");
		Scanner sc = new Scanner(System.in);
		int in = -1;
		if (sc.hasNext()) in = sc.nextInt();
		
		if (in == 1) {
			ex.pushToWater();
			w.wear();
			System.out.println("\t(wear returned)");
			ex.setInWater(true);
			ex.scream();
			ut.getNeighbours();
			
			st.alarmTile(ex);
			ex2.savePlayer(ex);
			System.out.println("\t(savePlayer returned)");
			System.out.println("\t(alarmTile returned)");
			
			ex.die();
			
			System.out.println("\t(pushToWater returned)");
		}
		
		System.out.println("\t(receive returned)");
		
		System.out.println("\t(move returned)");
		sc.close();	
	}
}
