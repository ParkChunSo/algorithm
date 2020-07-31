package com.company;

import java.util.Scanner;

public class Main {
    static final char RED = 'R';
    static final char GREEN = 'G';
    static final char BLUE = 'B';
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static int N;
    static char[][] map;
    static boolean[][] visitedForNormal;
    static boolean[][] visitedForRG;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new char[N][N];
        visitedForNormal = new boolean[N][N];
        visitedForRG = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int normalAnswer = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (visitedForNormal[y][x])
                    continue;
                solutionForNormal(y, x);
                normalAnswer++;
            }
        }

        int RGAnswer = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (visitedForRG[y][x])
                    continue;
                solutionForRG(y, x);
                RGAnswer++;
            }
        }

        System.out.println(normalAnswer + " " + RGAnswer);

    }

    public static void solutionForNormal(int y, int x) {
        visitedForNormal[y][x] = true;
        for (int i = 0; i < dy.length; i++) {
            int _y = y + dy[i];
            int _x = x + dx[i];
            if (_y >= 0 && _y < N && _x >= 0 && _x < N
                    && !visitedForNormal[_y][_x] && map[y][x] == map[_y][_x]) {
                solutionForNormal(_y, _x);
            }
        }
    }

    public static void solutionForRG(int y, int x) {
        visitedForRG[y][x] = true;
        for (int i = 0; i < dy.length; i++) {
            int _y = y + dy[i];
            int _x = x + dx[i];
            if (_y >= 0 && _y < N && _x >= 0 && _x < N
                    && !visitedForRG[_y][_x] && checkPart(y, x, _y, _x)) {
               solutionForRG(_y, _x);
            }
        }
    }

    public static boolean checkPart(int y, int x, int _y, int _x) {
        return (map[y][x] == BLUE && map[_y][_x] == BLUE)
                || (map[y][x] != BLUE && map[_y][_x] != BLUE);
    }
}
