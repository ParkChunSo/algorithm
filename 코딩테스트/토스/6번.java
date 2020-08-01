package com.company;

import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static final int NONE = 0;
    static final int TABLE = 1;
    static final int SPACE = 2;

    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initMap(sc.nextLine());

        boolean finishMark = false;
        for(int y = 0 ; y < map.length ; y++){
            for(int x = 0 ; x < map[0].length ; x++){
                if(map[y][x] == TABLE){
                    markSpace(y, x);
                    finishMark = true;
                    break;
                }
            }
            if(finishMark)
                break;
        }

        int answer = 0;
        for(int y = 0 ; y < map.length ; y++){
            for(int x = 0 ; x < map[0].length ; x++){
                if(map[y][x] == SPACE)
                    answer++;
            }
        }
        System.out.println(answer);
    }

    //맵초기화
    public static void initMap(String s){
        String[] split = s.split(";");
        int m = split[0].split(" ").length;
        map = new int[split.length][m];
        visited = new boolean[split.length][m];
        for(int i = 0 ; i < split.length ; i++){
            String[] arr = split[i].split(" ");
            for(int j = 0 ; j < arr.length ; j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
    }

    public static void markSpace(int y, int x){
        visited[y][x] = true;
        for(int i = 0 ; i < dy.length ; i++){
            int _y = y + dy[i];
            int _x = x + dx[i];

            if(_y >= 0 && _y < map.length && _x >= 0 && _x < map[0].length && !visited[_y][_x]){
                switch (map[_y][_x]){
                    case NONE:
                        map[_y][_x] = SPACE;
                        break;
                    case TABLE:
                        markSpace(_y, _x);
                        break;
                }
            }
        }
    }
}
/**
 0 0 0 0
 0 1 1 0
 0 0 1 0
 0 0 0 0
 **/