import java.util.*; 
import java.io.*;

class Main {

  public static int StringReduction(String str) {
    // code goes here  
    int a=0,b=0,c=0;

    for (int i =0 ; i<str.length(); i++){
      if (str.charAt(i)=='a') a++;

      if (str.charAt(i)=='b') b++;

      if (str.charAt(i)=='c') c++;

    }

    if (a==str.length() || b==str.length() || c==str.length()) return str.length();

    if ((a%2==0 && b%2==0 && c%2==0) || (a%2==1 && b%2==1 && c%2==1)){
      return 2;

    }else{

      return 1;

    }
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringReduction(s.nextLine())); 
  }

}
