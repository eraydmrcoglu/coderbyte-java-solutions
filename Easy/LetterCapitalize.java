import java.util.*;
import java.io.*;

class Main {
    public static String LetterCapitalize(String str) {
        // code goes here
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.setCharAt(0, Character.toUpperCase(str.charAt(0)));
        for(int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
               strBuilder.setCharAt(i + 1, Character.toUpperCase(str.charAt(i + 1)));
        }
        
        return strBuilder.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LetterCapitalize(s.nextLine()));
    }
}