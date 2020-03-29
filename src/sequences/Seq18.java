package sequences;

import java.util.Scanner;

import entity.item.targetitem.Rocket;
import entity.player.Explorer;
import model.Game;
import tiles.StableTile;

public class Seq18 {
	Explorer ex = new Explorer();
	StableTile st = new  StableTile();
	Rocket r;
	Game g = new Game();
	
	public Seq18(Scanner sc) {
		System.out.println("Seq: Explorer uses TargetItem and it works");
		ex.step();
		st.assembleRocket();
		st.getNumOfTargetItems();
		System.out.println("\t(getNumOTargetItems) returned");
		r = new Rocket();
		System.out.println("\t(assmebleRocket) returned");
		r.useTargetItem();
		System.out.println("\t(useTargetItem) returned");
		g.victory();
		g.EndGame();
		System.out.println("\t(EndGame) returned");
		System.out.println("\t(assmebleRocket) returned");
		System.out.println("\t(step) returned");	
	}
}
