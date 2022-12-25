import java.util.*; 
import java.io.*;

class Main {

  static char SAG = 'R';
  static char SOL = 'L';
  static char IKIZ = 'S';
  static char YOK = 'N';
  static String HEPSI = "RLSN";

  public static String StringChallenge(String str) {
    // code goes here

    StringBuilder result = new StringBuilder("");
    char [] c = str.toCharArray();

    for ( int i =c.length-1 ; i>=0 ; i--){

      String parca = yeniParca(str,i);
      String sifre = kod(parca);

      if (i != c.length -1 && result.charAt(0) == sifre.charAt(sifre.length()-1)) {
        result = result.insert(0,sifre.substring(0,sifre.length()-1));

      }else{

        result = result.insert(0,sifre);

      }
    i-=parca.length()-1;

    }

    return result.toString();
  }


  public static String yeniParca (String str,int s){

    StringBuilder parca = new StringBuilder("");
    boolean artan =str.charAt(s) < str.charAt(s-1);

    for ( int i = s ; i>=0; i--){

      char c = str.charAt(i);

      if (HEPSI.indexOf(c) != -1 && parca.length()==0){
        if (c==SAG || c==SOL || c== YOK){
          return str.substring(s-1,s+1);
        }else if (c==IKIZ){
          return str.substring(s-2,s+1);
        }
      }

      if (i==s){
        parca = parca.append(c);
        continue;
      }
      
      char prevC = str.charAt(i+1);
      if (artan && c == (prevC +1) ){
        parca = parca.insert(0,c);
        
        } else if (!artan && c== (prevC-1)) {
        parca = parca.insert(0,c);

      }else{
        break;
      }
    }
      return parca.toString();

  }

  public static String kod (String parca){

    if (parca.indexOf(SAG) != -1){
      char c = parca.charAt(0);
      return String.valueOf((char)(c-1))+String.valueOf((char)(c+1));
    } else if (parca.indexOf(SOL) != -1){
        char c = parca.charAt(0);
      return String.valueOf((char)(c+1)) + String.valueOf((char)(c-1));
    } else if ( parca.indexOf(IKIZ) != -1){
    return parca.substring(0,2);
  }else if (parca.indexOf(YOK) != -1){
    char c = parca.charAt(0);
    return String.valueOf(c) + String.valueOf(c);

  }


  char bas = parca.charAt(0);
  char son = parca.charAt(parca.length()-1);

  if (bas>son){
    return String.valueOf((char)(bas+1)) + String.valueOf((char)(son-1));

  }

  return String.valueOf((char)(bas-1)) + String.valueOf((char)(son+1));

}

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}