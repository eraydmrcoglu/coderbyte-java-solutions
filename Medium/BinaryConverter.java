import java.util.*; 
import java.io.*;

class Main {

  public static int MathChallenge(String str) {
    // Abdullah Tas 

    int decimal = Integer.valueOf(str,2);
    
    return decimal;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(MathChallenge(s.nextLine())); 
  }

}