package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        int answer = 1;
        for(int y = 0 ; y < N ; y++){
            for(int x = 0 ; x < M ; x++){
                answer = Math.max(answer, solution(y, x));
            }
        }

        System.out.println(answer);
    }


    private static int solution(int y, int x) {
        int idx = 1;
        int answer = 1;
        while (check(y, x, idx)) {
            if (validate(y, x, idx))
                answer = idx+1;
            idx++;
        }
        return answer * answer;
    }

    private static boolean validate(int y, int x, int idx) {
        return arr[y][x] == arr[y+idx][x+idx]
                && arr[y+idx][x] == arr[y][x+idx]
                && arr[y][x] == arr[y][x+idx];
    }

    private static boolean check(int y, int x, int idx) {
        return y + idx < N && x + idx < M;
    }

}
