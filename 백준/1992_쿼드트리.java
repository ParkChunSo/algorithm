package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        for(int i = 0 ; i< N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = s.charAt(j) == '1';
            }
        }

        System.out.println(solution(new Pair(0, 0), new Pair(N-1, N-1)));
    }

    private static String solution(Pair start, Pair end){
        if(check(start, end)){
            if(map[start.y][start.x])
                return "1";
            return "0";
        }

        int midY = (start.y + end.y - 1) / 2;
        int midX = (start.x + end.x - 1) / 2;
        StringBuilder sb = new StringBuilder();
        sb.append("(")
                .append(solution(new Pair(start.y, start.x), new Pair(midY, midX)))
                .append(solution(new Pair(start.y, midX+1), new Pair(midY, end.x)))
                .append(solution(new Pair(midY+1, start.x), new Pair(end.y, midX)))
                .append(solution(new Pair(midY+1, midX+1), new Pair(end.y, end.x)))
                .append(")");

        return sb.toString();
    }


    private static boolean check(Pair start, Pair end){
        boolean flag = map[start.y][start.x];
        for(int y = start.y; y <= end.y ; y++){
            for(int x = start.x; x <= end.x ; x++){
                if(flag != map[y][x]){
                    return false;
                }
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
