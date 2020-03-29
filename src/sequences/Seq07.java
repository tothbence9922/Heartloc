package sequences;

import entity.item.optionalitem.Food;
import entity.item.optionalitem.Shovel;
import entity.player.Explorer;
import tiles.StableTile;

public class Seq07 {
	Explorer ex = new Explorer();
	Food f = new Food();
	
	public Seq07() {
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
