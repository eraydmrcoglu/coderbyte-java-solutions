import java.util.*; 
import java.io.*;

class Main {

  public static int LargestPair(int num) {
    // code goes here  
    int maxPair = 0;
    int pair = 0;

    while (num != 0){
      pair = num % 100;
  
      if(pair > maxPair){
        maxPair = pair;
      } 
    num /= 10;
    }
    return maxPair;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(LargestPair(s.nextLine())); 
  }

}
