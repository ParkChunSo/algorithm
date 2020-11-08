package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] memo, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        memo = new int[K+1];
        arr = new int[N];
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(br.readLine());

        memo[0] = 1;
        for(int i = 0; i < N; i++) {
            for(int j = arr[i]; j <= K; j++) {
                memo[j] += memo[j - arr[i]];
            }
        }
        System.out.println(memo[K]);
    }
}