package model.entity.item.targetitem;

public class Beacon extends TargetItem {

	// static variable single_instance of type Singleton 
    private static Beacon single_instance = null; 
  
    // private constructor restricted to this class itself 
    private Beacon(String id) { 
    	super(id);
    } 
    /**
     *  a Singleton tervezesi mintat kovetve visszater egy
	 *  referenciaval
     * 
     * @return  single_instance: Beacon tipusu valtozo
     */
    public static Beacon getInstance(String id) { 
        if (single_instance == null) 
            single_instance = new Beacon(id); 
        return single_instance; 
    } 
    /**
     *  Mivel a Beacon az Entity ososztalybol
     * szarmaztatott osztaly, es minden ososztalya absztrakt, igy implementalnia kell
	 * ezt a metodust is. A metodus nem modosit semmin, azonban megvalositasa
	 * technikai okok miatt kotelezo.
     * 
     */
	@Override
	public boolean useTargetItem() {
		return true;
	}
}
