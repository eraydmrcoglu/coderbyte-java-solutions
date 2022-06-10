import java.util.*; 
import java.io.*;p

class Main {

    public static boolean SimpleEvens(Long num) {
        // code goes here
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            if (getDigit(arr[i]) % 2 != 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int getDigit(char ch) {
        return Character.getNumericValue(ch);
    }

    public static void main (String[] args) {  
        // keep this function call here     
        Scanner s = new Scanner(System.in);
        System.out.print(SimpleEvens(s.nextLine()L)); 
    }
}