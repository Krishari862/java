package JavaBasics;

public class PairOfString {

	public static void main(String[] args) {
		String str="afgaaeeeffrrii";
		char[] chararray=str.toCharArray();
		String newstr="";
		for(int i=0;i<str.length()-1;i++) {
			
				if(chararray[i]==chararray[i+1]) {
					newstr=newstr+chararray[i]+chararray[i+1]+",";
				}
		}
		System.out.println("hi");
		System.out.println(newstr.substring(0, newstr.length()-1).toString());

	}
}
