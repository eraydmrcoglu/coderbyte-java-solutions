import java.util.*; 
import java.io.*;

class Main {

  public static String StringChallenge(String str) {
    // code goes here
    str = str.toLowerCase();
    char[] charArray = str.toCharArray();
    
    for(int i = 0; i < charArray.length; i++) {
    
      if(!(charArray[i] <= 90 && charArray[i] >= 65 || charArray[i] <= 122 && charArray[i] >= 97)) {
        charArray[i] = ' ';

        if(charArray[i] == ' ' && charArray[i+1] <= 122 && charArray[i+1] >= 97){
         charArray[i+1] -= 32;
        } 
      }
    }


    String str2 = String.copyValueOf(charArray);
    str2 = str2.replaceAll("\s", "");

    return str2;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 

  }

}