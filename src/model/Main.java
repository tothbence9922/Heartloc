package model;

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
	}
}

