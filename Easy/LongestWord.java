import java.util.*;
import java.io.*;

class Main {
    public static String LongestWord(String sen) {
        String[] str = sen.replaceAll("[^a-zA-Z0-9^]","").split(" ");
        int wordCount = 0;
        sen = "";

        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].trim();

            if (wordCount < str[i].length()) {
                wordCount = str[i].length();
                sen = str[i];
            }
        }
        return sen;
    }
    
    public static void main (String[] args) {
        //keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));
    }
}