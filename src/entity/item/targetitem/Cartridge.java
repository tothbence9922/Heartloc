package entity.item.targetitem;

public class Cartridge extends TargetItem {
	
	// static variable single_instance of type Singleton 
    private static Cartridge single_instance = null; 
  
    // private constructor restricted to this class itself 
    private Cartridge(String id) {
    	super(id);
    } 
    /**
     * a Singleton tervezesi mintat kovetve visszater egy
	 * referenciaval
     * @return single_instance: Cartridge tipusu valtozo
     */
    public static Cartridge getInstance(String id) { 
        if (single_instance == null) 
            single_instance = new Cartridge(id); 
  
        return single_instance; 
    } 
    /**
     *  Mivel a Cartridge az Entity ososztalybol
	 *	szarmaztatott osztaly, es minden ososztalya absztrakt, igy implementalnia kell
	 *	ezt a metodust is. A metodus nem modosit semmin, azonban megvalositasa
	 *	technikai okok miatt kotelezo.
     * 
     */
	@Override
	public boolean useTargetItem() {
		return true;
	}
}
