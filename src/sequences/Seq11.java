package sequences;

import entity.item.optionalitem.Wetsuit;
import entity.player.Explorer;
import tiles.StableTile;
import tiles.UnstableTile;

public class Seq11 {
	
	Explorer ex = new Explorer();
	UnstableTile ut = new UnstableTile(8);
	Wetsuit w = new Wetsuit();
	StableTile st = new StableTile();
	
	public Seq11() {
		ex.move(ut);
		boolean hashole = ut.getHasHole();
		System.out.println("\t getHasHole() returned");
		if(hashole) {
			ex.pushToWater();
			boolean wear = w.wear();
			System.out.println("\twear() returned");
			ex.setInWater(true);
			System.out.println("\t setInWater() returned");
			System.out.println("\t pushtoWater() returned");
			
		}
		boolean received = ut.receive(ex);
		System.out.println("\t receive(ex) returned");
		boolean remove = st.remove(ex);
		System.out.println("\t remove(ex) returned");
		System.out.println("\t move(ut) returned");
	}
}