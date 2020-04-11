package sequences;
import java.util.Scanner;

import entity.item.optionalitem.Food;
import entity.player.Explorer;
import tiles.StableTile;

public class Seq04 {

	Explorer ex = new Explorer();
	StableTile st = new StableTile();
	Food f = new Food();
	
	public Seq04(Scanner sc) {
		System.out.println("Seq: Explorer digs with Hand and get an Item");
		ex.step();
		st.dig(1);
		st.removeSnow(1);
		System.out.println("\tremoveSnow returned");
		System.out.println("\tdig returned");
		System.out.println("Find item? Enter 0 or 1");

		int in = -1;
		if (sc.hasNext()) in = sc.nextInt();
		if (in == 1) {
			f.pickup();
			System.out.println("\tpickup returned");
		}
		System.out.println("\tstep returned");
		System.out.println("Sequence is over...");
	}
}
