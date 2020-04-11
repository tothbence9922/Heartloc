package sequences;

import java.util.Scanner;

import entity.Igloo;
import entity.player.Eskimo;
import tiles.StableTile;

public class Seq01 {
	Eskimo es = new Eskimo();
	StableTile st = new StableTile();
	Igloo i;
	
	public Seq01(Scanner sc) {
		System.out.println("Seq: Eskimo builds Igloo on StableTile");
		es.step();
		es.getEnergy();
		
		System.out.println("Has energy? Enter 0 or 1");
		
		int in = -1;
		if (sc.hasNext()) in = sc.nextInt();
		
		if (in == 1) {
			es.buildIgloo(st);
			i = new Igloo();
			st.receive(i);
			System.out.println("\t(receive returned)");
		}
		
		System.out.println("\t(step returned)");
	}
}
