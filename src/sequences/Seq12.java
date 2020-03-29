package sequences;

import java.util.Scanner;

import entity.item.optionalitem.Wetsuit;
import entity.player.Explorer;
import tiles.StableTile;
import tiles.Tile;
import tiles.UnstableTile;

public class Seq12 {
	
	int limit=100;
	Explorer ex = new Explorer();
	UnstableTile ut = new UnstableTile(limit);
	Wetsuit w=new Wetsuit();
	StableTile st = new StableTile();
	Explorer ex2=new Explorer();
	
	public Seq12(Scanner sc) {
		System.out.println("Explorer moves to Unstable Tile with Hole without Wetsuit and dies");
		ex.move(st);
		ut.receive(ex);
		ut.getHasHole();
		System.out.println("\t(getHasHole() returned)");
		ex.pushToWater();
		w.wear();
		//false
		System.out.println("\t(wear() returned)");
		ex.setInWater(true);
		System.out.println("\t(setInWater() returned)");
		ex.scream();
		System.out.println("\t(scream() returned)");
		Tile[] tiles = ut.getNeighbours();
		System.out.println("\t(getNeighbours() returned)");
		for(int i=0;i<2;i++) {
			tiles[i].alarmTile(ex);
			ex2.savePlayer(ex);
			System.out.println("\t(savePlayer(ex) returned)");
			System.out.println("\t(alarmTile(ex) returned)");
		}
		ex.die();
		System.out.println("\t(pushToWater() returned)");
		System.out.println("\t(receive(ex) returned)");
		System.out.println("\t(move(ut) returned)");
		 
	}
}
