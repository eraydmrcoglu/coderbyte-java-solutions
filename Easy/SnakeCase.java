import java.util.*; 
import java.io.*;

class Main {

  public static String SnakeCase(String str) {
    // code goes here  

    String result="";

    for (int i =0 ; i<str.length() ; i++){

      if(Character.isAlphabetic(str.charAt(i))){
        result+=str.charAt(i);

      }else{

        result+="_";
      }


    }

    result=result.toLowerCase();
    return result;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(SnakeCase(s.nextLine())); 
  }

}
