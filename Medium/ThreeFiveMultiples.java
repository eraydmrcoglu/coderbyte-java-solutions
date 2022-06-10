import java.util.*;
import java.io.*;

class Main {

    private static final Set<Integer> freq = new HashSet<>();

    public static void CountMultiples (int num, int mp) {
        for (int i = mp; i < num; i += mp) {
            if (i% mp == 0) {
                freq.add(i);
            }
        }
    }

    public static int ThreeFiveMultiples(int num) {

        int total = 0;
        CountMultiples(num, 3);
        CountMultiples(num, 5);
        for (int i: freq) {
            total += i;
        }
        return total;
    }

    public static void main (String[] args) {
        //keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(ThreeFiveMultiples(s.nextLine()));
    }
}