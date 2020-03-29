package sequences;

import java.util.Scanner;

import entity.item.targetitem.Rocket;
import entity.player.Explorer;
import tiles.StableTile;

public class Seq17 {
	Explorer ex = new Explorer();
	StableTile st = new StableTile();
	Rocket r = new Rocket();
	
	public Seq17(Scanner sc) {
		System.out.println("Seq: Explorer uses TargetItem and it doesn't work");
		ex.step();
		st.assembleRocket();
		st.getNumOfTargetItems();
		System.out.println("\tgetNumOfTargetItems returned");
		
		System.out.println("Is number of target items == 3? Enter 0 or 1");

		int in = -1;
		if (sc.hasNext()) in = sc.nextInt();
		
		if (in == 1) {
			r = new Rocket();
		}
		
		System.out.println("\tassembleRocket returned");
		
		r.useTargetItem();
		
		System.out.println("\tuseTargetItem returned");
	}
}
