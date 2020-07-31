package com.company;

import java.util.Scanner;

public class Main {
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        dp = new int[K+1][N+1];
        System.out.println(solution(K, N));
    }

    // dp[k][n] = 시그마 i는 1부터 n-1까지 dp[k-1][n-i]
    // dp[1][n] = 1;
    public static int solution(int k, int n){
        if(k == 1)
            return 1;
        if(dp[k][n] != 0)
            return dp[k][n];

        for(int i = 0 ; i <= n ; i++){
            dp[k][n] += solution(k-1, n-i) % 1000000000;
        }

        return dp[k][n];
    }
}
