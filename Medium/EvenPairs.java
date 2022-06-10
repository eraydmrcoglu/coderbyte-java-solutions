import java.util.*; 
import java.io.*;

class Main {

  public static boolean EvenPairs(String str) {
    // code goes here  
    char[] characters = str.toCharArray();
    int length = characters.length;
    int counter = 0;
    int evenCounter = 0;
    
    for(int i=0; i<length; i++) {

      boolean isEven = false;

      if (!isDigit(characters[i])) {
        counter = 0;
      } else {
        if (isEven(getDigit(characters[i]))){
          isEven = true;
        }  
        counter++;      
      }

      if (counter > 1 && isEven) {
        return true;
      }
    }

    return false;
  }

  static int getDigit(char ch) {
    return Character.getNumericValue(ch);
  }

  static boolean isDigit(char ch) {
    if (Character.isDigit(ch)) {
      return true;
    }
    return false;
  }

  static boolean isEven(int n) {
    if (n % 2 == 0) {
      return true;
    }
    return false;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(EvenPairs(s.nextLine())); 
  }

}