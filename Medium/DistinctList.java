import java.util.; 
import java.io.;

class Main {

  public static int DistinctList(int[] arr) {
    Arrays.sort(arr);
    int counter = 0;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] == arr[i]) {
        counter++;
      }
    }
    return counter;
  }

  public static void main (String[] args) { 
    //keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(DistinctList(s.nextLine())); 
  }
}