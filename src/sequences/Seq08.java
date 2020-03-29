package sequences;

import entity.player.Explorer;
import tiles.StableTile;

public class Seq08 {
	
	Explorer ex = new Explorer();
	StableTile st = new StableTile();
	
	public Seq08(){
		System.out.println("Seq: Explorer explores StableTile");
		ex.step();
		int getEnergy = ex.getEnergy();
		System.out.println("\t(getEnergy() returned");
		if(getEnergy > 0) {
			ex.exploreTile(st);
			int distance = st.getDistance();
			System.out.println("\t(getDistance() returned");
			System.out.println("\t(exploreTile(st) returned");
			int capacity = ex.exploreTile(st);
			if(distance < 4) {
				st.setCapacityVisible(true);
				System.out.println("\t(setCapacityVisible(boolean) returned");
			}
		}
		System.out.println("\t(step() returned");
	}
}