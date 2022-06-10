import java.util.*;

class Main {

    public static int LargestFour(int[] arr) {
        // code goes here
        List<Integer> integers = Arrays.stream(arr).boxed().toList();
        return integers.stream().sorted(Collections.reverseOrder()).limit(4).mapToInt(i -> i).sum();
    }

    public static int LargestFour2(int[] arr) {
        // code goes here
        int result = 0;

        for (int i = arr.length - 4; i < arr.length; i++) {
            if (i >= 0) {
                result += arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // keep this function call here
        System.out.println(LargestFour(new int[]{1, 1, 1, -5}) == -2);
        System.out.println(LargestFour(new int[]{0, 0, 2, 3, 7, 1}) == 13);
        System.out.println(LargestFour(new int[]{4, 5, -2, 3, 1, 2, 6, 6}) == 21);
        System.out.println(LargestFour(new int[]{1, 1, 0}) == 2);
        System.out.println(LargestFour(new int[]{1000045}) == 1000045);
    }

}