package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, T, M;
    static boolean[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new boolean[N][M];
            visited = new boolean[N][M];
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }

            int answer = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (!map[y][x] || visited[y][x])
                        continue;
                    check(y, x);
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    final static int[] dy = {1, -1, 0, 0};
    final static int[] dx = {0, 0, 1, -1};

    private static void check(int y, int x) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(y, x));
        visited[y][x] = true;
        while (!stack.isEmpty()) {
            Pair pop = stack.pop();
            for(int i = 0 ; i < dx.length ; i++){
                int r = pop.y + dy[i];
                int c = pop.x + dx[i];
                if(valid(r, c)) {
                    stack.push(new Pair(r, c));
                    visited[r][c] = true;
                }
            }
        }
    }

    private static boolean valid(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M
                && !visited[y][x] && map[y][x];
    }

    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}