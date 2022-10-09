import java.util.*; 
import java.io.*;

class Main {

  public static int TrappingWater(int[] arr) {
    // code goes here  
    int result = 0 , sol,sag;

    for (int i =1 ; i < arr.length ; i++){
      sol = arr[i];
      for (int j = 0 ; j<i ; j++){
        sol = Math.max(sol,arr[j]);
      }
      sag = arr[i];
      for (int j =i+1 ; j < arr.length ; j++){
        sag= Math.max(sag,arr[j]);
      }
      result += Math.min(sol,sag) - arr[i];
    }
    return result;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(TrappingWater(s.nextLine())); 
  }

}
