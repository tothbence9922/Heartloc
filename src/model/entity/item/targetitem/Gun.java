package model.entity.item.targetitem;

import view.entity.GunView;

public class Gun extends TargetItem {
	
	public GunView view;
	
	// static variable single_instance of type Singleton 
    private static Gun single_instance = null; 
  
    // private constructor restricted to this class itself 
    private Gun(String id) { 
    	super(id);
    } 
    /**
     *  a Singleton tervezesi mintat kovetve visszater egy
	 *	referenciaval
     * 
     * @return single_instance: Gun tipusu valtozo
     */
    public static Gun getInstance(String id) { 
        if (single_instance == null) 
            single_instance = new Gun(id); 
  
        return single_instance; 
    } 
    /**
     *  Mivel a Gun az Entity ososztalybol szarmaztatott
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
