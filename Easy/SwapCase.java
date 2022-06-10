import java.util.*;
import java.io.*;

class Main {

    public static String SwapCase(String str) {

        //code goes here
        char c;
        int strL = 0;
        StringBuffer buffer = new StringBuffer(strL);

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (Character.isTitleCase(c) || Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            }
            else {
                c = Character.toUpperCase(c);
            }
            buffer.append(c);
        }
        return buffer.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(SwapCase(s.nextLine())); 
    }
}