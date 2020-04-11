package model;


import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import tiles.StableTile;
import tiles.Tile;
import tiles.UnstableTile;

import org.json.simple.parser.JSONParser;

public class MapSaver {

	JSONObject toWrite = new JSONObject();
	
	public Field generateMap() {
		Field field = new Field();
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		Random r = new Random();
		int tileCount = r.nextInt(20);
		for (int i = 0; i < tileCount; i++) {
			int type = r.nextInt()%2;
			if(type % 2 == 0) {
				tiles.add(new StableTile());
			} else {
				int cap = r.nextInt(5);
				tiles.add(new UnstableTile(cap));
			}
		}
		for (int i = 0; i < tiles.size(); i++) {
			int neighCount = r.nextInt(4);
			if(neighCount >= tiles.size()) neighCount = tiles.size()-1;
			for(int j = 0; j < neighCount; j++) {
				int curNeigh = r.nextInt(tileCount);
				if(curNeigh != j) {
					tiles.get(i).addNeighbour(tiles.get(curNeigh));
				}
			}
		}
		field.setTiles(tiles);
		return field;
	}
	
}
