import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'minCost' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER rows
     *  2. INTEGER cols
     *  3. INTEGER initR
     *  4. INTEGER initC
     *  5. INTEGER finalR
     *  6. INTEGER finalC
     *  7. INTEGER_ARRAY costRows
     *  8. INTEGER_ARRAY costCols
     */

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static int minCost(int rows, int cols, int initR, int initC, int finalR, int finalC, List<Integer> costRows, List<Integer> costCols) {
    // Write your code here
        int costs = 0;
        if(initR < finalR){
            while(initR < finalR){
                costs += costRows.get(initR);
                initR++;
            }
        }else{
            while(initR > finalR){
                costs += costRows.get(finalR);
                finalR++;
            }
        }
        
        if(initC < finalC){
            while(initC < finalC){
                costs += costCols.get(initC);
                initC++;
            }
        }else{
            while(initC > finalC){
                costs += costCols.get(finalC);
                finalC++;
            }
        }
        
        return costs;
    }
}