import java.util.*; 
import java.io.*;

class Main {

  public static String MathChallenge(String str) {
    // code goes here
    for(char item : str.toCharArray())
      if(!(item == '0' || item == '1'))
         return "Argument Exception";
    
    double acc = 0;
    for(int i = 0; i< str.length(); i ++)
    {
        
        int num = Integer.parseInt(String.valueOf(str.charAt(i)));
        acc += num * Math.pow(2, str.length() - 1 - i);
    }
    return String.valueOf((int)acc);
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(MathChallenge(s.nextLine())); 
  }

}