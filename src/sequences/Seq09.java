package sequences;

import java.util.Scanner;

import entity.player.Explorer;
import tiles.StableTile;

public class Seq09 {
	
	Explorer ex = new Explorer();
	StableTile st1 = new StableTile();
	StableTile st2 = new StableTile();
	
	public Seq09(Scanner sc) {
		System.out.println("Seq: Explorer moves to StableTile without Hole");
		ex.move(st1);
		st1.receive(ex);
		st1.getHasHole();
		System.out.println("\t(getHasHole() returned)");
		System.out.println("\t(receive(ex) returned)");
		st2.remove(ex);
		System.out.println("\t(remove(ex) returned)");
		System.out.println("\t(move(st1) returned)");
	}
}
