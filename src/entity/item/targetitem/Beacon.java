package entity.item.targetitem;

public class Beacon extends TargetItem {

	// static variable single_instance of type Singleton 
    private static Beacon single_instance = null; 
  
    // private constructor restricted to this class itself 
    private Beacon() { 
    	System.out.println("Beacon has been created");
    } 
  
    public static Beacon getInstance() { 
        if (single_instance == null) 
            single_instance = new Beacon(); 
  
        return single_instance; 
    } 
    
	@Override
	public boolean useTargetItem() {
		System.out.println("Beacon\tboolean useTargetItem()\tparam: -");
		return true;
	}
	
}
