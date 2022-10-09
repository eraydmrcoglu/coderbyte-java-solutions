import java.util.*; 
import java.io.*;

class Main {

  public static int TrappingWater(int[] arr) {
    // code goes here  
    ArrayList<Integer> tw = new ArrayList<Integer>();
    for(int i=0;i<arr.length;i++){
      tw.add(arr[i]);
    }
    int sum =0;
    int temp=0;
    for(int i=0;i<tw.size();i++){
      for(int j=i+1;j<tw.size();j++){
        sum=0;
        //System.out.println(tw.subList(i,j+1));
        for(int k: tw.subList(i,j)){
         int max= Math.max(tw.get(i),tw.get(j));
         int min= Math.min(tw.get(i),tw.get(j));
         
          //System.out.println(max);
          //System.out.println(min);
          //System.out.println("boÅ");

          sum+= min-k;
          //sum+=max-min;
          //System.out.println(sum);
          if (sum>temp){
            temp=sum;
          }
        }
      }
    }
    return temp;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(TrappingWater(s.nextLine())); 
  }

}
