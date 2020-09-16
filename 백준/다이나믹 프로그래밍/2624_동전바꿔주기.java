package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, K;
    static int[] coin, coinCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        coin = new int[K];
        coinCnt = new int[K];
        for(int i = 0 ; i < K ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
            coinCnt[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        answer = solution2(0, 0);
        System.out.println(answer);
    }

    private static int solution2(int idx, int sum){
        if(idx == K){
            if(sum == T)
                return 1;
            return 0;
        }
        int answer = 0;
        for(int cnt = coinCnt[idx]; cnt >= 0 ; cnt--){
            if((coin[idx] * cnt) + sum > T)
                continue;
            answer += solution2(idx+1, sum + (coin[idx] * cnt));
        }
        return answer;
    }

    private static int solution(int idx, int sum){
        if(sum == T)
            return 1;

        int answer = 0;
        for(int i = idx ; i < K ; i++){
            if(coinCnt[i] > 0 && sum+coin[i] <= T){
                coinCnt[i]--;
                answer += solution(i, sum+coin[i]);
                coinCnt[i]++;
            }
        }
        return answer;
    }
}
