import java.util.*;
import java.io.*;

class Main {

    public static String DashInsert(String str) {
        char[] sayilar = str.toCharArray();
        int oncekiSayi = Integer.parseInt(String.valueOf(sayilar[0]));

        StringBuilder res = new StringBuilder(String.valueOf(oncekiSayi));

        for (int i = 1; i < sayilar.length; i++) {
            int sayi = Integer.parseInt(String.valueOf(sayilar[i]));

            if (sayi != 0 && oncekiSayi % 2 == 1 && sayi % 2 == 1) {
                res.append("-");

            }
            res.append(sayi);
            oncekiSayi = sayi;

        }
        return res.toString();

    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(DashInsert(s.nextLine()));
    }

}
