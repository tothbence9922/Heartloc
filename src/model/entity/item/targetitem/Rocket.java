package model.entity.item.targetitem;

public class Rocket extends TargetItem {
	
	// static variable single_instance of type Singleton 
    private static Rocket single_instance = null; 
  
    // private constructor restricted to this class itself 
    private Rocket(String id) { 
    	super(id);
    } 
  /**
   *  a Singleton tervezesi mintat kovetve visszater egy
   *  referenciaval
   * 
   * @return single_instance: Rocket tipsu valtozo
   */
    public static Rocket getInstance(String id) { 
        if (single_instance == null) 
            single_instance = new Rocket(id); 
  
        return single_instance; 
    } 
    /**
     *  Mivel a Rocket az Entity ososztalybol szarmaztatott
     *	osztaly, es minden ososztalya absztrakt, igy implementalnia kell ezt a
	 *	metodust is. A metodus nem modosit semmin, azonban megvalositasa
	 *	technikai okok miatt kotelezo.
     * 
     */
	@Override
	public boolean useTargetItem() {
		return true;
	}
}
