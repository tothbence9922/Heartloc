package model;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {	
		
		try {
			// relative to root: ./folderName
			MapLoader.readMapFromJSON("./assets/maps/map01.json");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

