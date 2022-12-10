import java.util.*;
import java.io.*;

class Main {

    private static final String IMPOSSIBLE = "impossible";

    public static String GasStation(String[] strArr) {

        int circuitSize = strArr.length-1;
        int[] gas = new int[circuitSize];
        int[] costs = new int[circuitSize];
        
        for (int i = 1; i <= circuitSize; i++) {

            String[] gasAndCosts = strArr[i].split(":");
            gas[i-1] = Integer.parseInt(gasAndCosts[0]);
            costs[i-1] = Integer.parseInt(gasAndCosts[1]);
        }

        for (int station = 0; station < circuitSize; station++) {

            String startIndex = getStartIndex(gas,costs,station);
            if (!IMPOSSIBLE.equals(startIndex))
               return startIndex;
        }
        return IMPOSSIBLE;
    }

    private static String getStartIndex(int[] gas, int[] costs, int[] startStation) {

        int circuitSize = gas.length;
        int nextStation = startStation < (circuitSize-1) ? startStation+1:0;
        int currentStation = startStation;
        int tank = 0;

        for (int i = 0; i < circuitSize; i++) {
            tank = tank - costs[currentStation]+gas[currentStation];

            if (tank < 0) 
               return IMPOSSIBLE;
            if (i == circuitSize-1)
               return String.valueOf(startStation+1);
            
            nextStation = nextStation < (circuitSize-1) ? nextStation+1:0;
            currentStation = currentStation < (circuitSize-1) ? currentStation+1:0;
        }
        return IMPOSSIBLE;
    }
    
    public static void main (String[] args) {
        //keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));
    }
}
