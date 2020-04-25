package model;

public class CommandsErik {
	public static void createStorm(String[] cmd, String cm) {
		String[] t = { "loadMap" };
		loadMap(t);

		Game game = game.getInstance();
		if (cmd.length > 1) {
			game.generateStorm(cmd[1]);
		} else {
			game.generateStorm();
		}

		String[] w = { "save" };
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}

	public static void buildTent(String[] cmd, String cm) {
		String[] t = { "loadMap" };
		loadMap(t);

		Player p = new Player();
		if (cmd.length > 1) {
			for (int i = 0; i < p.inventory.length(); i++) {
				p.inventory.getItem(i).addTent(cmd[1]);
			}
		}

		String[] w = { "save" };
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void check(String[] cmd, String cm) {
		String[] t = { "loadMap" };
		loadMap(t);



		String[] w = { "save" };
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}

	public static void move(String[] cmd, String cm) {
		String[] t = { "loadMap" };
		loadMap(t);

		Player p = new Player();
		for(int i=0; i<currentTile.getNegihbours.length();i++) {
			if(currentTile.getNegihbours(i)==cmd[i]) {
				p.receive(cmd[i]);
				p.remove(currentTile);
				//nem tudom le kell e kezelni a vizbeesest vagy eleg a fallsInWater command
			}
			else {
				//ha nem jo mit irjon ki?
			}
		}

		String[] w = { "save" };
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void dig(String[] cmd, String cm) {
		String[] t = { "loadMap" };
		loadMap(t);
		
		
		for(int i=0; i<cmd[1].inventory.length(); i++) {
			if(cmd[1]inventory.getItem(i).dig())
			{
				currentTile.dig(2);
			}
		}
		else {
			currentTile.dig(1);
		}

		String[] w = { "save" };
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
	
	public static void dig(String[] cmd, String cm) {
		String[] t = { "loadMap" };
		loadMap(t);
		
		cmd[0].setCapacity(cmd[1]);

		String[] w = { "save" };
		// Ez maradjon így, kommentben itt
		// writeMap(w);
	}
}
