package model;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		
		Scanner s = new Scanner(System.in);
		while(true) {
			String input = s.nextLine();
			String[] tokens = input.split(" ");
			
			if(tokens[0].equals("loadMap")) {
				loadMap(tokens);
			}
			else if(tokens[0].equals("exit")) {
				s.close();
				break;
			}
		}
		
	}
	
	static protected void loadMap(String[] cmd) {
		if(cmd.length < 2)
			return;
		if(cmd[1].equals("map01")) {
			try {
				// relative to root: ./folderName
				MapLoader.readMapFromJSON("./assets/maps/map01.json");				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		else {
			try {
				MapLoader.readMapFromJSON("./assets/maps/map01.json");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

