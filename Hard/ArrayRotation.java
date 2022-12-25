import java.util.*; 
import java.io.*;

class Main {

  public static boolean StringChallenge(String str) {
  
    String[] arr= str.split(" ");

    for(int i=0; i<arr.length; i++){

      String s = arr[i].replaceAll("[a-zA-Z]","");

      if(arr[i].contains(s)){
        return false;
      }
      
      boolean a= ( s.chars().distinct().count()==3 ? true :false ); //regex yordu.

      if(a==false){
        return false;
      }
    }

    return true;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}