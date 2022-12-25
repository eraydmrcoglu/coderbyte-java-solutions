import java.util.*; 
import java.io.*;

class Main {

  public static String StringChallenge(String str) {
    // code goes here  
    String result="";
    str.toLowerCase();
    for(int i=0;i<str.length();i++){
      if(Character.isLetter(str.charAt(i))){
        result+=str.charAt(i)-97+1;
      }
      else{
        result+=str.charAt(i);
      }
      
    }
    
    return result;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}