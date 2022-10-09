import java.util.*; 
import java.io.*;

class Main {

  public static String AlphabetSoup(String str) {
    // code goes here  
    String newstr="";
    String [] kelime = str.split("");

    Arrays.sort(kelime);

    for( String k : kelime){

      newstr += k;

    }
   
    return newstr;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(AlphabetSoup(s.nextLine())); 
  }

}
