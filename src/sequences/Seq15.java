package sequences;

import java.util.Scanner;

import entity.item.optionalitem.Rope;
import entity.item.optionalitem.Wetsuit;
import entity.player.Explorer;
import tiles.StableTile;
import tiles.Tile;
import tiles.UnstableTile;

public class Seq15 {
	
	Explorer ex = new Explorer();
	UnstableTile ut = new UnstableTile(8);
	Wetsuit w = new Wetsuit();
	StableTile st = new StableTile();
	Explorer ex2 = new Explorer();
	Rope r = new Rope();
	
	public Seq15(Scanner sc) {
		System.out.println("Explorer moves to UnstableTile without Hole without Wetsuit and it turns over and exp survives");
		ex.move(ut);
		ut.receive(ex);
		int load = ut.getLoad();
		System.out.println("\t getLoad() returned");
		System.out.println("\t getCapacity() returned");
		
		if(ut.getCapacity() < load) {
			ex.pushToWater();
			w.wear();
			System.out.println("\t wear() returned");
			ex.setInWater(true);
			int scream = ex.scream();
			System.out.println("\t scream() returned");
			Tile neighbours[] = ut.getNeighbours();
			System.out.println("\t getNeighbours() returned");
			boolean alarmtile = st.alarmTile(ex);
			ex2.savePlayer(ex);
			boolean pull = r.pull(ex);
			System.out.println("\t pull(ex) returned");
			ex.move(ut);
			boolean remove = ut.remove(ex);
			System.out.println("\t remove(ex) returned");
			boolean receive = st.receive(ex);
			System.out.println("\t receive(ex) returned");
			System.out.println("\t move(ut) returned");
			System.out.println("\t savePlayer() returned");
			System.out.println("\t alarmTile(ex) returned");
		}
		
		System.out.println("\t pushToWater() returned");
		System.out.println("\t receive(ex) returned");
		System.out.println("\t move(ut) returned");
	}
}