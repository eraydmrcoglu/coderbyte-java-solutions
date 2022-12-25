import java.util.*;
import java.io.*;

class Challenge {

    public static String ArrayChallenge(String[] strArr) {
        // code goes here
        int[] array= new int[strArr.length];
        int desiredLength=0;
        String result="";


        for(int i=0;i< strArr.length;i++){
            array[i]= strArr[i].length();
        }
        Arrays.sort(array);

        desiredLength=array[strArr.length-3];
        for(int i= 0;i< strArr.length;i++){
            if(strArr[i].length()==desiredLength){
                result= strArr[i];
            }

        }

        return result;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(ArrayChallenge(new String[] {"hello", "world", "after", "all"}));
    }

}