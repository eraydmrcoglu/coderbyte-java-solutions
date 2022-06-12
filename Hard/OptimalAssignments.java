import java.util.*;
import java.io.*;

class Main {
    
    public static List<Integer[]> permutations = new ArrayList<>();
    public static Integer[] minPermutationsArr = new Integer[0];
    public static Integer minCost = Integer.MAX_VALUE;

    public static String OptimalAssignments(String[] strArr) {
        // code goes here
        Integer[][] matrix = new Integer[strArr.length][strArr.length];

        minPermutationsArr = new Integer[matrix.lenght];

        for (int i = 0; i < strArr.length; i++) {
            String[] splitted = strArr[i].subString(1,strArr[i].length()-1).split(",");

            for (int j = 0; j < splitted.length; j++) {
                matrix[i][j] = Integer.parseInt(splitted[j]);
            }
        }

        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            list.add(i);
        }

        permute(list,0);

        for (Integer[] permutation : permutations) {
            int cost = 0;

            for (int i = 0; i < permutation.length; i++) {
                cost += matrix[i]permutation[i];
            }

            if (cost < minCost) {
                minCost = cost;
                minPermutationsArr = permutation;
            }
        }
        
        String result = "";

        for (int i = 0; i < minPermutationsArr.length; i++) {
            result += "(" + (i + 1) + "-" + (minPermutationsArr[i]+1)+")";
        }
        return result;
    }

    static void permute(List<Integer> list, int k) {
        for (int i = k; i < list.size(); i++) {
            Collections.swap(list,i,k);
            permute(list,k + 1);
            Collections.swap(list,k,i);
        }

        if (k == list.size() -1) {
            Integer[] arr = list.toArray(new Integer[list.size()]);
            permutations.add(arr);
        }
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(OptimalAssignments(s.nextLine()));
    }
}