package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, T, M;
    static List<List<Node>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        for(int i = 0 ; i <= N ; i++){
            list.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < L ; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(src).add(new Node(dest, t, c));
            list.get(dest).add(new Node(src, t, c));
        }
        int answer = solution(1, T, M);
        if(answer != 100000)
            System.out.println(answer);
        else
            System.out.println(-1);
    }

    public static int solution(int idx, int time, int cost){
        if(idx == N)
            return 0;

        int minVal = 100000;
        for(int i = 0 ; i <list.get(idx).size() ; i++){
            Node node = list.get(idx).get(i);
            if(visited[node.idx])
                continue;
            if(node.time > time || node.cost > cost){
                continue;
            }
            visited[node.idx] = true;
            minVal = Math.min(minVal, solution(node.idx, time - node.time, cost - node.cost) + node.cost);
            visited[node.idx] = false;
        }
        return minVal;
    }
    static class Node{
        int idx;
        int time;
        int cost;

        public Node(int idx, int time, int cost) {
            this.idx = idx;
            this.time = time;
            this.cost = cost;
        }
    }
}