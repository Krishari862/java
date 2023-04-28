package Singelton;

public class CheckSingelton {
	public static  void main(String args[]) {
		// TODO Auto-generated method stub
		SingeltonEx se=SingeltonEx.getInstance();
		
		System.out.println(se.hashCode());
		SingeltonEx se1=SingeltonEx.getInstance();
		System.out.println(se1.hashCode());
		
			
		}
	
}
