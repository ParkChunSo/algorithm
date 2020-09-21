package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static Pair shark;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    map[i][j] = 0;
                    shark = new Pair(i, j);
                }
            }
        }
        int sharkSize = 2, sharkEatCnt = 0;
        while(true){
            Pair fish = findFish(shark, sharkSize);
            if(fish == null)
                break;
            map[fish.y][fish.x] = 0;
            shark = fish;
            sharkEatCnt++;
            if(sharkEatCnt == sharkSize){
                sharkEatCnt = 0;
                sharkSize++;
            }
        }
        System.out.println(distance);
    }

    static int distance = 0;
    private static Pair findFish(Pair shark, int sharkSize){
        List<Pair> answer = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        Queue<Pair> queue = new LinkedList<>();
        visited[shark.y][shark.x] = true;
        queue.offer(shark);

        int d = 0;
        boolean found = false;
        while(!queue.isEmpty() && !found){
            d++;
            int size = queue.size();
            for(int k = 0 ; k < size ; k++){
                Pair pair = queue.poll();
                for(int i = 0 ; i < dy.length ; i++){
                    int ny = pair.y + dy[i];
                    int nx = pair.x + dx[i];
                    if(check(ny, nx, sharkSize, visited)){
                        if(map[ny][nx] != 0 && map[ny][nx] < sharkSize){
                            answer.add(new Pair(ny, nx));
                            found = true;
                        }
                        visited[ny][nx] = true;
                        queue.offer(new Pair(ny, nx));
                    }
                }
            }
        }

        if(answer.isEmpty())
            return null;

        distance += d;
        answer.sort(Comparator.comparing(Pair::getY).thenComparing(Pair::getX));
        return answer.get(0);
    }
    private static boolean check(int y, int x, int sharkSize, boolean[][] visited){
        return y < N && y >=0
                && x < N && x >= 0
                && map[y][x] <= sharkSize
                && !visited[y][x];
    }

    public static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
