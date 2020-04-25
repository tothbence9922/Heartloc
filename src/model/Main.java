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
			} else if (tokens[0].equals("addExplorer")) {
				addExplorer(tokens);
			} else if (tokens[0].equals("addPolarBear")) {
				addPolarBear(tokens);
			} else if (tokens[0].equals("addIgloo")) {
				addIgloo(tokens);
			} else if (tokens[0].equals("addTent")) {
				addTent(tokens);
			} else if (tokens[0].equals("addHole")) {
				addHole(tokens);
			} else if (tokens[0].equals("addSnow")) {
				addSnow(tokens);
			} else if (tokens[0].equals("addFood")) {
				addFood(tokens);
			} else if (tokens[0].equals("addShovel")) {
				addShovel(tokens);
			} else if (tokens[0].equals("addFragileShovel")) {
				addFragileShovel(tokens);
			} else if (tokens[0].equals("addRope")) {
				addRope(tokens);
			} else if (tokens[0].equals("exit")) {
				s.close();
				break;
			}
			System.out.println(currentMap);
		}

	}
}
