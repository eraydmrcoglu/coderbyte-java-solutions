import java.util.*;

class Main {

    public static int count = 0;

    public static void wayToStep(int num,List<Integer> path) {
        if (num == 0) {
            for (Integer i: path) {

            }
            count += 1;
        } else if (num == 1) {
            List<Integer> newPath = new ArrayList<Integer>(path);
            newPath.add(1);
            wayToStep(num-1, newPath);
        } else if (num > 1) {
            List<Integer> newPath1 = new ArrayList<Integer>(path);
            newPath1.add(1);
            wayToStep(num-1, newPath1);

            List<Integer> newPath2 = new ArrayList<Integer>(path);
            newPath2.add(2);
            wayToStep(num-2, newPath2);
        } 
    }

    public static int StepWalking(int num) {
        List<Integer> combiList = new ArrayList<Integer>();
        wayToStep(num, combiList);
        return count;
    }

    public static void main (String[] args) {
        //keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StepWalking(s.nextLine()));
    }
}