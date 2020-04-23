package entity;

public abstract class Entity {
	private int weight;
	public String id;
	
	public Entity(String id) {
		this.id = id;
	}
	
	/**
	 * a jatek soran ez a metodus felel a tevekenysegek megkezdeseert
	 * @return int
	 */
	public abstract int step();
}
