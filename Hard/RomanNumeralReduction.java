import java.util.*;
import java.io.*;

class Main {
    static String RomanNumeralReduction(String str){
        return reduce(calculate(str));
    }

    static String reduce(int num) { // 800 = DCCC, 899 = DCCCXCIX, 900 = CM, 999 = CMXCIX
        String mResult = "";
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        while (num > 0) {
            while (num >= values[i]) {
                mResult += letters[i];
                num -= values[i];
            }
            i++;
        }
        return mResult;
    }    

    static int calculate(String roman){
        int sum = 0;
        for (int i = 0; i < roman.length(); i++) {            
            if (i + 1 < roman.length() && value(roman.charAt(i)) < value(roman.charAt(i + 1)))
                sum -= value(roman.charAt(i));
            else
                sum += value(roman.charAt(i));
        }
        return sum;
    }

    static int value(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(RomanNumeralReduction(s.nextLine())););        
    }
}
EmreDenizz — 09.06.2022
class Main {

  public static String RomanNumeralReduction(String str) {
    char[] arr = str.toCharArray();
    int[] nums = {1,5,10,50,100,500,1000};
    char[] rom = {'I','V','X','L','C','D','M'};
    int num = 0;
    int count = 0;
    String ret = "";
    String exit = "";

    for(int i = 0; i < arr.length; i++){
      for(int j = 0; j < rom.length; j++){
        if(arr[i] == rom[j]){
          num = num + Integer.valueOf(nums[j]);
        }
      }
    }
    for (int z = nums.length - 1; z >= 0; z-- ){
      count = num / Integer.valueOf(nums[z]);
      num = num % Integer.valueOf(nums[z]);
      if(count > 0){
        ret = Printer(count,String.valueOf(rom[z]));
        exit = exit + ret;
      }
    }
    return exit;
  }

  public static String Printer(int sub, String word){
    String back = "";
    
    for(int i = 0; i < sub; i++){
      back = back + word; 
    }
    return back;
  }
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(RomanNumeralReduction(s.nextLine())); 
  }

}