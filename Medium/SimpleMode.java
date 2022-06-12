import java.util.*;
import java.io.*;

class Main {
    
    public static int SimpleMode(int[] arr) {
        // code goes here
        Arrays.sort(arr);
        int counter = 1, maxCounter = 0, mResult = arr[0];

        for(int  i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                counter++;
            }
            else {
                counter = 1;
            }
            if (counter > maxCounter) {
                maxCounter = counter;
                mResult = arr[i];
            }
        }

        if (maxCounter == 1) {
            return -1;
        }
        else {
            return mResult;
        }
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(SimpleMode(s.nextLine()));
    }
}