import java.util.*;
import java.io.*;

class Main {

  public static int SearchingChallenge(String str) {
    String a = str.replaceAll("[^0-9]"," ");
    String []num = a.split(" +");
    int sum =0;

    for (String b:num) {
      if (!b.equals("")){
        sum+=Integer.parseInt(b);
      }
    } 
    return sum;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(SearchingChallenge(s.nextLine())); 
  }

}