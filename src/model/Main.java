package model;

import entity.item.Item;
import entity.item.optionalitem.Food;
import entity.item.optionalitem.Rope;
import entity.item.optionalitem.Wetsuit;
import entity.item.targetitem.Beacon;
import entity.player.Eskimo;
import sequences.Seq04;

public class Main {
	public static void main(String[] args) {
		Eskimo Pali = new Eskimo();
		Beacon b = new Beacon();
		Food f = new Food();
		Wetsuit w = new Wetsuit();
		
		Pali.items.add(b);
		Pali.items.add(f);
		Pali.items.add(w);
		Pali.items.add(new Rope());

		
		for (Item i : Pali.items) {
			i.use();
		}
		
		int c = -1;
		System.out.println("Choose");
		
		switch(c) {
		case 0:
			break;
		case 1: 
			break;
		case 2: 
			break;
		case -1:
			Seq04 seq01 = new Seq04();
			break;
		}
	}
}

