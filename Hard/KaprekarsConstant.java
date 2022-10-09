import java.util.*; 
import java.io.*;

class Main {

  public static int count=0;

  public static int KaprekarsConstant(int num) {
    
    String other=Integer.toString(num);
    int []arr=new int[other.length()];

    for(int i=0;i<other.length();i++){
      arr[i]=other.charAt(i)-'0';
    }
    Arrays.sort(arr);

    String low="";
    for(int i=0;i<arr.length;i++){
      low+=arr[i];
    }

    String high=new StringBuilder(low).reverse().toString();
    int diff=Integer.parseInt(high)-Integer.parseInt(low);

    if(diff<1000){
      diff=Integer.parseInt(Integer.toString(diff)+"0");
    }
    count++;
    return diff!=6174 ? KaprekarsConstant(diff) : count;
  }

  public static void main (String[] args) {      
    Scanner s = new Scanner(System.in);
    System.out.print(KaprekarsConstant(s.nextLine()));  
  }
}
