import java.util.*;
import java.io.*;

class Main {

    public static int CountingMinutes(String str) {
        String[] time = str.split("-");

        String[] firstTime = time[0].split(":");
        int firstHour = Integer.parseInt(firstTime[0]);
        int firstMin = extractMin(firstTime[1]);
        String firstPeriod = extractPeriod(firstTime[1]);

        String[] secondTime = time[1].split(":");
        int secondHour = Integer.parseInt(secondTime[0]);
        int secondMin = extractMin(secondTime[1]);
        String secondPeriod = extractPeriod(secondTime[1]);

        if(!firstPeriod.equals(secondPeriod)){
            return (12-firstHour)*60 + (60-firstMin) + (secondHour-1)*60 + secondMin;
        }
        else{
            if((firstHour > secondHour) || ((firstHour == secondHour) && (firstMin > secondMin))){
                return (24-firstHour)*60 + (60-firstMin) + (secondHour-1)*60 + secondMin;
            }
            else{
                return (secondHour-(firstHour+1))*60 + (60-firstMin)+secondMin ;
            }
        }
    }
    public static String extractPeriod(String time){
        String period = "";
        period = time.substring(2);
        return period;

    }
    public static int extractMin(String time){
        String min = "";
        min = time.substring(0,2);
        return Integer.parseInt(min);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(CountingMinutes(s.nextLine()));
    }
}