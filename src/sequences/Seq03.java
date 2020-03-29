package sequences;

import java.util.Scanner;

import entity.Igloo;
import entity.player.Eskimo;
import tiles.UnstableTile;

public class Seq03 {
	Eskimo es = new Eskimo();
	Igloo i = new Igloo();
	UnstableTile ut = new UnstableTile(5);
	
	public Seq03(){
		System.out.println("Seq: Eskimo builds Igloo on UnstableTile and it turns over");
		es.step();
		es.getEnergy();
		System.out.println("\tgetEnergy returned");
		System.out.println("Does the Eskimo have energy? 0 - No\t1 - Yes");
		Scanner sc = new Scanner(System.in);
		int in = -1;
		if (sc.hasNext()) in = sc.nextInt();
		if (in == 1) {
			es.buildIgloo(ut);
			i = new Igloo();
			System.out.println("\tcreate returned");
			ut.receive(i);
			System.out.println("Will the UnstableTile turn over? 0 - No\t1 - Yes");
			in= sc.nextInt();
			if (in == 1) {
				es.pushToWater();
				System.out.println("\tpushToWater returned");
			}
			System.out.println("\trecieve returned");
			
		}
		sc.close();
		System.out.println("\tstep returned");
		System.out.println("Sequence is over...");
	}
}
