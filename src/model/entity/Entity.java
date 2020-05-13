package model.entity;

import view.entity.EntityView;

public abstract class Entity {

	protected int weight;
	protected String id;
	public EntityView view;
	
	public void Update() { view.Draw();}
	
	/**
	 * Az Entity absztrakt ososztaly konstruktora. A parameterben kapott string lesz az entitas azonositoja.
	 * @param id Az entitas ezt a stringet kapja azonositokent.
	 */
	public Entity(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	/**
	 * A jatek soran ez a metodus felel a tevekenysegek megkezdeseert
	 * 
	 * @return int A jatekosokat reprezentalo osztalyok eseten megadja, mennyi munkakedve maradt a tevekenyseg elvegzese utan az adott jatekosnak.
	 */
	public int step() { return -1;}

}
