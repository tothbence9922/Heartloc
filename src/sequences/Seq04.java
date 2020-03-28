package sequences;
import java.util.Scanner;

import entity.item.optionalitem.Food;
import entity.player.Explorer;
import model.Helper;
import tiles.StableTile;

public class Seq04 {

	Explorer ex = new Explorer();
	StableTile st = new StableTile();
	Food f = new Food();
	
	public Seq04() {
		System.out.println("Seq: Explorer digs with Hand and get an Item");
		ex.step();
		st.dig(1);
		st.removeSnow(1);
		System.out.println("\tremoveSnow returned");
		System.out.println("\tdig returned");
		System.out.println("Find item? Enter 0 or 1");
		Scanner sc = new Scanner(System.in);
		int in = -1;
		if (sc.hasNext()) in = sc.nextInt();
		if (in == 1) {
			f.pickup();
			System.out.println("\tpickup returned");
		}
		System.out.println("\tstep returned");
		System.out.println("Sequence is over...");
		sc.close();
	}
}
