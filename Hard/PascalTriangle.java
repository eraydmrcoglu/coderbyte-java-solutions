import java.util.*;
import java.io.*;

class Main {

    public static int PascalsTriangle(int[] arr) {

        if (arr[arr.length - 1] == 1) {
            return -1;
        } else {
            int result = 0;
            int n = arr[1] + 1;
            int[][] arr2 = new int[n][n];

            for (int line = 0; line < n; line++) {
                for (int i = 0; i <= line; i++) {
                    if (line == i || i == 0)
                        arr2[line][i] = 1;
                    else
                        arr2[line][i] = arr2[line - 1][i - 1] + arr2[line - 1][i];
                }
                if ((n - line) == 1) {
                    result = arr2[line][arr.length];
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        //System.out.print(PascalsTriangle(s.nextLine()));
        System.out.println(PascalsTriangle(new int[]{1, 3})); // 3
        System.out.println(PascalsTriangle(new int[]{1, 5, 10, 10})); // 5
        System.out.println(PascalsTriangle(new int[]{1, 5, 10, 10, 5, 1}));
        System.out.println(PascalsTriangle(new int[]{1, 5, 10, 10, 5}));
    }
}