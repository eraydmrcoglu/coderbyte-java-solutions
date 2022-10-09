import java.util.*; 
import java.io.*;

class Main {

  public static int GCF(int[] arr) {
    // code goes here  
    int sayac=1,gfc=0;

    
    while ( sayac <= arr[0]){

      if ( arr[0] % sayac==0 && arr[1]%sayac==0) gfc=sayac;

      sayac++;
    }
    
    return gfc==0 ? 1 : gfc;

  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(GCF(s.nextLine())); 
  }

}
