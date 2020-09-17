package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = solution();
        System.out.println(answer);
    }
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    private static int solution(){
        Queue<Pair> queue = new LinkedList<>();
        Queue<Pair> nextQueue = new LinkedList<>();
        queue.offer(new Pair(0, 0));

        int cnt = 0;
        while(!queue.isEmpty() || !nextQueue.isEmpty()){
            Pair poll = queue.poll();
            if(poll.y == N-1 && poll.x == M-1)
                break;

            for(int i = 0 ; i < dx.length ; i++){
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];

                if(checkValidXY(ny, nx, visited)){
                    visited[ny][nx] = true;
                    if(map[ny][nx] == 0){
                        queue.offer(new Pair(ny, nx));
                    }else{
                        nextQueue.offer(new Pair(ny, nx));
                    }
                }
            }
            if(queue.isEmpty()){
                queue.addAll(nextQueue);
                nextQueue.clear();
                cnt++;
            }
        }

        return cnt;
    }
    private static boolean checkValidXY(int y, int x, boolean[][] visited){
        return y < N && y >=0
                && x < M && x >= 0
                && !visited[y][x];
    }
    public static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
