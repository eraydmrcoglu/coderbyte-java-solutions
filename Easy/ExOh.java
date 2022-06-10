import java.util.*; 
import java.io.*;

class Main {

  public static String ExOh(String str) {
    // code goes here 
    int xCount = 0, oCount = 0;

    for (char c : str.toCharArray()) {
      if (c == 'x' || c == 'X') {
        xCount++;
      } else if (c == 'o' || c == 'O') {
        oCount++;
      }
    }
    return xCount == oCount ? "true" : "false";
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(ExOh(s.nextLine())); 
  }

}