import java.util.*;
import java.io.*;

class Main {
    public static int ConsonantCount(String str) {
        int result = 0;
        String vowels = "aeiuoAEIUO";
        for (int i = 0; i < s.length(); i++) {
            if (!vowels.contains(Character.toString(str.charAt(i))) && Character.isLetter(str.charAt(i))) {
                result = result + 1;
            }
        }
        return result;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(ConsonantCount(s.nextLine())); 
    }
}

