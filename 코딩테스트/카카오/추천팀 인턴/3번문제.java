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
     * Complete the 'taxiDriver' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER_ARRAY pickup
     *  2. LONG_INTEGER_ARRAY drop
     *  3. INTEGER_ARRAY tip
     */

    static List<Information> list;
    static long[] memo;
    public static long taxiDriver(List<Long> pickup, List<Long> drop, List<Integer> tip) {
    // Write your code here     
        list = new ArrayList<>();
        for(int i = 0 ; i < pickup.size() ; i++){
            list.add(new Information(pickup.get(i), drop.get(i), tip.get(i)));
        }
        list.sort(Comparator.comparing(Information::getPickup)
                    .thenComparing(Information::getDrop));
        memo = new long[list.size()];
        long maxVal = 0;
        for(int i = 0 ; i < list.size() ; i++){
            maxVal = Math.max(maxVal, dfs(i));
        }
        return maxVal;
    }
    
    private static long dfs(int idx){
        if(idx == list.size()-1){
            return list.get(idx).drop - list.get(idx).pickup + list.get(idx).tip;
        }
        
        if(memo[idx] != 0){
            return memo[idx];
        }
        
        long cost = list.get(idx).drop - list.get(idx).pickup + list.get(idx).tip;
        for(int i = idx+1; i < list.size() ; i++){
            if(list.get(idx).drop > list.get(i).pickup)
                continue;
            memo[idx] = Math.max(memo[idx], dfs(i) + cost);
        }
        if(memo[idx] == 0)
            memo[idx] = cost;
        
        return memo[idx];
    }
    
    static class Information{
        long pickup, drop;
        int tip;
        public Information(long pickup, long drop, int tip){
            this.pickup = pickup;
            this.drop = drop;
            this.tip = tip;
        }
        
        public long getPickup(){
            return pickup;
        }
        public long getDrop(){
            return drop;
        }
    }

}
public class Solution {