import java.util.*;

public class Main {
    static int n, trainLength;
    static int[] train;
    static int[][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        train = new int[n];
        for(int i = 0 ; i < n ; i++)
            train[i] = sc.nextInt();
        trainLength = sc.nextInt();

        memo = new int[4][n];
        System.out.println(dp(3, 0));
    }

    public static int dp(int cnt, int idx){
        if(memo[cnt][idx] != 0)
            return memo[cnt][idx];

        int maxIndex = n - cnt * trainLength;
        int maxValue = -1;
        if(cnt == 1){
            for(int i = idx ; i <= maxIndex ; i++){
                maxValue = Math.max(maxValue, sum(i));
            }
        }else {
            for (int i = idx; i <= maxIndex; i++) {
                maxValue = Math.max(maxValue, dp(cnt - 1, i + trainLength) + sum(i));
            }
        }

        return memo[cnt][idx] = maxValue;
    }

    public static int sum(int idx){
        int sum = 0;
        for(int i = idx ; i < idx + trainLength ; i++){
            sum += train[i];
        }
        return sum;
    }
}