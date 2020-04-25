package entity;

public abstract class Entity {
	protected static int weight;
	protected static String id;
	
	public Entity(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	/**
	 * a jatek soran ez a metodus felel a tevekenysegek megkezdeseert
	 * @return int
	 */
	public abstract int step();
}
