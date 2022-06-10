import java.util.; 
import java.io.;

class Main {

  public static String RunLength(String str) {
    // code goes here
    String repost = "";
    int count = 1;
    char c = str.charAt(0);
    for(int i=1; i<str.length();i++){
      if(str.charAt(i)==c){
        count++;
      }
      else{
        repost += count + "" +c;
        c = str.charAt(i); 
        count = 1;
      }
    }

    repost += count + "" +c;

    return repost;
  }

  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(RunLength(s.nextLine()));
  }
}
