package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;
    static boolean[][] ramp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0 ; k < N ; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        ramp = new boolean[N][N];
        for(int r = 0 ; r < N ; r++){
            if(checkRow(r))
                answer++;
        }

        ramp = new boolean[N][N];
        for(int c = 0 ; c < N ; c++){
            if(checkColumn(c))
                answer++;
        }

        System.out.println(answer);
    }

    private static boolean checkColumn(int c){
        int idx = 0;
        while(idx < N-1){
            if(map[idx][c] == map[idx+1][c]){
                idx++;
                continue;
            }

            if(!checkColumnRamp(idx, c))
                return false;
            idx++;
        }
        return true;
    }

    private static boolean checkColumnRamp(int idx, int c) {
        int diff = map[idx][c] - map[idx + 1][c];
        if(Math.abs(diff) != 1)
            return false;

        if(diff == 1)
            return conditionByColumnRightRamp(idx, c);
        else
            return conditionByColumnLeftRamp(idx, c);
    }

    private static boolean conditionByColumnRightRamp(int idx, int c) {
        if(!(idx + L < N))
            return false;

        if(L == 1 && ramp[idx+1][c])
            return false;

        for(int i = idx+1 ; i < idx+L ; i++){
            if(map[i][c] != map[i+1][c] || ramp[i][c])
                return false;
            ramp[i][c] = true;
        }
        ramp[idx+L][c] = true;
        return true;
    }

    private static boolean conditionByColumnLeftRamp(int idx, int c) {
        if(idx - L + 1 < 0)
            return false;
        if(L == 1 && ramp[idx][c])
            return false;

        for(int i = idx - L + 1 ; i < idx ; i++){
            if(map[i][c] != map[i+1][c] || ramp[i][c])
                return false;
            ramp[i][c] = true;
        }
        ramp[idx][c] = true;
        return true;
    }

    private static boolean checkRow(int r){
        int idx = 0;
        while(idx < N-1){
            if(map[r][idx] == map[r][idx+1]){
                idx++;
                continue;
            }

            if(!checkRowRamp(r, idx))
                return false;
            idx++;
        }
        return true;
    }

    private static boolean checkRowRamp(int r, int idx){
        int diff = map[r][idx] - map[r][idx + 1];
        if(Math.abs(diff) != 1)
            return false;

        if(diff == 1)
            return conditionByRowRightRamp(r, idx);
        else
            return conditionByRowLeftRamp(r, idx);
    }

    private static boolean conditionByRowRightRamp(int r, int idx){
        if(!(idx + L < N))
            return false;

        if(L == 1 && ramp[r][idx+1])
            return false;

        for(int i = idx+1 ; i < idx+L ; i++){
            if(map[r][i] != map[r][i+1] || ramp[r][i])
                return false;
            ramp[r][i] = true;
        }
        ramp[r][idx+L] = true;
        return true;
    }

    private static boolean conditionByRowLeftRamp(int r, int idx){
        if(idx - L + 1 < 0)
            return false;

        if(L == 1 && ramp[r][idx])
            return false;

        for(int i = idx - L + 1 ; i < idx ; i++){
            if(map[r][i] != map[r][i+1] || ramp[r][i])
                return false;
            ramp[r][i] = true;
        }
        ramp[r][idx] = true;
        return true;
    }
}