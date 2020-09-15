package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H;
    static int[][] map;
    static int[][][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        memo = new int[K+1][H][W];
        map = new int[H][W];
        visited = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = solution(0, 0, 0, K);
        if (answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);

    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] horseMoveY = {1, -1, -2, -2, -1, 1, 2, 2};
    static int[] horseMoveX = {2, 2, 1, -1, -2, -2, -1, 1};
    static boolean[][] visited;

    private static int solution(int y, int x, int total, int k) {
        if (y == H - 1 && x == W - 1) {
            return total;
        }

        if(memo[k][y][x] != 0)
            return memo[k][y][x];

        memo[k][y][x] = Integer.MAX_VALUE;
        if (k > 0) {
            for (int n = 0; n < horseMoveY.length; n++) {
                if (!checkHorseMove(y, x, n))
                    continue;
                int newY = y + horseMoveY[n];
                int newX = x + horseMoveX[n];
                visited[newY][newX] = true;
                memo[k][y][x] = Math.min(memo[k][y][x], solution(newY, newX, total + 1, k - 1));
                visited[newY][newX] = false;
            }
        }

        for (int n = 0; n < dy.length; n++) {
            int newY = y + dy[n];
            int newX = x + dx[n];

            if (!checkGeneralMove(newY, newX))
                continue;
            visited[newY][newX] = true;
            memo[k][y][x] = Math.min(memo[k][y][x], solution(newY, newX, total + 1, k));
            visited[newY][newX] = false;
        }

        return memo[k][y][x];
    }

    private static boolean checkHorseMove(int y, int x, int idx) {
        int newY = y + horseMoveY[idx];
        int newX = x + horseMoveX[idx];
        if (!checkGeneralMove(newY, newX))
            return false;
        if (idx == 0 || idx == 1) {
            return map[y][x + 1] != 1;
        } else if (idx == 2 || idx == 3) {
            return map[y - 1][x] != 1;
        } else if (idx == 4 || idx == 5) {
            return map[y][x - 1] != 1;
        } else {
            return map[y + 1][x] != 1;
        }
    }

    private static boolean checkGeneralMove(int y, int x) {
        return y < H && y >= 0
                && x < W && x >= 0
                && map[y][x] != 1
                && !visited[y][x];
    }
}
