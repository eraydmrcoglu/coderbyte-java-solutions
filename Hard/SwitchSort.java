import java.util.*;
import javafx.scene.paint.CycleMethod;
import java.io.*;

class Main {

    public static int SwitchSort(int[] arr) {
        //code goes here
        int len = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        boolean[] isChanged = new boolean[len];
        Arrays.fill(isChanged, false);

        int SwitchCount = 0;
        for (int i = 0; i < len; i++) {
            if (isChanged[i] || map.get(arr[i]) == i)
               continue;

            int j = i, cycle = 0;
            while (!isChanged[j]) {
                isChanged[j] = true;
                j = map.get(arr[j]);
                cycle++;
            }
            if (cycle > 0) {
                SwitchCount += (cycle-1);
            }
        }
        return SwitchCount;
    }

    public static void main (String[] args) {
        //keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(SwitchSort(s.nextLine()));
    }
}
