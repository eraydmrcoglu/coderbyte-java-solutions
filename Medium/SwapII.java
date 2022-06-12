import java.util.*;
import java.io.*;

class Main {
    
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static String ALPHABET = alphabet.toUpperCase();
    static String digits = "0123456789";

    public static String SwapII(String str) {
        // code goes here
        String[] words = str.split(" ");
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] newWord = new char[word.length()];
            int count = 0;
            int firstIndex = -1;
            for (int j = 0; j < word.length(); j++) {
                if (alphabet.contains(String.valueOf(word.charAt(j)))) {
                    String s = String.valueOf(word.charAt(j)).toUpperCase();
                    newWord[j] = s.charAt(0);
                }
                else if (ALPHABET.contains(String.valueOf(word.charAt(j)))) {
                    String s = String.valueOf(word.charAt(j)).toLowerCase();
                    newWord[j] = s.charAt(0); 
                }
                else if (digits.contains(String.valueOf(word.charAt(j)))) {
                    if (count == 0) {
                        firstIndex = j;
                    }
                    newWord[j] = word.charAt(j);
                    count++;
                }
                else {
                    newWord[j] = word.charAt(j);
                }
                if (count == 2) {
                    char temp = newWord[j];
                    newWord[j] = newWord[firstIndex];
                    newWord[firstIndex] = temp;
                    count = 0;
                }
            }
            newString.append(newWord);
            if ( i < word.length -1) {
                newString.append(" ");
            }
        }
        return newString.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(SwapII(s.nextLine()));
    }
}