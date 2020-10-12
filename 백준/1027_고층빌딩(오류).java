package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] memo;
    static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        memo = new boolean[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        int maxSee = 0;
        for (int a = 0; a < N - 1; a++) {
            int val = 0;
            for (int b = a + 1; b < N; b++) {
                boolean isSaw = true;
                for (int i = a + 1; i < b; i++) {
                    if (check(a, b, i)) {
                        isSaw = false;
                        break;
                    }
                }
                if(isSaw){
                    memo[a][b] = true;
                    memo[b][a] = true;
                    val++;
                }
            }
            for(int i = 0 ; i < a ; i++){
                if(memo[i][a]){
                    val++;
                }
            }
            if(val > maxSee)
                maxSee = val;
        }
        System.out.println(maxSee);
    }

    private static boolean check(int a, int b, int i){
        double gi = (double) ((buildings[b] - buildings[a]) / (b - a));
        return gi * (i - a) <= buildings[i] - buildings[a];
    }

}