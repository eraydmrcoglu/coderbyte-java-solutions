import java.util.*;

class Main {

    public static String ParallelSums(int[] arr) {
        int[] firstSet = new int[arr.length / 2];
        int[] secondSet = new int[arr.length / 2];

        Arrays.sort(arr);

        int indexOfSet1 = 0;
        int indexOfSet2 = 0;
        int sumOfSet1 = 0;
        int sumOfSet2 = 0;
        int lastIndexOfArr = arr.length -1;

        while (indexOfSet1 < firstSet.length && indexOfSet2 < firstSet.length) {
            if (sumOfSet1 < sumOfSet2) {
                firstSet[indexOfSet1] = arr[lastIndexOfArr];
                indexOfSet1++;
                sumOfSet1 += arr[lastIndexOfArr];
            } else {
                secondSet[indexOfSet2] = arr[lastIndexOfArr];
                indexOfSet2++;
                sumOfSet2 += arr[lastIndexOfArr];
            } 
            lastIndexOfArr--;
        }

        while (lastIndexOfArr >= 0) {
            if (indexOfSet1 < firstSet.length) {
                firstSet[indexOfSet1++] = arr[lastIndexOfArr];
                sumOfSet1 += arr[lastIndexOfArr];
            } else {
                secondSet[indexOfSet2++] = arr[lastIndexOfArr];
                sumOfSet2 += arr[lastIndexOfArr];
            }
            lastIndexOfArr--;
        }
        if (sumOfSet1 != sumOfSet2) {
            return String.valueOf(-1);
        }

        Arrays.sort(firstSet);
        Arrays.sort(secondSet);

        StringBuilder sb = new StringBuilder();
        if (firstSet[0] < secondSet[0]) {
            for (int intSet1 : firstSet) {
                sb.append(intSet1).append(",");
            }
            for (int intSet2 : secondSet) {
                sb.append(intSet2).append(",");
            }
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    public static void main (String[] args) {
        //keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(ParallelSums(s.nextLine()));
    }
}