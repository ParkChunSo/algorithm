package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static Queue<Pair> queue;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        queue = new LinkedList<>();
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    queue.offer(new Pair(i, j));
                }
            }
        }

        int day = -1;
        while(!queue.isEmpty()){
            day++;
            int size = queue.size();
            for(int k = 0 ; k < size ; k++){
                Pair pair = queue.poll();
                for(int i = 0 ; i < dy.length ; i++){
                    int ny = pair.y + dy[i];
                    int nx = pair.x + dx[i];
                    if(check(ny, nx)){
                        map[ny][nx] = 1;
                        queue.offer(new Pair(ny, nx));
                    }
                }
            }
        }

        if(isDone())
            System.out.println(day);
        else
            System.out.println(-1);
    }

    private static boolean check(int y, int x){
        return y < N && y >=0
                && x < M && x >= 0
                && map[y][x] == 0;
    }

    private static boolean isDone(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 0)
                    return false;
            }
        }
        return true;
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
