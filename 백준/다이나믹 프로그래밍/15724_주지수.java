package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        initMap();
        setMap();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            System.out.println(getJujisu(y1, x1, y2, x2));
        }
        br.close();
    }


    private static void initMap() {
        for (int y = 1; y < N; y++) {
            map[y][0] += map[y - 1][0];
        }

        for (int x = 1; x < M; x++) {
            map[0][x] += map[0][x - 1];
        }
    }

    private static void setMap() {
        for (int y = 1; y < N; y++) {
            for (int x = 1; x < M; x++) {
                map[y][x] += map[y - 1][x] + map[y][x - 1] - map[y - 1][x - 1];
            }
        }
    }

    private static int getJujisu(int y1, int x1, int y2, int x2) {
        int result = map[y2][x2];
        if(y1 != 0 && x1 != 0){
            result -= map[y1-1][x2] + map[y2][x1-1] - map[y1-1][x1-1];
        } else if(y1 != 0){
            result -= map[y1-1][x2];
        }else if(x1 != 0){
            result -= map[y2][x1-1];
        }
        return result;
    }
}