import java.util.*; 
import java.io.*;

class Main {

  public static String StringChallenge(String str) {
    // code goes here
    float value = Float.parseFloat(str); 
    int starCount = 0;
    String sonuc="";

    while(starCount < 5){
      if(value >= 1){
        sonuc+="full ";

        value-=1;
      }
      else if(value > 0){
        if(value+.25 >= 1){
          sonuc+="full ";
        }
        else if(value+.25 >= .5){
          sonuc+="half ";
        }
        else{
          sonuc+="empty ";
        }
        value-=value;
      }
      else{
        sonuc+="empty ";
      }
      starCount++;
    }

    return sonuc;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    String str;
    str = s.nextLine();
    System.out.print(StringChallenge(str)); 
  }

}