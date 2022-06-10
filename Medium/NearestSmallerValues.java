import java.util.*;
import java.io.*;

class Main {
   
    public static int[] NearestSmallerValues(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int num = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] || arr[j] == arr[i]){
                    num = arr[j];
                    break;
                }
            }
            newArr[i] = num;
        }
        return newArr;
    }

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = NearestSmallerValues(s.nextLine());
        for (int a : arr) System.out.print(a + " ");
    }
}

