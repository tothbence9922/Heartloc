package sequences;

import java.util.Scanner;

import entity.item.optionalitem.Food;
import entity.player.Explorer;
import tiles.StableTile;
public class Seq05 {
	
	Explorer ex = new Explorer();
	StableTile st = new StableTile();
	Food f = new Food();
	
	public Seq05(Scanner sc) {
		System.out.println("Seq: Explorer digs with Hand");
		ex.step();
		st.dig(1);
		st.removeSnow(1);
		System.out.println("\t(removeSnow) returned");
		
		int in = 0;
		if (sc.hasNext()) in = sc.nextInt();
		if (in == 0) {
			f.setIsVisible(true);
			System.out.println("\t(setIsVisible) returned");
		}
		System.out.println("\t(dig) returned");
		System.out.println("\t(step returned)");
	}
}
