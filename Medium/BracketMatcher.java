import java.util.*; 
import java.io.*;

class Main {

  public static String BracketMatcher(String str) {

    if(!str.contains("(") && !str.contains(")"))
      return "1";

    Stack<String> stack = new Stack<String>();
    String[] strArray = str.split("");

    for(int i=0; i < strArray.length; i++){

      String x = strArray[i];

      if(x.equals("("))
        stack.push(x);
      
      if(x.equals(")")){
        if(stack.isEmpty())
          return "0";
        
        String y = stack.peek();
        if(x.equals(")") && y.equals("(")){
          stack.pop();
        }else{
          return "0";
        }
      }
    }
    
    if(stack.isEmpty())
      return "1";
    else
      return "0";
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(BracketMatcher(s.nextLine())); 
  }

}