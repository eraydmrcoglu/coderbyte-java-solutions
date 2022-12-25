import java.util.*; 
import java.io.*;

class Main {

  public static String StringChallenge(String str) {
    // code goes here 
    String[] words = str.split(" ");
    int counter = 0;
    boolean lever = true;
    String output;

    for(String s : words){
      counter = 0;
      ArrayList<Character> digits = new ArrayList<Character>();

      for(int i = 0; i< s.length() ; i++){
          if(Character.isDigit(s.charAt(i))){
            counter++;
            digits.add(s.charAt(i));
          }
          if(i<s.length()-2){
            if(Character.isDigit(s.charAt(i)) && Character.isDigit(s.charAt(i+1)) && Character.isDigit(s.charAt(i+2))){
              lever = false;
            }
          }
      }
      Set<Character> set = new HashSet<Character>(digits);
      if(set.size()<3){
        lever=false;
      }
    }

    
    if(lever){
      output = "true";
    }else{
      output = "false";
    }

    return output;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}