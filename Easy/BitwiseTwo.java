import java.util.*; 
import java.io.*;

class Main {

  public static String ArrayChallenge(String[] strArr) {
    String str="";
    for(int i=0;i<strArr[0].length();i++){
      if(strArr[0].charAt(i)=='1'&& strArr[1].charAt(i)=='1'){
        str+="1";
      }else if(strArr[0].charAt(i)=='1'&& strArr[1].charAt(i)=='0'){
          str+="0";
      }
      else if(strArr[0].charAt(i)=='0'&& strArr[1].charAt(i)=='0'){
          str+="0";
      }
      else if(strArr[0].charAt(i)=='0'&& strArr[1].charAt(i)=='1'){
          str+="0";
      }
    }
    return str;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(ArrayChallenge(s.nextLine())); 
  }

}