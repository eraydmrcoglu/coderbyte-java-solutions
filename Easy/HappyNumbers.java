import java.util.*; 
import java.io.*;

class Main {

    public static boolean HappyNumbers(int num) {
        String str = String.valueOf(num);
        int sum = 0;
        while (true) {
            for (int i = 0; i < str.length(); i++) {
                int n = Character.getNumericValue(str.charAt(i));
                sum += (int)Math.pow(n, 2);
            }
            str = String.valueOf(sum);
            sum = 0;
            if (str.equals("1")) 
                return true;
            else if (str.length() == 1 && !str.equals("1"))
                return false;
        }
    }
  
  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(HappyNumbers(s.nextLine())); 
  }
}