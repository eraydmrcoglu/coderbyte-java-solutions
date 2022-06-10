import java.util.*; 
import java.io.*;

class Main {

    public static String NumberReverse(String str) {
        List liste = Arrays.asList(str.split(" "));
        String ters = "";
        for (int i = liste.size()-1; i >= 0; i--) {
            ters += " " + liste.get(i);
        }
        return ters;
    }
  
  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(NumberReverse(s.nextLine())); 
  }
}