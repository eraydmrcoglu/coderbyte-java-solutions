import java.util.*;
import java.io.*;

class Main {

    public static int NimWinner(int[] arr) {

        int mResult = 0, x = 0;

        for (int  i = 0; i < arr.length; i++) {
            x ^= arr[i];
            mResult = x > 0 ? 1 : 2;
        }
        return mResult;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(NimWinner(s.nextLine()));
    }
}