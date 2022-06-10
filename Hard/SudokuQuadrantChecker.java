import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static ArrayList<Integer[]> quadLocation = new ArrayList<>();
    public static HashSet<Integer> invalids = new HashSet<>();

    public static String sudokuQuadrantChecker(String[] arr) {
        ArrayList<ArrayList<String>>board = buildBoard(arr);
        fillQuadHash();

        for (int i = 0 ; i < board.get(0).size() ; i++) {

            checkRow(board.get(i),i);
        }
        for (int i = 0 ; i < board.get(0).size() ; i++) {
            checkColumn(buildColumn(board, i),i);
        }

        for (int i = 0 ; i < board.get(0).size() ; i++) {
            checkQuadrant(buildQuad(board,i),i);
        }
        if (invalids.isEmpty()) {
            return "legal";
        }
        List<Integer> strArr = invalids.stream().collect(Collectors.toList());
        Collections.sort(strArr);
        return strArr.stream().map(String::valueOf).collect(Collectors.joining(","));
    }
    public static ArrayList<ArrayList<String>> buildBoard(String[] arr) {
        ArrayList<ArrayList<String>> board = new ArrayList<>();
        for (String n : arr) {
            char[] nChar = n.toCharArray();
            ArrayList<String> row = new ArrayList<>();
            for (char c : nChar) {
                if (Character.isDigit(c)) {
                    row.add(Character.toString(c));
                }
                else if (c == 'x') {
                    row.add("x");
                }
            }
            board.add(row);
        }
        return board;
    }
    public static void fillQuadHash() {
        quadLocation.add(new Integer[]{3,3});
        quadLocation.add(new Integer[]{3,6});
        quadLocation.add(new Integer[]{3,9});
        quadLocation.add(new Integer[]{6,3});
        quadLocation.add(new Integer[]{6,6});
        quadLocation.add(new Integer[]{6,9});
        quadLocation.add(new Integer[]{9,3});
        quadLocation.add(new Integer[]{9,6});
        quadLocation.add(new Integer[]{9,9});
    }
    public static ArrayList<String> buildQuad(ArrayList<ArrayList<String>> board,int quadNum){
        int x = quadLocation.get(quadNum)[0];
        int y = quadLocation.get(quadNum)[1];
        ArrayList<String> quad = new ArrayList<>();
        for (int i = x - 3 ; i < x ; i++) {
            for (int j = y -3 ; j < y ; j++) {
                quad.add(board.get(i).get(j));
            }
        }
        return quad;
    }
    public static ArrayList<String> buildColumn(ArrayList<ArrayList<String>> board, int i) {
        ArrayList<String>column= new ArrayList<>();
        for (ArrayList<String> row : board) {
            column.add(row.get(i));
        }
        return column;
    }
    public static int isValid(int x , int y ) {
        int a, b ,loc = 0;
        for (int i = 0 ; i < quadLocation.size() ; i++) {
            a = quadLocation.get(i)[0];
            b = quadLocation.get(i)[1];
            if ( a-3 <= x && x < a && b-3 <= y && y < b) {
                loc = ++i; //compiler ++ order !!!
            }
        }
        return loc;
    }
    public static void checkRow(ArrayList<String> row,int k){

        String a , b ;
        for(int i = 0 ; i < row.size() ; i++){
            for(int j = 0 ; j < row.size() ; j++){
                a = row.get(i);
                b = row.get(j);
                if(a.equals(b) && !a.equals("x") && i != j){
                    //System.out.println(k + " " + j);
                    invalids.add(isValid(k,j));
                }
            }
        }
    }
    public static void checkColumn(ArrayList<String> row,int k){
        String a , b ;
        for(int i = 0 ; i < row.size() ; i++){
            for(int j = 0 ; j < row.size() ; j++){
                a = row.get(i);
                b = row.get(j);
                if(a.equals(b) && !a.equals("x")  && i != j){
                    invalids.add(isValid(j,k));
                }
            }
        }
    }
    public static void checkQuadrant(ArrayList<String> row,int k){
        String a , b ;
        for(int i = 0 ; i < row.size() ; i++){
            for(int j = 0 ; j < row.size() ; j++){
                a = row.get(i);
                b = row.get(j);
                if(a.equals(b) && !a.equals("x")  && i != j){
                    //System.out.println(k + " " + j);
                    invalids.add(k+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        String[] arr = {
                "(1,2,3,4,5,6,7,8,9)",
                "(x,x,x,x,x,x,x,x,x)",
                "(6,x,5,x,3,x,x,4,x)",
                "(2,x,1,1,x,x,x,x,x)",
                "(x,x,x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x,x,9)"};
        String[] arr2 = {
                "(1,1,3,4,5,6,7,8,1)",
                "(x,x,x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x,x,x)",
                "(1,x,x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x,x,x)"};
        String[] arr3 = {"(1,2,3,4,5,6,7,8,9)","(x,x,x,x,x,x,x,x,x)","(6,x,5,x,3,x,x,4,x)","(2,x,1,1,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)"};
        String[] arr4 = {"(1,2,3,4,5,6,7,8,9)","(x,x,x,x,x,x,x,x,x)","(6,x,5,x,3,x,x,4,x)","(2,x,1,5,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,8)"};
        String[] arr5 = {"(1,2,3,4,5,6,7,8,9)","(x,x,x,x,x,x,x,x,x)","(6,x,5,x,3,x,x,4,x)","(2,x,1,5,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,4)","(9,1,2,3,4,5,6,7,8)"};
        String[] arr6 = {"(1,2,3,4,5,6,7,8,9)","(4,5,6,1,2,3,x,x,x)","(7,8,9,x,x,6,x,x,x)","(2,3,4,x,x,x,x,x,x)","(5,6,7,x,x,x,x,x,x)","(8,9,1,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,1)"};
        String[] arr7 = {"(1,2,3,4,5,6,7,8,9)","(x,x,x,x,x,x,x,x,x)","(6,x,5,x,3,x,x,4,x)","(2,x,1,5,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,9)","(9,1,2,3,4,5,6,7,8)"};
        System.out.println(sudokuQuadrantChecker(arr4));
    }

}
