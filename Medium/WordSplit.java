import java.util.*; 
import java.io.*;

class Main {

  public static String ArrayChallenge(String[] strArr) {
    // code goes here  
    String output="not possible";
    String otherHalf="";
    String word = strArr[0];
    String[] secondElement = strArr[1].split(",");
    
    for(int i= 0; i<secondElement.length ;i++){
      if(word.contains(secondElement[i])){
        otherHalf = word.replaceAll(secondElement[i],"");
        
        if(Arrays.stream(secondElement).anyMatch(otherHalf::equals)){
          
          String[] elements = {secondElement[i],otherHalf};
          Arrays.sort(elements);
          String newWord = elements[0]+elements[1];

          if(newWord.equals(word)){
            output = elements[0]+","+elements[1];
          }else{
            output = elements[1]+","+elements[0];
          }
        }
      }
    }


    return output;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(ArrayChallenge(s.nextLine())); 
  }

}