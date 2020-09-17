package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E;
    static int[][] distance;
    static boolean[] visited;
    static List<Integer> path = new ArrayList<>();
    static List<List<Node>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map.get(src).add(new Node(dest, weight));
            map.get(dest).add(new Node(src, weight));
        }
        distance = new int[N + 1][N + 1];
        dijkstra(1);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int src = Integer.parseInt(st.nextToken());
            path.add(src);
            dijkstra(src);
        }

        int answer = Integer.MAX_VALUE;
        visited = new boolean[path.size()];
        for (int i = 0; i < path.size(); i++) {
            visited[i] = true;
            answer = Math.min(answer, solution(i, 1) + distance[1][path.get(i)]);
            visited[i] = false;
        }
        if(answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    private static int solution(int idx, int cnt) {
        if (cnt == path.size()) {
            return distance[path.get(idx)][N];
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < path.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            answer = Math.min(answer, solution(i, cnt+1) + distance[path.get(idx)][path.get(i)]);
            visited[i] = false;
        }
        return answer;
    }

    private static void dijkstra(int src) {
        boolean[] visited = new boolean[N + 1]; //방문 여부 저장
        Arrays.fill(distance[src], Integer.MAX_VALUE);
        //출발지에서 각 노드들 간 연결된 거리 초기화
        for (Node node : map.get(src)) {
            distance[src][node.d] = node.w;
        }

        visited[src] = true;
        // n-1번 돌리면 된다.
        for (int i = 0; i < N - 1; i++) {
            int minIdx = src;
            int minVal = Integer.MAX_VALUE;
            //방문하지 않은 노드 중 거리가 가장 짧은 노드 찾는다.
            for (int j = 1; j < distance.length; j++) {
                if (!visited[j] && minVal > distance[src][j]) {
                    minIdx = j;
                    minVal = distance[src][j];
                }
            }

            visited[minIdx] = true;
            //선택된 노드와 연결된 노드들 중 자신까지의 거리와 선택된 노드를 거친 거리를 비교
            for (Node node : map.get(minIdx)) {
                if (distance[src][node.d] > node.w + distance[src][minIdx]) {
                    distance[src][node.d] = node.w + distance[src][minIdx];
                }
            }
        }
        distance[src][src] = 0;
        distance[src][0] = 0;
    }

    public static class Node {
        int d;
        int w;

        public Node(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }
}
