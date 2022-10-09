import java.util.*; 
import java.io.*;

class Main {

  public static int MaxSubarray(int[] arr) {
    // code goes here 
    ArrayList<Integer> arlist = new ArrayList<Integer>();
    for(int i=0;i<arr.length;i++){
      arlist.add(arr[i]);
    }
    
   int sum =0; 
   int max=0;
   for(int i=0;i<arlist.size();i++){
     for(int j=i+1;j<=arlist.size();j++){
      
      sum=0;
      for(Integer k: arlist.subList(i,j)){
      sum+=k;
      if(sum>max){
        max=sum;
      }
      }
      
     }
    
   }
   
    return max;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(MaxSubarray(s.nextLine())); 
  }

}
