import java.util.*;

class Main {
    public static int sum = 0 , count = 0 ;
    public static String out  ;
    public static void main(String[] args) {
        String[] strArr = {"ace","jack"};
                System.out.println(BlackJackHighest(strArr));
    }

    public static String BlackJackHighest(String[] strArr){
        String[] cardArr = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten","ace","jack", "queen", "king"};
        List<String> card = new ArrayList<String>(Arrays.asList(cardArr));
        List<String> cards = new ArrayList<String>(Arrays.asList(strArr));
        //System.out.println(hashMapCreater(card));
        HashMap<String,Integer> cardSet = hashMapCreater(card );
        result(cards,cardSet);

        if(sum < 21 ) return "below " + out; //String.format() ?
        else if (sum > 21 ) return "above " + out;
        else return "blackjack " + out;
    }
    public static HashMap<String,Integer> hashMapCreater(List<String> card ){
        HashMap<String,Integer> cardSet = new HashMap<String,Integer>();
        int i = 1;
        for(String a : card ){
            i++;
            if(card.indexOf(a) >= 10 ) i = 10;
            cardSet.put(a,i);
        }
        return cardSet;
    }
    public static void result(List<String> strArr ,HashMap<String,Integer> cardSet){
        int max = 0 , temp = 0;
        for(String n : strArr ){
            if(n.equals("ace")) count++;
            sum += cardSet.get(n);
        }
        List<String> newArr = strArr;
        int j ;
        if(sum > 21 && count > 0){
            sum -= 10 * count;
            for(j = 0 ; j < count ; j++){
                newArr.remove("ace");
            }
        }

        for(String b : newArr){
            temp = cardSet.get(b);
            if(temp > max) {
                max = temp;
                out = b ;
            }
        }
    }

}