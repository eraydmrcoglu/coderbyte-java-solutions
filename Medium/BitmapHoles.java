import java.util.; 
import java.io.;

class Main {
  public static String BitmapHoles(String[] strArr) {
    ArrayList<ArrayList<Integer>> index = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<String>> mat = new ArrayList<ArrayList<String>>();
    int holes = 0;
    boolean checker;

    for(int i = 0; i < strArr.length; i++){
      mat.add(new ArrayList<String>(Arrays.asList(strArr[i].split(""))));
      for(int j = 0; j < strArr[i].length(); j++){
        if(mat.get(i).get(j).equals("0")) {
          index.add(new ArrayList<Integer>(Arrays.asList(i,j)));
        }
      }
    }

    for(int c = 0; c < index.size(); c++){
      checker = false;
      for(int k = c+1; k < index.size(); k++){
        if(index.get(k).get(0) == index.get(c).get(0)+1 && 
        index.get(k).get(1) == index.get(c).get(1) || 
        index.get(k).get(0) == index.get(c).get(0) && 
        index.get(k).get(1) == index.get(c).get(1) + 1)
          checker = true;
}
      if(checker == false) holes++;
    }
    return String.valueOf(holes);
  }
  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(BitmapHoles(s.nextLine())); 
  }
}