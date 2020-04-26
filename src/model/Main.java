package model;

import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class Main extends Commands {	
	
	public static void main(String[] args) throws ParseException {
		
		Scanner s = new Scanner(System.in);
		while (true) {
			String input = s.nextLine();
			String[] tokens = input.split(" ");

			if (tokens[0].equals("loadMap")) {
				loadMap(tokens);
			} else if (tokens[0].equals("addEskimo")) {
				addEskimo(tokens);
			} else if (tokens[0].equals("giveShovel")) {
				giveShovel(tokens);
			}
		}

		/*try {
			MapLoader.readMapFromJSON("./assets/maps/temp.json");
			
			System.out.println((Game.getInstance()).toString());
			
			Game.getInstance();
			Game.getPlayers().get(0).addToInventory(new FragileShovel("Fra2"));
			Game.getPlayers().get(0).addToInventory(new FragileShovel("Fra3"));
			Game.getPlayers().get(0).addToInventory(new FragileShovel("Fra4"));
			
			//Game.getPlayers().get(0).damage(3);
			System.out.println(Game.getPlayers().get(0).exploreTile(new StableTile("t1")));
			Game.getPlayers().get(0).heal(2);
			
			System.out.println((Game.getInstance()).toString());
			//System.out.println((Game.getInstance()).toJSON());
			
			FileWriter fw = new FileWriter("./assets/maps/temp.json");
			fw.write(Game.getInstance().toJSON());
			fw.close();
			} catch (Exception e){ e.printStackTrace();}*/

	}
}
