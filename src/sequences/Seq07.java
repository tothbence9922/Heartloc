package sequences;

import java.util.Scanner;

import entity.item.optionalitem.Food;
import entity.player.Explorer;

public class Seq07 {
	Explorer ex = new Explorer();
	Food f = new Food();
	
	public Seq07(Scanner sc) {
		System.out.println("Seq: Explorer eats Food");
		ex.step();
		System.out.println("Explorers energy : ");
		ex.getEnergy();
		if(ex.getEnergy()>0) {
			f.eat();
			ex.heal(1);
			System.out.println("\t(heal(1) returned)");
			System.out.println("\t(eat() returned)");
		}
		System.out.println("\t(step() returned)");
	}
}
