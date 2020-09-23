package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map = new int[9][9];
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j) - '0';
                if(map[i][j] == 0)
                    list.add(new Pair(i, j));
            }
        }

        boolean solution = solution(0);

        for(int[] m : map){
            System.out.println(Arrays.toString(m));
        }
    }

    private static boolean solution(int idx){
        if(idx == list.size()){
            return true;
        }

        Pair pair = list.get(idx);
        for(int v = 1 ; v <= 9 ; v++){
            if (checkBox(pair.y, pair.x, v)
                    && checkRC(pair.y, pair.x, v)) {
                map[pair.y][pair.x] = v;
                if(solution(idx+1))
                    return true;
                map[pair.y][pair.x] = 0;
            }
        }
        return false;
    }

    private static boolean checkRC(int y, int x, int v) {
        for (int i = 0; i < 9; i++) {
            if (map[i][x] == v
                    || map[y][i] == v)
                return false;
        }
        return true;
    }

    private static boolean checkBox(int y, int x, int v) {
        int ny = y / 3;
        int nx = x / 3;
        for (int i = ny * 3; i < ny + 3; i++) {
            for (int j = nx * 3; j < nx + 3; j++) {
                if (map[i][j] == v)
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
