import java.util.*; 
import java.io.*;

class Main {

  public static String StringChallenge(String str) {
    char []arr = str.toCharArray();
    int []nums= {1,5,10,50,100,500,1000};
    char []rom={'I','V','X','L','C','D','M'};
    int num=0;
    int count=0;
    String ret = "";
    String exit = "";

    for(int i=0;i<arr.length;i++){
      for(int j=0;j<rom.length;j++){
        if(arr[i]==rom[j]){
          num=num+Integer.valueOf(nums[j]);
        }
      }
    }
    for(int z = nums.length-1;z>=0;z--){
      count = num / Integer.valueOf(nums[z]);
      num=num%Integer.valueOf(nums[z]);
      if(count >0){
        ret = Print(count, String.valueOf(rom[z]));
        exit = exit+ret;
      }
    }return exit;
  }
public static String Print(int sub, String word){
  String back = "";
  for(int i =0; i<sub; i++){
    back = back + word;
  }return back;
}
    
  

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}