package model.commandsGabor;

import java.text.ParseException;

import entity.Tent;
import entity.item.Item;
import entity.item.optionalitem.Food;
import entity.item.optionalitem.FragileShovel;
import entity.item.optionalitem.Rope;
import entity.item.optionalitem.Shovel;
import entity.item.optionalitem.Wetsuit;
import entity.item.targetitem.Beacon;
import entity.item.targetitem.Cartridge;
import entity.item.targetitem.Gun;
import entity.item.targetitem.Rocket;
import entity.player.Player;
import tiles.Tile;

public class CommandsG {
	
	public static void giveFood(String[] cmd, String cm) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		//Ellenorzom a parancs hosszanak helyesseget
		if(cmd.length != 2)
			 System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
		//Megkeresem a jatekost letezik-e, ha igen letrehozok egy uj item-et es hozzaadom az inventory-hoz.
		String id = cmd[1];
		for(Tile tile : tiles) {
			for(Player p : tile.getPlayers()) {
				if(p.id == id)
					p.AddtoInventory(new Food(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}
		// Ide írd az összes dolgot amit a parancs csinál,
		// hagyhatod kommentbe ha piros lenne anélkül
		//t1.players.add("esk");
		
		String[] w = {"save"};
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void giveShovel(String[] cmd, String cm) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		//Ellenorzom a parancs hosszanak helyesseget
		if(cmd.length != 2)
			 System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
		//Megkeresem a jatekost letezik-e, ha igen letrehozok egy uj item-et es hozzaadom az inventory-hoz.
		String id = cmd[1];
		for(Tile tile : tiles) {
			for(Player p : tile.getPlayers()) {
				if(p.id == id)
					p.AddtoInventory(new Shovel(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}
		// Ide írd az összes dolgot amit a parancs csinál,
		// hagyhatod kommentbe ha piros lenne anélkül
		//t1.players.add("esk");
		
		String[] w = {"save"};
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void giveFragileShovel(String[] cmd, String cm) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		//Ellenorzom a parancs hosszanak helyesseget
		if(cmd.length != 2)
			 System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
		//Megkeresem a jatekost letezik-e, ha igen letrehozok egy uj item-et es hozzaadom az inventory-hoz.
		String id = cmd[1];
		for(Tile tile : tiles) {
			for(Player p : tile.getPlayers()) {
				if(p.id == id)
					p.AddtoInventory(new FragileShovel(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}
		// Ide írd az összes dolgot amit a parancs csinál,
		// hagyhatod kommentbe ha piros lenne anélkül
		//t1.players.add("esk");
		
		String[] w = {"save"};
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void giveTent(String[] cmd, String cm) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		//Ellenorzom a parancs hosszanak helyesseget
		if(cmd.length != 2)
			 System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
		//Megkeresem a jatekost letezik-e, ha igen letrehozok egy uj item-et es hozzaadom az inventory-hoz.
		String id = cmd[1];
		for(Tile tile : tiles) {
			for(Player p : tile.getPlayers()) {
				if(p.id == id)
					p.AddtoInventory(new Tent(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}
		// Ide írd az összes dolgot amit a parancs csinál,
		// hagyhatod kommentbe ha piros lenne anélkül
		//t1.players.add("esk");
		
		String[] w = {"save"};
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void giveRope(String[] cmd, String cm) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		//Ellenorzom a parancs hosszanak helyesseget
		if(cmd.length != 2)
			 System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
		//Megkeresem a jatekost letezik-e, ha igen letrehozok egy uj item-et es hozzaadom az inventory-hoz.
		String id = cmd[1];
		for(Tile tile : tiles) {
			for(Player p : tile.getPlayers()) {
				if(p.id == id)
					p.AddtoInventory(new Rope(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}
		// Ide írd az összes dolgot amit a parancs csinál,
		// hagyhatod kommentbe ha piros lenne anélkül
		//t1.players.add("esk");
		
		String[] w = {"save"};
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void giveWetsuit(String[] cmd, String cm) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		//Ellenorzom a parancs hosszanak helyesseget
		if(cmd.length != 2)
			 System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
		//Megkeresem a jatekost letezik-e, ha igen letrehozok egy uj item-et es hozzaadom az inventory-hoz.
		String id = cmd[1];
		for(Tile tile : tiles) {
			for(Player p : tile.getPlayers()) {
				if(p.id == id)
					p.AddtoInventory(new Wetsuit(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}
		// Ide írd az összes dolgot amit a parancs csinál,
		// hagyhatod kommentbe ha piros lenne anélkül
		//t1.players.add("esk");
		
		String[] w = {"save"};
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void giveCartridge(String[] cmd, String cm) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		//Ellenorzom a parancs hosszanak helyesseget
		if(cmd.length != 2)
			 System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
		//Megkeresem a jatekost letezik-e, ha igen letrehozok egy uj item-et es hozzaadom az inventory-hoz.
		String id = cmd[1];
		for(Tile tile : tiles) {
			for(Player p : tile.getPlayers()) {
				if(p.id == id)
					p.AddtoInventory(new Cartridge(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}
		// Ide írd az összes dolgot amit a parancs csinál,
		// hagyhatod kommentbe ha piros lenne anélkül
		//t1.players.add("esk");
		
		String[] w = {"save"};
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void giveGun(String[] cmd, String cm) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		//Ellenorzom a parancs hosszanak helyesseget
		if(cmd.length != 2)
			 System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
		//Megkeresem a jatekost letezik-e, ha igen letrehozok egy uj item-et es hozzaadom az inventory-hoz.
		String id = cmd[1];
		for(Tile tile : tiles) {
			for(Player p : tile.getPlayers()) {
				if(p.id == id)
					p.AddtoInventory(new Gun(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}
		// Ide írd az összes dolgot amit a parancs csinál,
		// hagyhatod kommentbe ha piros lenne anélkül
		//t1.players.add("esk");
		
		String[] w = {"save"};
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void giveBeacon(String[] cmd, String cm) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		//Ellenorzom a parancs hosszanak helyesseget
		if(cmd.length != 2)
			 System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
		//Megkeresem a jatekost letezik-e, ha igen letrehozok egy uj item-et es hozzaadom az inventory-hoz.
		String id = cmd[1];
		for(Tile tile : tiles) {
			for(Player p : tile.getPlayers()) {
				if(p.id == id)
					p.AddtoInventory(new Beacon(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}
		// Ide írd az összes dolgot amit a parancs csinál,
		// hagyhatod kommentbe ha piros lenne anélkül
		//t1.players.add("esk");
		
		String[] w = {"save"};
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void giveRocket(String[] cmd, String cm) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		//Ellenorzom a parancs hosszanak helyesseget
		if(cmd.length != 2)
			 System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
		//Megkeresem a jatekost letezik-e, ha igen letrehozok egy uj item-et es hozzaadom az inventory-hoz.
		String id = cmd[1];
		for(Tile tile : tiles) {
			for(Player p : tile.getPlayers()) {
				if(p.id == id)
					p.AddtoInventory(new Rocket(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}
		// Ide írd az összes dolgot amit a parancs csinál,
		// hagyhatod kommentbe ha piros lenne anélkül
		//t1.players.add("esk");
		
		String[] w = {"save"};
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void giveItem(String[] cmd, String cm) throws ParseException {
		String[] t = {"loadMap"};
		loadMap(t);
		
		//Ellenorzom a parancs hosszanak helyesseget
		if(cmd.length != 2)
			 System.out.println("Valami nincs rendben! A parancs formaja: \"giveFood jatekosnev\"");
		//Megkeresem a jatekost letezik-e, ha igen letrehozok egy uj item-et es hozzaadom az inventory-hoz.
		String id = cmd[1];
		for(Tile tile : tiles) {
			for(Player p : tile.getPlayers()) {
				if(p.id == id)
					p.AddtoInventory(new Item(Integer.toString(p.getInventory().size())));
				else
					System.out.println("Nem letezik ilyen jatekos");
			}
		}
		// Ide írd az összes dolgot amit a parancs csinál,
		// hagyhatod kommentbe ha piros lenne anélkül
		//t1.players.add("esk");
		
		String[] w = {"save"};
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
}
