import java.util.*;
import java.io.*;

class Main {

    public static String MatrixSpiral(String[] strArr) {
        // code goes here
        int xSize = 0;
        int ySize = 0;
        xSize = strArr.length;
        ySize = strArr[0].replace("[","").replace("]","").replace(" ","").split(",").length;

        int[][] numArr = new int[xSize][ySize];
        for (int i = 0; i < xSize; i++) {
            strArr[i] = strArr[i].replace("[","").replace("]","").replace(" ","");
            String[] newArr = strArr[i].split(",");

            for (int k = 0; k < ySize; k++) {
                numArr[i][k] = Integer.parseInt(newArr[k]);
            }
        }

        int direction = 0;
        int top = 0, bottom = xSize - 1, left = 0, right = ySize - 1;
        String result = "";

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    if (result.length() == 0) {
                        result += numArr[top][i];
                    } else {
                        result += "," + numArr[top][i];
                    }
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    result += "," + numArr[i][right];
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    result += "," + numArr[bottom][i];
                }
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    result += "," + numArr[i][left];
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(MatrixSpiral(s.nextLine()));
    }
}