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