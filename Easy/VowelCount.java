import java.util.i*;
import java.io.*;

class Main {

    public static int VowelCount(String str) {

        String vowels = "aeiou";
        String[] strArray = str.split("");

        int count = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (vowels.contains(strArray[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(VowelCount(s.nextLine()));
    }
}