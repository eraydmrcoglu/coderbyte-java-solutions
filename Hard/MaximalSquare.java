import java.util.*; 
import java.io.*;

class Main {

  public static int MaximalSquare(String[] strArr) {
    
    char [][] arr1 = new char[strArr.length][strArr[0].length()];

    for (int i =0 ; i<strArr.length ; i++){
      for (int j =0 ; j<strArr[0].length() ; j++){

        arr1[i][j]=strArr[i].charAt(j);
        
      }
    }

  int x = arr1.length+1;   
  int y = arr1[0].length+1;  
  
  int [][] arr2 = new int [x][y];   

  int max =0 ;

  for (int i = 1 ; i<x ; i++){
    for (int j =1 ; j<y ; j++){

      if (arr1[i-1][j-1]=='1'){  

        arr2[i][j]= Math.min(arr2[i-1][j-1],Math.min(arr2[i-1][j],arr2[i][j-1]))+1;

        if (arr2[i][j]>max){

          max=arr2[i][j];
        }
      }
    }
  }

    return max*max;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(MaximalSquare(s.nextLine())); 
  }
}
