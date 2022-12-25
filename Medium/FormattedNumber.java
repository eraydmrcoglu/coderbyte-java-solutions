import java.util.*; 
import java.io.*;

class Main {

  public static String StringChallenge(String str) {

  String newstr="";

  for ( int i = 0 ; i < str.length() ; i++){

    char letter = str.charAt(i);

    if ( letter >= 'a' && letter <= 'z' || letter >= 'A' && letter <='Z'){

      if ( isControl(newstr,letter)) newstr += letter;
    }
  }
  
  return newstr.length() == 26 ? "true" : "false";

  }
  
  public static boolean isControl (String str, char x){

    for (int i =0 ; i<str.length(); i++){
      if(x==str.charAt(i)) return false;
    }
  
  return true;

  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}