import java.util.*; 
import java.io.*;

class Main {

  public static int PowerSetCount(int[] arr) {

    int len = arr.length ;
    int result = 0;
    for (int i = 0 ; i < len + 1; i++){
      result += factorial(len) / (factorial(len-i) * factorial (i));
    }
    return result;
    
  }
  public static int factorial(int x){
    if( x <= 1) return 1;
    return x * factorial(x-1);
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(PowerSetCount(s.nextLine())); 
  }

}
