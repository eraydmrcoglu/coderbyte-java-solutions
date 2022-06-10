import java.util.*;
import java.io.*;

class Main {

    public static boolean PalindromeTwo(String str) {
        //code goes here
        str = str.replaceAll("\\p{Punct}|\\p{Space}|\\p{Digit}| [,;.:!-_]","");
        str = str.toLowerCase();

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String rev = sb.toString();
        if (str.equals(rev)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main (String[] args) {
        //keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(PalindromeTwo(s.nextLine()));
    }
}
