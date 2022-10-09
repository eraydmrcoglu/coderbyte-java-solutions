import java.util.*; 
import java.io.*;

class Main {

  public static String ArithGeoII(int[] arr) {
    double ratio=arr[1]/arr[0];
    int difference=arr[1]-arr[0];
    String arithgeo="";
    for(int i=1;i<arr.length-1;i++){
      if(arr[i+1]-arr[i]==difference){
        if(!arithgeo.equals("Geometric")){
          arithgeo="Arithmetic";
        }
        else{
          return "-1";
        }
      }else{
        if(arithgeo.equals("Arithmetic")){
          return "-1";
        }
      }
      if(arr[i+1]/arr[i]==ratio){
        if(!arithgeo.equals("Arithmetic")){
          arithgeo="Geometric";
        }
        else{
          return "-1";
        }
      }else{
        if(arithgeo.equals("Geometric")){
          return "-1";
        }
      }
      if(arithgeo.equals("")){
        return "-1";
      }
    }
    // code goes here  
    return arithgeo;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(ArithGeoII(s.nextLine())); 
  }

}
