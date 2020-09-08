package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String condition;
    static char[][] map;
    static int[][][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        condition = br.readLine();
        String devilRoad = br.readLine();
        String angelRoad = br.readLine();
        br.close();
        N = devilRoad.length();
        map = new char[2][N];
        memo = new int[2][N][condition.length()];
        for (int i = 0; i < N; i++) {
            map[0][i] = devilRoad.charAt(i);
            map[1][i] = angelRoad.charAt(i);
        }
        int result = 0;
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < N; x++) {
                if (condition.charAt(0) == map[y][x])
                    result += solution(y, x, 0);
            }
        }
        System.out.println(result);

    }

    private static int solution(int y, int x, int idx) {
        if (x == N - 1) {
            if (idx != condition.length() - 1)
                return 0;
            return 1;
        }
        if (idx == condition.length() - 1) {
            return 1;
        }

        //시간초과나면 memo -1로 초기화 후 0을 갔는데 길 없는 거로
        if (memo[y][x][idx] != 0)
            return memo[y][x][idx];

        int nextRoad = nextRoad(y);
        for (int i = x + 1; i < N; i++) {
            if (condition.charAt(idx + 1) == map[nextRoad][i]) {
                memo[y][x][idx] += solution(nextRoad, i, idx + 1);
            }
        }

        return memo[y][x][idx];
    }

    private static int nextRoad(int y) {
        return y == 1 ? 0 : 1;
    }
}
