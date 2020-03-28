package sequences;

import java.util.Scanner;

import entity.item.optionalitem.Food;
import entity.item.optionalitem.Shovel;
import entity.player.Explorer;
import tiles.StableTile;

public class Seq06 {
	
	Explorer ex = new Explorer();
	Shovel s= new Shovel();
	StableTile st = new StableTile();
	Food f = new Food();
	
	public Seq06() {
		System.out.println("Seq: Explorer digs with Shovel");
		ex.step();
		System.out.println("Explorers energy : ");
		ex.getEnergy();
		if(ex.getEnergy()>0) {
			s.dig();
			System.out.println("s.dig() returns true");
			st.dig(2);
			st.removeSnow(2);
			System.out.println("Find item? Enter 0 or 1");
			Scanner sc = new Scanner(System.in);
			int in = -1;
			if (sc.hasNext()) in = sc.nextInt();
			if (in == 1) {
				f.setIsVisible(true);
				System.out.println("\t(setIsVisible returned)");
			}
			sc.close();
			System.out.println("\t(dig(2) returned)");
			System.out.println("\t(dig() returned)");
		}
		System.out.println("\t(step returned)");
	}
}
