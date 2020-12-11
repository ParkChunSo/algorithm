package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] price;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        price = new int[N][N];
        visited = new boolean[N];
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j< N ; j++){
                price[i][j] = s.charAt(j) - '0';
            }
        }

        visited[0] = true;
        System.out.println(solution(0, 0));
    }


    private static int solution(int src, int val){
        int answer = 0;
        boolean flag = false;
        for(int dest = 1 ; dest < N ; dest++){
            if(visited[dest] || price[src][dest] < val || src == dest){
                continue;
            }
            flag = true;
            visited[dest] = true;
            answer = Math.max(answer, solution(dest, price[src][dest]) + 1);
            visited[dest] = false;
        }
        if(!flag)
            return 1;
        return answer;
    }
}
