package model.entity;

import java.util.Random;

import controller.GameRunner;
import model.tiles.StableTile;
import model.tiles.Tile;
import view.GameView;

public class PolarBear extends Entity {

	private Tile currentTile = new StableTile("");

	public PolarBear(String id) {
		super(id);
	}

	public void move(Tile t) {
		currentTile.remove(this);

		t.receive(this);

		setCurrentTile(t);
		if(t.getPlayers().size() != 0)
			t.getPlayers().get(0).getEaten("A polar bear has eaten a player...");

	}

	@Override
	public int step() {
		Random r = new Random();
		for (Tile t : currentTile.getNeighbours()) {
			int go = r.nextInt() % 2;
			if (go == 0) {
				move(t);
				this.view.setBounds(t.view.getBounds());
				GameView.getInstance(GameRunner.baseGameController).updatePanel();
				return 0;
			}
		}
		return -1;
	}

	public void setCurrentTile(Tile t) {
		this.currentTile = t;
	}

}
