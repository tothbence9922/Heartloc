package entity.item.targetitem;

public class Rocket extends TargetItem {
	
	// static variable single_instance of type Singleton 
    private static Rocket single_instance = null; 
  
    // private constructor restricted to this class itself 
    private Rocket() { 
    	System.out.println("Rocket has been created");
    } 
  
    public static Rocket getInstance() { 
        if (single_instance == null) 
            single_instance = new Rocket(); 
  
        return single_instance; 
    } 
    
	@Override
	public boolean useTargetItem() {
		System.out.println("Rocket\tboolean useTargetItem()\tparam: -");
		return true;
	}
}
