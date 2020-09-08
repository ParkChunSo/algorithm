package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int Y, X, T;
    static int[][] origin;
    static int[][] map;
    static Tmp[] cal;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        origin = new int[Y + 1][X + 1];
        map = new int[Y + 1][X + 1];
        for (int i = 1; i <= Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= X; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cal = new Tmp[T];
        visited = new boolean[T];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            cal[i] = new Tmp(r, c, s);
        }
        br.close();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < T; i++) {
            visited[i] = true;
            copy();
            answer = Math.min(answer, solution(i, 1));
            visited[i] = false;
        }
        System.out.println(answer);
    }
    private static void copy(){
        for(int i = 1 ; i <= Y ; i++){
            for(int j = 1; j <= X ; j++){
                map[i][j] = origin[i][j];
            }
        }
    }

    private static int solution(int idx, int cnt) {
        cycle(cal[idx].r, cal[idx].c, cal[idx].s);
        if (cnt == T) {
            return sum();
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < T; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            answer = Math.min(answer, solution(i, cnt + 1));
            visited[i] = false;
        }

        return answer;
    }

    private static void cycle(int r, int c, int s) {
        int startY = r - s;
        int startX = c - s;
        int endY = r + s;
        int endX = c + s;
        while (startY != endY && startX != endX) {
            int leftTop = map[startY][startX];
            int rightTop = map[startY][endX];
            int leftBot = map[endY][startX];
            int rightBot = map[endY][endX];
            // 윗쪽
            int tmp;
            for(int x = endX ; x > startX ; x--){
                map[startY][x] = map[startY][x-1];
            }
            //오른쪽
            for(int y = endY ; y > startY ; y--){
                map[y][endX] = map[y-1][endX];
            }
            //아래
            for(int x = startX ; x < endX ; x++){
                map[endY][x] = map[endY][x+1];
            }
            //왼쪽
            for(int y = startY ; y < endY ; y++){
                map[y][startX] = map[y+1][startX];
            }
            map[startY][startX+1] = leftTop;
            map[startY+1][endX] = rightTop;
            map[endY][endX-1] = rightBot;
            map[endY-1][startX] = leftBot;

            startY++;
            startX++;
            endX--;
            endY--;
        }
        print();
    }

    private static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= Y ; i ++){
            for(int j = 1 ; j <= X ; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int sum() {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= Y; i++) {
            int sum = 0;
            for (int j = 1; j <= X; j++) {
                sum += map[i][j];
            }
            answer = Math.min(answer, sum);
        }
        return answer;
    }

    static class Tmp {
        int r;
        int c;
        int s;

        public Tmp(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}
