import java.util.*;

class Main {
    static List<List<String>> permutations = new ArrayList<>();

    public static int LineOrdering(String[] strArr) {
        // code goes here
        if(strArr.length>10){
            return 0;
        }
        permute(findChar(strArr),0);
        int possibility = 0;
        for(List<String> l : permutations){
            if(relations(l,strArr)) possibility++;
        }

        return possibility;
    }
    static boolean relations(List<String>possible,String arr[]){
        for(String item : arr){
            String posarr[] = new String[2];
            if(item.contains("<")){
                posarr = item.split("<");
                String temp = posarr[0];
                posarr[0] = posarr[1];
                posarr[1] = temp;

            }else{
                posarr = item.split(">");
            }
            if(possible.indexOf(posarr[0]) <= possible.indexOf(posarr[1])){
                return false;
            }
        }
        return true;
    }
    static List<String> findChar(String strArr[]){
        Set<String> chr = new HashSet<>();
        for(String str : strArr){
            if(str.contains("<")){
                chr.addAll(Arrays.asList(str.split("<")));
            }else if(str.contains(">")){
                chr.addAll(Arrays.asList(str.split(">")));
            }
        }
        return new ArrayList<>(chr);
    }

    static void permute(List<String> arr, int k){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            permutations.add(new ArrayList<>(arr));
        }
    }

    public static void main(String args[]){
        System.out.println(LineOrdering(new String[]{"A>B","B>C","A<D"}));
        System.out.println(LineOrdering(new String[] {"A>B","B<R","R<G"}));
    }
}