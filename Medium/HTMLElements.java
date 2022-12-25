import java.util.*;
import java.io.*;

class mediumChallenge {
    public static String[][] taken = {{"b","/b"},{"i","/i"},{"em","/em"},{"div","/div"},{"p","/p"}};


    public static boolean isFirstTerm(String str){
        for(String[] array: taken){
            if(array[0].equals(str)){
                return true;
            }
        }
        return false;
    }


    public static boolean matches(String firstTerm, String lastTerm){
        for(String[] array: taken){
            if(array[0].equals(firstTerm)){
                return array[1].equals(lastTerm);
            }
        }
        return false;
    }

    public static String StringChallenge(String str) {
        // code goes here
        
        String[] strArr=str.split("[<>]");
        ArrayList<String> arrList= new ArrayList<String>();
        Stack<String> stack= new Stack<String>();
        for(String s: strArr){
            for(String[] array: taken){
                if(s.equals(array[0])||s.equals(array[1])){
                    arrList.add(s);

                }

            }
        }
        
        if(arrList.size()==1){
            return arrList.get(0);
        }

        for(int i=0;i<arrList.size();i++){
            
            if(isFirstTerm(arrList.get(i))) {
                stack.push(arrList.get(i));
            }
            
            else {
                    String result= stack.pop();
                    stack.push(result);
                if (stack.isEmpty()||!matches(stack.pop(), arrList.get(i)))  {
                    return result;
                }
            }
        }

        return "true";
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }

}