import java.util.*; 
import java.io.*;

class Main {

    public static String FibonacciChecker(int num) {
        int fib1 = 0;
        int fib2 = 1;
        do { 
            int saveFib1 = fib1;
            fib1 = fib2;
            fib2 = saveFib1 + fib2;
        }
        while (fib2 < num);
        if (fib2 == num) {
            return "yes";
        } else {
            return "no";
        }

    }

    public static void main (String[] args) {  
        // keep this function call here     
        Scanner s = new Scanner(System.in);
        System.out.print(FibonacciChecker(s.nextLine())); 
    }
}
