import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static String ArrayCouples(int[] arr) {
        ArrayList <Integer> pairs = new ArrayList<Integer>();
        ArrayList <ArrayList<Integer>> allPairs = new ArrayList<ArrayList<Integer>>();
        int j = 0 ;
        for(int i = 0 ; i < arr.length-1 ; i += 2 ){
            j = i + 1 ;
            pairs.add(arr[i]);
            pairs.add(arr[j]);
            allPairs.add(pairs);
            pairs = new ArrayList<Integer>();
        }
        ArrayList <Integer> unPairs = findMatch( allPairs);
        if( unPairs.isEmpty()) {return "yes";}
        else {
            String listString = unPairs.stream().map(Object::toString)
                    .collect(Collectors.joining(","));
            return listString;
        }
    }
    public static ArrayList<Integer> reversed(ArrayList<Integer> list){
        ArrayList<Integer> rev = new ArrayList<Integer>();
        for (int i = list.size()-1 ; i >= 0 ; i--){
            rev.add(list.get(i));
        }
        return rev;
    }
    public static  ArrayList <Integer> findMatch ( ArrayList <ArrayList<Integer>> allPairs ){
        ArrayList <Integer> unPairs = new ArrayList<Integer>();
        ArrayList <Integer> reversed = new ArrayList<Integer>();
        ArrayList <ArrayList<Integer>> checkPairs = new ArrayList<ArrayList<Integer>>();
        ArrayList <ArrayList<Integer>> copyPairs = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ; i < allPairs.size() ; i++){
            copyPairs.add(allPairs.get(i));
        }
        for (ArrayList <Integer> k : allPairs){
            copyPairs.remove(k);
            reversed = reversed(k);
            if(!(copyPairs.contains(reversed))){
                if(!(checkPairs.contains(reversed))){
                    unPairs.addAll(k);
                }
            }
            else{
                checkPairs.add(k);
            }
        }
        return unPairs;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(ArrayCouples(new int[] {5,4,6,7,7,6,4,5}));
    }
}