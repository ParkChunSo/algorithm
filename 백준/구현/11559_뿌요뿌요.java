package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int ROW = 12, COLUMN = 6;
    static char[][] map = new char[ROW][COLUMN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int r = 0; r < ROW; r++) {
            String s = br.readLine();
            for (int c = 0; c < COLUMN; c++) {
                map[r][c] = s.charAt(c);
            }
        }

        int answer = 0;
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COLUMN; c++) {
                if (map[r][c] == '.')
                    continue;
                if (boom(r, c)) {
                    compactMap();
                    answer++;
                    r = 0;
                    c = -1;
                }
            }
        }
        System.out.println(answer);
    }

    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    private static boolean boom(int r, int c) {
        char character = map[r][c];
        visited = new boolean[ROW][COLUMN];
        Queue<Pair> bfsQ = new LinkedList<>();
        Queue<Pair> queue = new LinkedList<>();
        bfsQ.offer(new Pair(r, c));
        visited[r][c] = true;
        while (!bfsQ.isEmpty()) {
            Pair poll = bfsQ.poll();
            for (int i = 0; i < dy.length; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];
                if (checkValid(ny, nx, character)) {
                    visited[ny][nx] = true;
                    bfsQ.offer(new Pair(ny, nx));
                }
            }
            queue.offer(poll);
        }

        if (queue.size() < 4)
            return false;

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            map[poll.y][poll.x] = '.';
        }
        return true;
    }

    private static boolean checkValid(int ny, int nx, char c) {
        return ny >= 0 && ny < ROW
                && nx >= 0 && nx < COLUMN
                && !visited[ny][nx]
                && map[ny][nx] == c;
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static void compactMap() {
        for(int c = 0 ; c < COLUMN ; c++) {
            int bottom = ROW - 1;
            int top = 0;

            while (bottom > top) {
                if (map[bottom][c] != '.') {
                    bottom--;
                    continue;
                }
                int idx = bottom - 1;
                while (idx >= top) {
                    if (map[idx][c] != '.')
                        break;
                    idx--;
                }
                if(idx == -1)
                    break;

                while (idx >= top) {
                    map[bottom][c] = map[idx][c];
                    map[idx][c] = '.';
                    bottom--;
                    idx--;
                }
            }
        }
    }
}