import java.util.*; 
import java.io.*;

class Main {

  public static String StringChallenge(String[] strArr) {
    // Abdullah Tas

  int point = 0 , comma = 0;

  for ( int i = 0; i < strArr[0].length(); i++){
    char letter = strArr[0].charAt(i);
    if(letter=='.') point++;
    if (letter==',') comma++;
    if(point>1) return "false";
    if(Character.isAlphabetic(letter)) return "false";
  }

  if (comma!=0){

    String [] number = strArr[0].split(",");
  //   1,453,44,443.03
    for ( int i = 1 ; i<number.length-1 ; i++){
      if (number[i].length()!=3) return "false";
    }
    //443.03
    if(point!=0){
      String last = number[number.length-1].substring(0,number[number.length-1].indexOf(".")); //(0,3)
      if(last.length() != 3 ) return "false";
    }
    if(number[0].length()>3) return "false";
  
  }else{ // 10.00
    
    if(point != 0){
      String last = strArr[0].substring(0,strArr[0].indexOf('.'));
      if ( last.length() > 3 ) return "false";
    }else{
      // 1243
      if (strArr[0].length() > 3) return "false";
    }


  }


    return "true";
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}