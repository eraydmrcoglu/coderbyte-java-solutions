import java.util.*; 
import java.io.*;

class Main {

  public static String HamiltonianPath(String[] strArr) {
    // code goes here 
    String str= strArr[2].toString();
    String strc= strArr[1].toString();
    String hp="";
    
    String strnew= str.replaceAll(",","").replace("(","").replace(")","");
    for(int i=0;i<strnew.length()-1;i++){
   
    if(strc.contains(strnew.charAt(i)+"-"+strnew.charAt(i+1))||strc.contains(strnew.charAt(i+1)+"-"+strnew.charAt(i))){
      continue;
    }
    else{
       hp=strnew.charAt(i)+"";
     return hp;
    }
   
    }
    
    
    return "yes";
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(HamiltonianPath(s.nextLine())); 
  }

}
