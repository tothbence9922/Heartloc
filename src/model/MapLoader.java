package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MapLoader {
	public static boolean readMapFromJSON(String path) throws FileNotFoundException, IOException {
		try {
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(new FileReader(path));
			JSONArray arrays = (JSONArray) obj.get("tiles");
			
			for (int i = 0; i < arrays.size(); i++) {
				JSONObject tile = (JSONObject) arrays.get(i);
				
				String id = (String) tile.get("id");
				String type = (String) tile.get("type");
				Long hole = (Long) tile.get("hole");
				
				JSONArray neighboursTemp = (JSONArray) tile.get("neighbours");
				ArrayList<String> neighbours = new ArrayList<String>();
				for (int j = 0; j < neighboursTemp.size(); j++) {
					neighbours.add((String) neighboursTemp.get(j));
				}
				
				JSONArray entitiesTemp = (JSONArray) tile.get("entities");
				ArrayList<String> entities = new ArrayList<String>();
				for (int j = 0; j < entitiesTemp.size(); j++) {
					if (entitiesTemp.size() != 0)
						entities.add((String) entitiesTemp.get(j));
				}
				
				JSONArray itemsTemp = (JSONArray) tile.get("items");
				ArrayList<String> items = new ArrayList<String>();
				for (int j = 0; j < itemsTemp.size(); j++) {
					if (itemsTemp.size() != 0)
						items.add((String) itemsTemp.get(j));
				}

				
				System.out.print(id + ", " + type + ", " + hole + ", [");
				for (String s : neighbours) {
					System.out.print(s + ", ");
				}
				System.out.print("], [");
				for (String s : entities) {
					System.out.print(s + ", ");
				}
				System.out.print("], [");
				for (String s : items) {
					System.out.print(s + ", ");
				}
				System.out.print("]\n");
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
