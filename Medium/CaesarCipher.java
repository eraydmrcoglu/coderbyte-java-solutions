import java.util.*;
import java.io.*;

class Main {
    
    public static String CaesarCipher(String str, int num) {
        // code goes here
        int code, newCode;
        String result = "", newChar;

        for (int i = 0; i < str.length(); i++) {
            code = (int) str.charAt(i);
            newCode = code + num;

            if (code >= 65 && code <= 90) {
                if (newCode > 90) newCode = 64 + (newCode - 90);
            }
            else if (code >= 97 && code <= 122) {
                if (newCode > 122) newCode = 96 + (newCode - 122);
            }
            else {
                newCode = code;
            }

            newChar = String.valueOf((char) newCode);
            result += newChar;
        }
        return result;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(CaesarCipher(s.nextLine()));
    }
}