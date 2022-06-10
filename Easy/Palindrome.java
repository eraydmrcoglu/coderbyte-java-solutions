import java.util.Scanner;
import java.util.*; 
import java.io.*;

class Main {

  public static String Palindrome(String str) {
    // code goes here
    // Remove non-alphanumeric characters
    String strProcessed = str.replaceAll("[^a-zA-Z0-9]", "");

    // Check for inequality in pairs
    int strProcessedLength = strProcessed.length();
    for (int index = 0; index <= strProcessedLength / 2; index++) {
      if (strProcessed.charAt(index) != strProcessed.charAt(strProcessedLength - 1 - index)) {
        return "false";
      }
    }
    // If no inequality, must be palindrome
    return "true";
  }

  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(Palindrome(s.nextLine())); 
  }

}