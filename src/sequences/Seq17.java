package sequences;

import entity.item.targetitem.Rocket;
import entity.player.Explorer;
import tiles.StableTile;

public class Seq17 {
	Explorer ex = new Explorer();
	StableTile st = new StableTile();
	Rocket r = new Rocket();
	
	public Seq17() {
		System.out.println("Seq: Explorer uses TargetItem and it doesn't work");
		ex.step();
		st.assembleRocket();
		st.getNumOfTargetItems();
		System.out.println("\tgetNumOfTargetItems returned");
		r.
	}
}
