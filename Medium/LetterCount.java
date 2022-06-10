import java.util.*;
import java.io.*;

class Main {

    public static String LetterCount(String str) {
        
        int count = 0, temp = 0;
        String[] myList = str.split(" ");
        String word = myList[0];

        for (int i = 0; i < myList.length; i++) {
            for (int j = 0; j < myList[i].length(); j++) {
                temp = 0;

                for (int k = 0; k < myList[i].length(); k++) {
                    if (myList[i].charAt(j) == myList[i].charAt(k)) {
                        temp++;
                    }
                }

                if (count < temp) {
                    count = temp;
                    word = myList[i];
                    temp = 0;
                }
                if (count == 1) {
                    return "-1";
                }
                str = word;
                return str;
            }
        }
    }
    
    public static void main (String[] args) {
        //keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LetterCount(s.nextLine()));
    }
}
