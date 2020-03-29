package entity.item.targetitem;

public class Cartridge extends TargetItem {
	
	// static variable single_instance of type Singleton 
    private static Cartridge single_instance = null; 
  
    // private constructor restricted to this class itself 
    private Cartridge() { 
    	System.out.println("Cartridge has been created");
    } 
  
    public static Cartridge getInstance() { 
        if (single_instance == null) 
            single_instance = new Cartridge(); 
  
        return single_instance; 
    } 
    
	@Override
	public boolean useTargetItem() {
		System.out.println("Cartridge\tboolean useTargetItem()\tparam: -");
		return true;
	}
	
}
