package entity;

public abstract class Entity {

	protected int weight;
	protected String id;

	public Entity(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	/**
	 * A jatek soran ez a metodus felel a tevekenysegek megkezdeseert
	 * 
	 * @return int
	 */
	public int step() { return -1;}

}
