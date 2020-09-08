package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final int UP = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    static final int RIGHT = 4;

    static int Y, X;
    static int[][] map;
    static List<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new int[Y][X];
        for(int i = 0 ; i < Y ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0 ; k < X ; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                if(map[i][k] != 0 && map[i][k] != 6){
                    list.add(new Point(i, k));
                }
            }
        }

        br.close();
        System.out.println(solution(0));
    }

    private static int solution(int idx){
        if(idx == list.size()){
            return checkCnt();
        }

        Point point = list.get(idx);
        int minVal = Integer.MAX_VALUE;
        if(map[point.y][point.x] == 1 || map[point.y][point.x] == 3 || map[point.y][point.x] == 4){
            mark(idx, UP, map[point.y][point.x], 7);
            minVal = Math.min(minVal, solution(idx+1));
            mark(idx, UP, map[point.y][point.x], 0);

            mark(idx, DOWN, map[point.y][point.x], 7);
            minVal = Math.min(minVal, solution(idx+1));
            mark(idx, DOWN, map[point.y][point.x], 0);

            mark(idx, LEFT, map[point.y][point.x], 7);
            minVal = Math.min(minVal, solution(idx+1));
            mark(idx, LEFT, map[point.y][point.x], 0);

            mark(idx, RIGHT, map[point.y][point.x], 7);
            minVal = Math.min(minVal, solution(idx+1));
            mark(idx, RIGHT, map[point.y][point.x], 0);
        }else if (map[point.y][point.x] == 2){
            mark(idx, UP, map[point.y][point.x], 7);
            minVal = Math.min(minVal, solution(idx+1));
            mark(idx, UP, map[point.y][point.x], 0);

            mark(idx, LEFT, map[point.y][point.x], 7);
            minVal = Math.min(minVal, solution(idx+1));
            mark(idx, LEFT, map[point.y][point.x], 0);
        }else {
            mark(idx, LEFT, map[point.y][point.x], 7);
            minVal = Math.min(minVal, solution(idx+1));
            mark(idx, LEFT, map[point.y][point.x], 0);
        }
        return minVal;
    }

    private static int checkCnt() {
        int cnt = 0;
        for(int i = 0 ; i < Y ; i++){
            for(int k = 0 ; k < X ; k++){
                if(map[i][k] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    private static void mark(int idx, int direc, int cctv, int markingNum){
        Point point = list.get(idx);
        if(cctv == 1 && direc == UP){
            markUp(point.y, point.x, markingNum);
        }else if(cctv == 1 && direc == DOWN){
            markDown(point.y, point.x, markingNum);
        }else if(cctv == 1 && direc == RIGHT){
            markRight(point.y, point.x, markingNum);
        }else if(cctv == 1 && direc == LEFT){
            markLeft(point.y, point.x, markingNum);
        }else if(cctv == 2 && direc == UP){
            markUp(point.y, point.x, markingNum);
            markDown(point.y, point.x, markingNum);
        }else if(cctv == 2 && direc == LEFT){
            markLeft(point.y, point.x, markingNum);
            markRight(point.y, point.x, markingNum);
        }else if(cctv == 3 && direc == UP){
            markUp(point.y, point.x, markingNum);
            markRight(point.y, point.x, markingNum);
        }else if(cctv == 3 && direc == DOWN){
            markDown(point.y, point.x, markingNum);
            markLeft(point.y, point.x, markingNum);
        }else if(cctv == 3 && direc == LEFT){
            markLeft(point.y, point.x, markingNum);
            markUp(point.y, point.x, markingNum);
        }else if(cctv == 3 && direc == RIGHT){
            markRight(point.y, point.x, markingNum);
            markDown(point.y, point.x, markingNum);
        }else if(cctv == 4 && direc == UP){
            markUp(point.y, point.x, markingNum);
            markLeft(point.y, point.x, markingNum);
            markRight(point.y, point.x, markingNum);
        }else if(cctv == 4 && direc == DOWN){
            markDown(point.y, point.x, markingNum);
            markLeft(point.y, point.x, markingNum);
            markRight(point.y, point.x, markingNum);
        }else if(cctv == 4 && direc == LEFT){
            markLeft(point.y, point.x, markingNum);
            markUp(point.y, point.x, markingNum);
            markDown(point.y, point.x, markingNum);
        }else if(cctv == 4 && direc == RIGHT){
            markRight(point.y, point.x, markingNum);
            markUp(point.y, point.x, markingNum);
            markDown(point.y, point.x, markingNum);
        }else {
            markLeft(point.y, point.x, markingNum);
            markRight(point.y, point.x, markingNum);
            markUp(point.y, point.x, markingNum);
            markDown(point.y, point.x, markingNum);
        }
    }

    private static boolean checkVal(int y, int x){
        return y >= 0 && y < Y
                && x >= 0 && x < X;
    }
    private static void markUp(int y, int x, int markingNum){
        for(int i = y-1; i >= 0 ; i--){
            if(map[i][x] != 0 && map[i][x] != 7)
                break;
            if(checkVal(i, x+1) && map[i][x+1] == 7)
                continue;
            if(checkVal(i, x-1) && map[i][x-1] == 7)
                continue;
            map[i][x] = markingNum;
        }
    }
    private static void markDown(int y, int x, int markingNum){
        for(int i = y+1; i < Y ; i++){
            if(map[i][x] != 0 && map[i][x] != 7)
                break;
            if(checkVal(i, x+1) && map[i][x+1] == 7)
                continue;
            if(checkVal(i, x-1) && map[i][x-1] == 7)
                continue;
            map[i][x] = markingNum;
        }
    }
    private static void markLeft(int y, int x, int markingNum){
        for(int i = x-1 ; i >= 0 ; i--){
            if(map[y][i] != 0 && map[y][i] != 7)
                break;
            if(checkVal(y+1, i) && map[y+1][i] == 7)
                continue;
            if(checkVal(y-1, i) && map[y-1][i] == 7)
                continue;
            map[y][i] = markingNum;
        }
    }
    private static void markRight(int y, int x, int markingNum){
        for(int i = x+1 ; i < X ; i++){
            if(map[y][i] != 0 && map[y][i] != 7)
                break;
            if(checkVal(y+1, i) && map[y+1][i] == 7)
                continue;
            if(checkVal(y-1, i) && map[y-1][i] == 7)
                continue;
            map[y][i] = markingNum;
        }
    }

    public static class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
