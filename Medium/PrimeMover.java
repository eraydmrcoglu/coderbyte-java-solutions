import java.util.*;
import java.io.*;

class Main {
    
    public static int PrimeMover(int num) {
        // code goes here
        int count = 0;
        for (int i = 0; i <= 10000; i++) {
            int counter = 0;
            for (int j = i; j >= 1; j--) {
                if (i % j == 0)
                counter++;
            }
            if (counter == 2)
            count++;

            if (count == num)
            return i;
        }
        return -1;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(PrimeMover(s.nextLine()));
    }
}