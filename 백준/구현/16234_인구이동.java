package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map, memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (openBorderline()) {
            answer++;
        }
        System.out.println(answer);
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;
    private static boolean openBorderline() {
        boolean answer = false;
        memo = new int[N][N];
        visited = new boolean[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if(visited[y][x])
                    continue;

                if(markAndMove(y, x)){
                    answer = true;
                }
            }
        }
        return answer;
    }

    private static boolean markAndMove(int y, int x) {
        if(!before(y, x))
            return false;

        Queue<Pair> moveQueue = new LinkedList<>();
        int sum = 0;

        Queue<Pair> markQueue = new LinkedList<>();
        markQueue.offer(new Pair(y, x));
        visited[y][x] = true;
        while(!markQueue.isEmpty()){
            Pair poll = markQueue.poll();
            for(int i = 0 ; i < dy.length ; i++){
                int _y = poll.y + dy[i];
                int _x = poll.x + dx[i];
                if(check(_y, _x, map[poll.y][poll.x]) && !visited[_y][_x]) {
                    markQueue.offer(new Pair(_y, _x));
                    visited[_y][_x] = true;
                }
            }

            sum += map[poll.y][poll.x];
            moveQueue.offer(poll);
        }

        sum /= moveQueue.size();
        while(!moveQueue.isEmpty()){
            Pair poll = moveQueue.poll();
            map[poll.y][poll.x] = sum;
        }

        return true;
    }

    private static boolean before(int y, int x){
        for(int i = 0 ; i < dy.length ; i++){
            int _y = y + dy[i];
            int _x = x + dx[i];
            if(check(_y, _x, map[y][x])) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(int y, int x, int val) {
        if (y < 0 || y >= N || x < 0 || x >= N || visited[y][x])
            return false;

        int abs = Math.abs(map[y][x] - val);
        return abs >= L && abs <= R;
    }

    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}