import java.util.*; 
import java.io.*;

class Main {

  public static int NumberSearch(String str) {
    // code goes here 
    double countLetter=0;
    double sumTotal=0;
    int result=0;
    for(int i=0;i<str.length();i++) {
      if(Character.isLetter(str.charAt(i))){
        countLetter++;
      }
      if(Character.isDigit(str.charAt(i))==true){
        sumTotal += Character.getNumericValue(str.charAt(i));
    
      }
    }
    result =(int) Math.round(sumTotal/countLetter);
   
    return result;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(NumberSearch(s.nextLine())); 
  }

}