package model;

import java.util.ArrayList;

import tiles.Tile;

public class Field implements Drawable {
	private ArrayList<Tile> tiles;
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	public Field() {
		tiles = new ArrayList<Tile>();
	}
	
	public void addTile(Tile t) {
		tiles.add(t);
	}
	public void setTiles(ArrayList<Tile> arrT) {
		tiles = arrT;
	}
}
