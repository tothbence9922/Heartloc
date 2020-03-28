package sequences;

import entity.item.targetitem.Rocket;
import entity.player.Explorer;
import model.Game;
import tiles.StableTile;

public class Seq18 {
	Explorer ex = new Explorer();
	StableTile st = new  StableTile();
	Rocket r = new Rocket();
	Game g = new Game();
	public Seq18() {
		ex.step();
		st.assembleRocket();
		st.getNumOfTargetItems();
		System.out.println("\t(getNumOTargetItems) returned");
		System.out.println("\t(assmebleRocket) returned");
		r.useTargetItem();
		System.out.println("\t(useTargetItem) returned");
		
	}
}
