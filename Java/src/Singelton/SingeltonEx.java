package Singelton;

public class SingeltonEx {
	
	 private static SingeltonEx obj=null;
	
	
	private SingeltonEx() {
		
	}
	public static SingeltonEx getInstance() {
		
		if(obj==null) {
			synchronized(SingeltonEx.class)
			{
				obj=new SingeltonEx();
				return obj;
			}
			
		}
		return obj;
	}

}
