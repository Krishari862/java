
import java.util.Scanner;
public class demos1 {

public static void main(String args[]){
//scanner class to read input from the user
    Scanner sc=new Scanner(System.in);
    //Declaring and creating character array
    char[] arr=new char[5];
    
    //initializing value to the array
    System.out.println("******Initializing array******");
    System.out.println("Enter character values");
    
    arr=sc.next().toCharArray();
        //Take character input 

    
    //displaying the array elements
    System.out.println("\n******displaying array of characters******");
    System.out.println("Entered Characters are");
    for(int i=0; i<arr.length; i++){
        System.out.print(arr[i]+"\t");
    }
}
}