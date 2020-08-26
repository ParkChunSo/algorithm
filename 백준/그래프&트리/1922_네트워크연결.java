package com.company;

import java.util.*;

public class Main {
    static int V, E;
    static int[] parent;
    static PriorityQueue<Edge> edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = Integer.parseInt(sc.nextLine());
        E = Integer.parseInt(sc.nextLine());
        parent = new int[V + 1];
        edges = new PriorityQueue<>(Comparator.comparing(Edge::getW));// 가중치가 작은 순으로 저장

        //각 엣지를 저장
        while (E-- > 0) {
            String[] tmp = sc.nextLine().split(" ");
            edges.add(new Edge(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
        }

        //자기 자신의 부모는 자신으로 초기화
        for (int i = 1; i < parent.length; i++)
            parent[i] = i;

        int cost = 0;
        //모든 엣지를 탐색한다.
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if(union(edge.getRes(), edge.getDest())){
                cost += edge.getW();
            }
        }
        System.out.println(cost);
    }

    private static int findParent(int idx) {
        if (parent[idx] == idx)
            return parent[idx];

        return findParent(parent[idx]);
    }

    private static boolean union(int res, int dest) {
        int resRoot = findParent(res);
        int destRoot = findParent(dest);

        //두 부모가 틀리다면 선택 가능한 간선이다.
        if (resRoot == destRoot)
            return false;

        parent[resRoot] = destRoot;
        return true;
    }

    private static class Edge {
        private final int res;
        private final int dest;
        private final int w;

        public Edge(int res, int dest, int w) {
            this.res = res;
            this.dest = dest;
            this.w = w;
        }

        public int getRes() {
            return res;
        }

        public int getDest() {
            return dest;
        }

        public int getW() {
            return w;
        }
    }
}
