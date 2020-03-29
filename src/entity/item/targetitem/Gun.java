package entity.item.targetitem;

public class Gun extends TargetItem {
	
	// static variable single_instance of type Singleton 
    private static Gun single_instance = null; 
  
    // private constructor restricted to this class itself 
    private Gun() { 
    	System.out.println("Gun has been created");
    } 
  
    public static Gun getInstance() { 
        if (single_instance == null) 
            single_instance = new Gun(); 
  
        return single_instance; 
    } 
    
	@Override
	public boolean useTargetItem() {
		System.out.println("Gun\tboolean useTargetItem()\tparam: -");
		return true;
	}

}
