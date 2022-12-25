import java.util.*; 
import java.io.*;

class Main {

  public static List<List<Integer>> permute(int[] nums){
    List<List<Integer>> result = new ArrayList<>();
    Permutation(0,nums,result);
    return result;
  }


  public static void Permutation(int i,int[]nums,List<List<Integer>> result){
    if(i == nums.length-1){
      List<Integer> list = new ArrayList<>();
      for(int n: nums) list.add(n);
      result.add(list);
    }else{
      for(int j = i,l= nums.length;j<l;j++){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        Permutation(i+1,nums,result);
        temp = nums[j];
        nums[j]= nums[i];
        nums[i] = temp;
      }
    }
  }


  public static boolean checkForPrime(int inputNumber){
    boolean isItPrime = true;
    if(inputNumber<=1){
      isItPrime=false;
      return isItPrime;
    }else{
      for(int i=2;i<= inputNumber/2;i++){
        if((inputNumber%i)== 0){
          isItPrime = false;
          break;
        }
      }
      return isItPrime;
    }
  }


  public static int concatenateArr(List<Integer> arr){
    int ans = arr.get(0);
    for(int i = 1; i<arr.size();i++){
      int l = (int)Math.floor(Math.log10(arr.get(i))+1);
      ans = ans * (int)Math.pow(10,1);
      ans += arr.get(i);
    }
    return ans;
  }

  public static int MathChallenge(int num) {
     String temp = Integer.toString(num);
     int[] myArray = new int[temp.length()];
     for(int i = 0;i< temp.length();i++){
       myArray[i]= temp.charAt(i)-'0';
     }
    List<List<Integer>> array = permute(myArray);
    //System.out.print(concatenateArr(array.get(4)));
    //System.out.print(array);
     for(int i=0;i<array.size();i++){
       if(checkForPrime(concatenateArr(array.get(i)))==true){
         return 1;
       }
     }   
    return 0;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(MathChallenge(s.nextLine())); 
  }
}