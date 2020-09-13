package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        N %= M;
        if(N == 0) {
            System.out.println(0);
            return;
        }

        int tmp = 0, cnt = 0;
        while(tmp < M){
            tmp += N;
            cnt++;
        }

        int answer = N * (cnt - 1);
        System.out.println(answer);
    }
}
