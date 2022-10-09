import java.util.*; 
import java.io.*;

class Main {

  public static int StockPicker(int[] arr) {
    // code goes here
  int result=0;

  for ( int i = 0 ; i<arr.length-1 ; i++){
    for (int j =i+1 ; j<arr.length; j++){
        
        if (arr[i]<arr[j])  if ( arr[j]-arr[i] > result)  result = arr[j]-arr[i];
    }

  }
    return result == 0 ? -1 : result;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StockPicker(s.nextLine())); 
  }

}
