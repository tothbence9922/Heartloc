package sequences;
import java.util.Scanner;

import entity.Igloo;
import entity.player.Eskimo;
import tiles.UnstableTile;

public class Seq02 {
	Eskimo es = new Eskimo();
	UnstableTile ut = new UnstableTile(3);
	Igloo i;
	
	public Seq02() {
		System.out.println("Seq: Eskimo builds Igloo on UnstableTile and it doesn't turn over");
		es.step();
		es.getEnergy();
		System.out.println("\tgetEnergy returned");
		System.out.println("Has enough energy? Enter 0 or 1");
		Scanner sc = new Scanner(System.in);
		int in = -1;
		if (sc.hasNext()) in = sc.nextInt();
		if (in == 1) {
			es.buildIgloo(ut);
			i = new Igloo();
			System.out.println("\t(build) returned");
			ut.receive(i);
			System.out.println("\t(receive) returned");
		}

		System.out.println("\t(step) returned");

		sc.close();
	}
}

