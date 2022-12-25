import java.util.*; 
import java.io.*;

class Main {

  public static String StringChallenge(String str) {
    int num = 0;
    String stringFinal = "";
    for(int i = 0; i<str.length(); i++){
      if(str.charAt(i)=='I')num+=1;
      else if(str.charAt(i)=='V')num+=5;
      else if(str.charAt(i)=='X')num+=10;
      else if(str.charAt(i)=='L')num+=50;
      else if(str.charAt(i)=='C')num+=100;
      else if(str.charAt(i)=='D')num+=500;
      else if(str.charAt(i)=='M')num+=1000;
    }
    while(num!=0){
      while(num>=1000){
        stringFinal+="M";
        num-=1000;
      }
      while(num>=500){
        stringFinal+="D";
        num-=500;
      }
      while(num>=100){
        stringFinal+="C";
        num-=100;
      }
      while(num>=50){
        stringFinal+="L";
        num-=50;
      }
      while(num>=10){
        stringFinal+="X";
        num-=10;
      }
      while(num>=5){
        stringFinal+="V";
        num-=5;
      }
      while(num>=1){
        stringFinal+="I";
        num-=1;
        if(num-1<0)num=0;
      }
    }
    str = stringFinal;
    return str;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}
Fevzi Yüksel — 17.11.2022 20:06
public class RomanNumeralReduction
{
    public static String reduction(String str)
    {
        Map<Character, Integer> numeralMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);

        TreeMap<Integer, Character> orderedMap = new TreeMap<>(Comparator.reverseOrder());
        for(var pair : numeralMap.entrySet())
            orderedMap.put(pair.getValue(), pair.getKey());

        int sum = 0;
        for(char c : str.toCharArray())
            sum += numeralMap.get(c);

        StringBuilder builder = new StringBuilder(str.length());
        for(var key : orderedMap.keySet())
        {
            while(sum >= key)
            {
                sum -= key;
                builder.append(orderedMap.get(key));
            }
        }

        return builder.toString();
    }
    public static void main(String[] args)
    {
        List<String> cases = List.of("LLLXXXVVVV", "XXXVVIIIIIIIIII", "DDLL", "MM", "CCCCLL", "CCCCCCCCLLLL", "IIIII",
                "IIIIIIIIII", "XXXVVVIIIII", "LXXXVVVIIIII");

        List<String> results = List.of("CC", "L", "MC", "MM", "D", "M", "V", "X", "L", "C");

        cases.stream().map(RomanNumeralReduction::reduction2).forEach(System.out::println);

        System.out.println(Objects.equals(cases.stream().map(RomanNumeralReduction::reduction2).toList(), results));


    }
}
    public static String reduction2(String str)
    {
        Map<Character, Integer> numeralMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);

        TreeMap<Integer, Character> orderedMap = new TreeMap<>(Comparator.reverseOrder());
        for(var pair : numeralMap.entrySet())
            orderedMap.put(pair.getValue(), pair.getKey());

        int sum = 0;
        for(char c : str.toCharArray())
            sum += numeralMap.get(c);

        StringBuilder builder = new StringBuilder(str.length());
        for(var pair : orderedMap.entrySet())
        {
            int value = pair.getKey(), noLetter = sum / value;

            while(0 < noLetter-- )
                builder.append(pair.getValue());

             sum %= value;
        }

        return builder.toString();
    }
dilara — 17.11.2022 20:07
import java.util.*; 
import java.io.*;

class Main {

  public static String RomanNumearalReduction(String str) {
    // code goes here  
    LinkedHashMap<Character,Integer> hsh = new LinkedHashMap<Character,Integer>();
    hsh.put('M',1000);
    hsh.put('D',500);
    hsh.put('C',100);
    hsh.put('L',50);
    hsh.put('X',10);
    hsh.put('V',5);
    hsh.put('I',1);
    int result=0;
    int result1=0;
    String strResult="";
    Character s =' ';
    for(int i=0;i<str.length();i++){
    result += hsh.get(str.charAt(i)) ;
    }
    //System.out.println(result);
    for(Map.Entry<Character,Integer> map: hsh.entrySet() ){
      char value = map.getKey();
      int key = map.getValue();
      result1= result/key;
      result= result%key;
      for(int j=0;j<result1;j++){
        strResult+=value;
      }
    }
    

    return strResult;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}
Abdullah Taş — 17.11.2022 20:11
static String newstr="";

  public static String StringChallenge(String str) {
    // code goes here  
    int result = 0;

    for ( int i = 0 ; i<str.length() ; i++){
      char letter = str.charAt(i);
      switch (letter){
        case 'I' :
        result += 1;
        break;
        case 'V' :
        result += 5;
        break;
        case 'X' :
        result += 10;
        break;
        case 'L' :
        result += 50;
        break;
        case 'C' :
        result += 100;
        break;
        case 'D' :
        result += 500;
        break;
        case 'M' :
        result += 1000;
        break;   
      }
    }

    return repeat(result);
  }

  public static String repeat (int num){
    if (num-1000 >= 0){
      newstr += "M";
      num -=1000;
    }else if (num-500 >= 0){
      newstr += "D";
      num -=500;
    }else if (num-100 >= 0){
      newstr += "C";
      num -=100;
    }else if (num-50 >= 0){
      newstr += "L";
      num -=50;
    }else if (num-10 >= 0){
      newstr += "X";
      num -=10;
    }else if (num-5 >= 0){
      newstr += "V";
      num -=5;
    }else if (num-1 >= 0){
      newstr += "I";
      num -=1;
    }

    return num ==0 ? newstr : repeat(num);
  }
`
Kamil H. — 17.11.2022 21:14
//işlem M
    if (total/1000!=0 && total%1000!=0){
      for (int j=0;j<total/1000;j++){
        result+='M';
      }
      total%=1000;
    }
    if (total/1000==0 && total%1000==0){
      total=total;
    }
    if (total/1000!=0 && total%1000==0){
      for (int j=0;j<total/1000;j++){
        result+='M';
      }
      total=0;
    }
Abdullah Taş — 17.11.2022 23:11
3. soru çözümü 

https://www.youtube.com/watch?v=cS-E817CbGo
YouTube
Abdullah Taş
Coderbyte   Roman Numeral Reduction - JAVA
Görsel
Server Çetin — 24.11.2022 18:19
3.1Tetris Move
Görsel
Görsel
import java.util.*; import java.io.*;

class Main {
      public static int I(int[][] arr){
        int count=0;
        int max=0;
        for(int k=0;k<9;k++) {
            for (int m = 3; m < 12; m++) {
                if (arr[k][m - 3] == 1 && arr[k][m - 2] == 1 && arr[k][m - 1] == 1 && arr[k][m] == 1) {
                    if (reduction(k, 4, arr) == 1) {
                        max = 1;
                    }
                }
            }
        }
        for(int n=0;n<6;n++) {
            for (int m = 0; m < 12; m++) {
                if (arr[n][m] == 1 && arr[n + 1][m] == 1 && arr[n + 2][m] == 1 && arr[n + 3][m] == 1) {
                    count = 0;
                    if (reduction(n, 1, arr) == 1) {
                        count++;
                    }
                    if (reduction(n + 1, 1, arr) == 1) {
                        count++;
                    }
                    if (reduction(n + 2, 1, arr) == 1) {
                        count++;
                    }
                    if (reduction(n + 3, 1, arr) == 1) {
                        count++;
                    }
                    if (count > max) {
                        max = count;
                    }
                }
            }
        }
        return max;
    }
   ...
import java.util.*; import java.io.*;

class Main {
      public static int I(int[][] arr){
        int count=0;
        int max=0;
Genişlet
message.txt
14 KB
 public static int L(int[][] arr){
        int count=0;
        int max=0;
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+2][m]==1){

                    if(reduction(k,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                       count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m+1]==1&&arr[k+1][m+1]==1&&arr[k+2][m]==1&&arr[k+2][m+1]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,2,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k][m+2]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,3,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
     ...
 public static int L(int[][] arr){
        int count=0;
        int max=0;
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+2][m]==1){
Genişlet
message.txt
12 KB
   for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,3,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        return max;
    }
    public static int J(int[][] arr){
        int count=0;
        int max=0;

        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                if(arr[k][m]==1&&arr[k+1][m]==1&&arr[k+2][m]==1&&arr[k+2][m+1]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,2,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k+1][m+1]==1&&arr[k+2][m+1]==1){

                    if(reduction(k,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
     ...
   for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,1,arr)==1){
Genişlet
message.txt
10 KB
   for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m+2]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,3,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k][m+2]==1&&arr[k+1][m]==1){

                    if(reduction(k,3,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }

        return max;
    }
   ...
   for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m+2]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,1,arr)==1){
Genişlet
message.txt
8 KB
 public static int O(int[][] arr){
        int count=0;
        int max=0;

        for(int k=0;k<8;k++){
            for(int m=0;m<11;m++){
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1){

                    if(reduction(k,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
        return max;

    }
    public static int S(int[][] arr){
        int count=0;
        int max=0;

        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k+1][m+1]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
      ...
}
 public static int O(int[][] arr){
        int count=0;
        int max=0;

        for(int k=0;k<8;k++){
            for(int m=0;m<11;m++){
Genişlet
message.txt
7 KB
  for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+2][m]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        return max;
    }
   ... 
  for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+2][m]==1){

                    if(reduction(k,1,arr)==1){
Genişlet
message.txt
6 KB
  for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+2][m]==1){

                    if(reduction(k,1,arr)==1){
Genişlet
message.txt
6 KB
public static int T(int[][] arr){
        int count=0;
        int max=0;

        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                if(arr[k][m]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+2][m]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+2][m+1]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
   ...     
public static int T(int[][] arr){
        int count=0;
        int max=0;

        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
Genişlet
message.txt
6 KB
for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,3,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k][m+2]==1&&arr[k+1][m+1]==1){

                    if(reduction(k,3,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }

        return max;
    }
    public static int Z(int[][] arr){
        int count=0;
        int max=0;

       ...
 for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                if(arr[k][m+1]==1&&arr[k][m+2]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1){

                    if(reduction(k,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+2][m+1]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }

        return max;
    }
    public static int reduction(int row, int ones,int[][] arr){
        int one=0;
        int total=0;
        for(int i=0;i<12;i++){
            total+=arr[row][i];
        }
        if(total==ones){
            one=1;
        }
        return one;
    }


 ...
 public static int ArrayChallenge(String[] strArr) {
    // code goes here  
     int[][] arr= new int[9][12];
        int result=0;
        StringBuilder sb= new StringBuilder();
        for(int i=1;i<10;i++){
            sb.delete(0,sb.length());
            for(int j=1;j<13;j++){

                if((Integer.parseInt(strArr[j]))<i){
                    sb.append(j);
                    arr[i-1][j-1]=1;
                }
                else arr[i-1][j-1]=0;
            }
        }

        if(strArr[0]=="I") {
            result = I(arr);
        }
        if(strArr[0]=="J") {
            result = J(arr);
        }
        if(strArr[0]=="L") {
            result = L(arr);
        }
        if(strArr[0]=="O") {
            result = O(arr);
        }
        if(strArr[0]=="S") {
            result = S(arr);
        }
        if(strArr[0]=="T") {
            result = T(arr);
        }
        if(strArr[0]=="Z") {
            result = Z(arr);
        }

        return result;

  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(ArrayChallenge(s.nextLine())); 
  }
Metin AKSU — 24.11.2022 21:45
1.["L","3","4","4","5","6","2","0","6","5", "3","6","6"] => 3

2.["I","2","4","3","4","5","2","0","2","2","3","3","3"] => 2

3.["T","4","3","2","3","5","2","0","1","2","4","3","4"] => 2

4.["S","4","3","2","3","5","2","0","1","2","4","3","4"] => 1

5.["O","4","3","2","3","5","1","0","1","2","4","3","4"] => 0

6.["T","4","3","2","3","2","1","0","1","2","4","3","4"] => 2

7.["I","4","3","3","4","2","0","0","1","3","4","3","4"] => 1

8.["Z","4","3","3","4","3","3","0","2","3","4","5","4"] => 2

9.["L","2","0","2","4","3","2","2","2","3","4","4","0"] => 0

1.["J","1","1","0","0","3","2","2","2","3","4","3","2"] => 1
dilara — 24.11.2022 22:43
import java.util.*;
import java.io.*;

class tetris {
    public static int I(int[][] arr){
        int count=0;
Genişlet
tetris.java
14 KB
Server Çetin — 01.12.2022 18:03
Array Rotation
Görsel
yavvuz78 — 01.12.2022 18:04
class Main {
        public static String ArrayChallenge(int[] arr) {
            int[] newArr=new int[arr.length];
            String str="";
            newArr[0]=arr[arr[0]];
            for(int i=1;i<arr.length;i++){
                if(arr[0]+i<=arr.length-1){
                    newArr[i]=arr[arr[0]+i];
                }
                else{
                    newArr[i]=arr[(arr[0]+i)-arr.length];
                }
            }
            for(int i=0;i<arr.length;i++){
                str+=String.valueOf(newArr[i]);
            }
            return str ;
        }
Server Çetin — 01.12.2022 18:06
import java.util.*; import java.io.*;

class Main {

  public static String ArrayChallenge(int[] arr) {
    // code goes here  
    LinkedList<Integer> list= new LinkedList<Integer>();
    int rotate = arr[0];
    for(int i=rotate;i<arr.length;i++){
      list.add(arr[i]);
    }
    for(int i=0;i<rotate;i++){
      list.add(arr[i]);
    }

    return list.toString().replace("[","").replaceAll(",","").replace("]","").replaceAll(" ","");
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(ArrayChallenge(s.nextLine())); 
  }

}
import java.util.*; import java.io.*;

class Main {

  public static boolean StringChallenge(String str) {
  
    String[] arr= str.split(" ");

    for(int i=0; i<arr.length; i++){

      String s = arr[i].replaceAll("[a-zA-Z]","");

      if(arr[i].contains(s)){
        return false;
      }
      
      boolean a= ( s.chars().distinct().count()==3 ? true :false ); //regex yordu.

      if(a==false){
        return false;
      }
    }

    return true;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}
Metin AKSU — 01.12.2022 19:09
    public static String arrayRotation(int[] arr) {
        int n = arr[0];
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - n) {
                result += arr[i + n];
            } else {
                result += arr[i + n - arr.length];
            }
        }
        return result;
    }
Aytaç Aydemir — 01.12.2022 19:28
   public static String ArrayChallenge(int[] arr) {
   
  List<Integer> arrList = new ArrayList<>();

  for(int i: arr){
    arrList.add(i);
  }

  
  int rotateNum = arr[0];

  for(int i=0; i<rotateNum; i++){
    int temp = arrList.get(0);
    arrList.remove(0);
    arrList.add(temp);
  }

  String result = arrList.toString().replaceAll("[^0-9]","");

  return result;
  
  }  
Kamil H. — 01.12.2022 19:41
public static String ArrayChallenge(int[] arr) {
    // code goes here
    Stack<Integer> cyc = new Stack<Integer>();
    String result = ""; 
    for (int i=arr[0];i<arr.length;i++){
      cyc.push(arr[i]);
    }
    for (int j=0;j<arr[0];j++){
      cyc.push(arr[j]);
    }
    for(int k:cyc){
      result+=k;
    }
    return result;
  }
Fevzi Yüksel — 01.12.2022 19:45
import static java.lang.System.out;

public class ArrayRotation {

    public static String arrayChallenge(int[] arr) {
        final int shift = arr[0];
        String str1 = "";
        String str2 = "";

        for (int i = 0 ; i < arr.length  ; i++) {
            if(shift > i) 
                str1 += arr[i];
            else 
                str2 += arr[i];
        }
        return str2 + str1 ;
    }

    public static String arrayChallenge2(int[] arr) {
        
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0 ; i < arr.length  ; i++) {
            if(arr[0] > i) 
                 str1.append(arr[i]);
            else 
                str2.append(arr[i]);
        }
        return str2.toString() + str1  ;
    }

    public static void main (String[] args) {
        final List<int[]> inputs = List.of(
                new int[] {2, 3, 4, 1, 6, 10},
                new int[] {3,2,1,6},
                new int[] {4,3,4,3,1,2},
                new int[] {1,1,2},
                new int[] {0,1,2,3},
                new int[] {1,2,3,4,5},
                new int[] {6,2,4,4,4,4,4},
                new int[] {3,3,3,3,3},
                new int[] {4,3,2,1,5,6},
                new int[] {0,0}
        );

        final List<String> results = List.of(
                "4161023",
                "6321",
                "124343",
                "121",
                "0123",
                "23451",
                "4624444",
                "33333",
                "564321",
                "00"
        );

        final Function<int[], String> function = ArrayRotation::arrayChallenge;

        out.println(inputs.stream().map(function).toList().equals(results));
        inputs.stream().map(function).forEach(out::println);
    }
}
 
Abdullah Taş — 01.12.2022 19:45
public static String ArrayChallenge(int[] arr) {
    // code goes here  

    int x = arr[0];
    String result="";
    for ( int i = x ; i<arr.length; i++){
      result +=String.valueOf(arr[i]);
    }
    for ( int j =0 ; j<x ; j++){
      result +=String.valueOf(arr[j]);
    }
    return result;
  }
Abdullah Taş — 01.12.2022 19:45
3. soru çözümü
https://www.youtube.com/watch?v=2Vl3m6g6l9c
YouTube
Abdullah Taş
Coderbyte   Array Rotation - JAVA
Görsel
dilara — 01.12.2022 19:54
import java.util.*; 
import java.io.*;

class Main {

  public static String ArrayChallenge(int[] arr) {
    // code goes here  
    LinkedList<Integer> list= new LinkedList<Integer>();
    int rotate = arr[0];
    for(int i=rotate;i<arr.length;i++){
      list.add(arr[i]);
    }
    for(int i=0;i<rotate;i++){
      list.add(arr[i]);
    }

    return list.toString().replace("[","").replaceAll(",","").replace("]","").replaceAll(" ","");
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(ArrayChallenge(s.nextLine())); 
  }

}
Elif İrem — 01.12.2022 20:04
Görsel
UfukGungor — 01.12.2022 21:26
Görsel
Server Çetin — 08.12.2022 18:04
3 Wildcards
Görsel
dilara — 08.12.2022 20:03
import java.util.*; 
import java.io.*;

class Main {

    public static boolean StringChallenge(String str) {
        // code goes here
        String[] strArr= str.split(" ");
        String myStr =strArr[1];
        List<String> myList = new ArrayList<String>();
        List<String> newList = new ArrayList<String>();
        List<String> otherList = new ArrayList<String>();
        int j=0;

            for (int i = 1; i < myStr.length() ; i++) {

                if (myStr.charAt(i - 1) != myStr.charAt(i)) {
                    myList.add(myStr.substring(j, i));
                    j = i;
                }

            }
            myList.add(myStr.substring(j));



        System.out.println(myList);


        for(String i: myList){
            if(i.matches("[0-9]")){
                newList.add("$");
                otherList.add("$");
            }
            else if(i.length()==1){
                newList.add("+");
                otherList.add("*{1}");
            }
            else if(i.length()!=3){
                newList.add("*{"+String.valueOf(i.length())+"}");
                otherList.add("*{"+String.valueOf(i.length())+"}");
            }
            else if(i.length()==3) {
                newList.add("*");
                otherList.add("*");
            }

        }
        String result=newList.toString().replace("[","").replace("]","").replaceAll(",","").replaceAll(" ","");
        String result1=otherList.toString().replace("[","").replace("]","").replaceAll(",","").replaceAll(" ","");
        System.out.println(result);
        if(result.equals(strArr[0])||result1.equals(strArr[0])){
            return true;
        }
        return false;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }

}
Server Çetin — 15.12.2022 18:14
3 Number Encoding
Görsel
import java.util.*; import java.io.*;

class Main {

  public static String StringChallenge(String str) {
    // code goes here  
    String result="";
    str.toLowerCase();
    for(int i=0;i<str.length();i++){
      if(Character.isLetter(str.charAt(i))){
        result+=str.charAt(i)-97+1;
      }
      else{
        result+=str.charAt(i);
      }
      
    }
    
    return result;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}
import java.util.*; import java.io.*;

class Main {

  public static int SearchingChallenge(String str) {
    int sum = 0;
    String number = "0";

    for(int i =0; i<str.length(); i++){
      if(Character.isDigit(str.charAt(i))){
        number+= str.charAt(i);
      }else{
        sum+=Integer.parseInt(number);
        number= "0";
      }
    }
    sum+=Integer.parseInt(number);
    return sum;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(SearchingChallenge(s.nextLine())); 
  }

}
Abdullah Taş — 15.12.2022 18:25
public class StringChallenge {
  public static String encode(String str) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      char x = str.charAt(x);
      if (Character.isLetter(c)) {
        result.append(Character.toLowerCase(c) - 'a' + 1);
      }

      else {
        result.append(c);
      }
    }

    return result.toString();
  }
}
Abdullah Taş — 15.12.2022 18:25
3 soru cevabı 
https://youtu.be/8Xfcom4iQIY
YouTube
Abdullah Taş
Coderbyte   Number Encoding - JAVA
Görsel
dilara — 15.12.2022 19:47
import java.util.*; 
import java.io.*;

class Main {

  public static String StringChallenge(String str) {
    // code goes here  
    String result="";
    str.toLowerCase();
    for(int i=0;i<str.length();i++){
      if(Character.isLetter(str.charAt(i))){
        result+=str.charAt(i)-97+1;
      }
      else{
        result+=str.charAt(i);
      }
      
    }
    
    return result;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}
Fevzi Yüksel — 15.12.2022 19:55
package Seventh;

import java.util.List;
import java.util.function.Function;

public class NumberEncoding {
Genişlet
NumberEncoding.java
2 KB
Aytaç Aydemir — 15.12.2022 20:03
 public static String StringChallenge(String str) {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String result="";

    char[] arr = str.toCharArray();

    for(int i=0; i<arr.length;i++){

      int index = alphabet.indexOf(arr[i]);
      if(index>=0){
        result += index+1;
      }
      else{
        result +=arr[i];
      }
    }

    return result;
  }
Server Çetin — 22.12.2022 18:33
Step Walking
Görsel
Metin AKSU — 22.12.2022 19:00
    public static int CombinatoricsChallenge(int num) {
        if(num == 1 || num == 2) return num;
        return CombinatoricsChallenge(num - 1) + CombinatoricsChallenge(num - 2);
    }
Bu da ChatGPT'nin çözümü
    public static int CombinatoricsChallenge2(int num) {
      // Her basamak için tırmanma yollarını saklamak için bir dizi oluştur
      int[] ways = new int[num + 1];
      // 0 basamak tırmanıldığında yol sayısı 1'tir (hiçbir şey yapma)
      ways[0] = 1;
      // 1 basamak tırmanıldığında yol sayısı 1'tir (1 adım atma)
      ways[1] = 1;
      // Geri kalan basamaklar için döngü oluştur
      for (int i = 2; i <= num; i++) {
        // i basamak tırmanıldığında yol sayısı, i - 1 basamak tırmanıldığında yol sayısına
        // ve i - 2 basamak tırmanıldığında yol sayısına eşittir
        ways[i] = ways[i - 1] + ways[i - 2];
      }
      // Son basamak tırmanıldığında yol sayısını döndür (bu, basamak sayısıdır)
      return ways[num];
    }
Fevzi Yüksel — 22.12.2022 19:03
Benim tepede memoizationlı bir tane vardı bulabilirsek bakarız
İzzet Ali Yıldırım — 22.12.2022 19:24
Görsel
Abdullah Taş — 22.12.2022 19:53
public static int CombinatoricsChallenge(int num) {
    // Abdullah Tas

    if(num == 0 || num == 1 )
      return 1;

    return CombinatoricsChallenge(num-1) + CombinatoricsChallenge(num-2);
  }
Abdullah Taş — 22.12.2022 19:54
3. soru cevabı
https://youtu.be/jtM_RdkEzAM
YouTube
Abdullah Taş
Coderbyte   Step Walking - JAVA
Görsel
﻿
import java.util.*; import java.io.*;

class Main {
      public static int I(int[][] arr){
        int count=0;
        int max=0;
        for(int k=0;k<9;k++) {
            for (int m = 3; m < 12; m++) {
                if (arr[k][m - 3] == 1 && arr[k][m - 2] == 1 && arr[k][m - 1] == 1 && arr[k][m] == 1) {
                    if (reduction(k, 4, arr) == 1) {
                        max = 1;
                    }
                }
            }
        }
        for(int n=0;n<6;n++) {
            for (int m = 0; m < 12; m++) {
                if (arr[n][m] == 1 && arr[n + 1][m] == 1 && arr[n + 2][m] == 1 && arr[n + 3][m] == 1) {
                    count = 0;
                    if (reduction(n, 1, arr) == 1) {
                        count++;
                    }
                    if (reduction(n + 1, 1, arr) == 1) {
                        count++;
                    }
                    if (reduction(n + 2, 1, arr) == 1) {
                        count++;
                    }
                    if (reduction(n + 3, 1, arr) == 1) {
                        count++;
                    }
                    if (count > max) {
                        max = count;
                    }
                }
            }
        }
        return max;
    }
    public static int L(int[][] arr){
        int count=0;
        int max=0;
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+2][m]==1){

                    if(reduction(k,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                       count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m+1]==1&&arr[k+1][m+1]==1&&arr[k+2][m]==1&&arr[k+2][m+1]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,2,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k][m+2]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,3,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,3,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        return max;
    }
    public static int J(int[][] arr){
        int count=0;
        int max=0;

        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                if(arr[k][m]==1&&arr[k+1][m]==1&&arr[k+2][m]==1&&arr[k+2][m+1]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,2,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k+1][m+1]==1&&arr[k+2][m+1]==1){

                    if(reduction(k,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m+2]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,3,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k][m+2]==1&&arr[k+1][m]==1){

                    if(reduction(k,3,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }

        return max;
    }
    public static int O(int[][] arr){
        int count=0;
        int max=0;

        for(int k=0;k<8;k++){
            for(int m=0;m<11;m++){
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1){

                    if(reduction(k,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
        return max;

    }
    public static int S(int[][] arr){
        int count=0;
        int max=0;

        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k+1][m+1]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+2][m]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        return max;
    }
    public static int T(int[][] arr){
        int count=0;
        int max=0;

        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                if(arr[k][m]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+2][m]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+2][m+1]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m+1]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+1][m+2]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,3,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }
        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                count=0;
                if(arr[k][m]==1&&arr[k][m+1]==1&&arr[k][m+2]==1&&arr[k+1][m+1]==1){

                    if(reduction(k,3,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }

        return max;
    }
    public static int Z(int[][] arr){
        int count=0;
        int max=0;

        for(int k=0;k<8;k++){
            for(int m=0;m<10;m++){
                if(arr[k][m+1]==1&&arr[k][m+2]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1){

                    if(reduction(k,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }

            }
        }
        for(int k=0;k<7;k++){
            for(int m=0;m<11;m++){
                count=0;
                if(arr[k][m]==1&&arr[k+1][m]==1&&arr[k+1][m+1]==1&&arr[k+2][m+1]==1){

                    if(reduction(k,1,arr)==1){
                        count++;
                    }
                    if(reduction(k+1,2,arr)==1){
                        count++;
                    }
                    if(reduction(k+2,1,arr)==1){
                        count++;
                    }
                    if(count>max){
                        max=count;
                    }
                }
            }
        }

        return max;
    }
    public static int reduction(int row, int ones,int[][] arr){
        int one=0;
        int total=0;
        for(int i=0;i<12;i++){
            total+=arr[row][i];
        }
        if(total==ones){
            one=1;
        }
        return one;
    }


  public static int ArrayChallenge(String[] strArr) {
    // code goes here  
     int[][] arr= new int[9][12];
        int result=0;
        StringBuilder sb= new StringBuilder();
        for(int i=1;i<10;i++){
            sb.delete(0,sb.length());
            for(int j=1;j<13;j++){

                if((Integer.parseInt(strArr[j]))<i){
                    sb.append(j);
                    arr[i-1][j-1]=1;
                }
                else arr[i-1][j-1]=0;
            }
        }

        if(strArr[0]=="I") {
            result = I(arr);
        }
        if(strArr[0]=="J") {
            result = J(arr);
        }
        if(strArr[0]=="L") {
            result = L(arr);
        }
        if(strArr[0]=="O") {
            result = O(arr);
        }
        if(strArr[0]=="S") {
            result = S(arr);
        }
        if(strArr[0]=="T") {
            result = T(arr);
        }
        if(strArr[0]=="Z") {
            result = Z(arr);
        }

        return result;

  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(ArrayChallenge(s.nextLine())); 
  }

}