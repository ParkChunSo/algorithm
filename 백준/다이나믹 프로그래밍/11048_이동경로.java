import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = arr[0][0];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(j+1 < m)
                    dp[i][j+1] = Math.max(dp[i][j+1], arr[i][j+1] + dp[i][j]);
                if(i+1 < n)
                    dp[i+1][j] = Math.max(dp[i+1][j],arr[i+1][j] + dp[i][j]);
                if(j+1 < m && i+1 < n)
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], arr[i+1][j+1] + dp[i][j]);
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}