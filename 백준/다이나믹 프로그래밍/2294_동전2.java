package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final static int MAX = 100001;
    static int N, K;
    static int[] arr, memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        memo = new int[K+1];
        Arrays.fill(memo, MAX);
        memo[0] = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = arr[i] ; j <= K ; j++){
                memo[j] = Math.min(memo[j],memo[j - arr[i]] + 1);
            }
        }
        if(memo[K] == MAX)
            System.out.println(-1);
        else
            System.out.println(memo[K]);
    }
}