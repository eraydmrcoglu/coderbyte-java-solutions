import java.util.*; 

class Main {

  public static int KnightJumps(String str) {
        int[][] moves = new int[][]{{2,1},{2,-1},{1,2},{1,-2},{-2,1},{-2,-1},{-1,2},{-1,-2}};
        List<Integer> knight_position = new ArrayList<Integer>(2);
        for (int i = 0 ; i < str.length() ; i++) {
            if( Character.isDigit(str.charAt(i))) {
                knight_position.add(Integer.parseInt(String.valueOf(str.charAt(i))));
            }
        }
        int count = 0;
        int x,y ;

        for(int i = 0 ; i < moves.length ; i++){
            x = knight_position.get(0) + moves[i][0];
            y = knight_position.get(1) + moves[i][1];

            if ( 0< x && x <= 8 && 0 < y && y <= 8) { 
                count++;
            }
        }
        return count;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(KnightJumps(s.nextLine())); 
  }

}