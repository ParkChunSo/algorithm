package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<List<Integer>> heavier = new ArrayList<>();
    static List<List<Integer>> lighter = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            heavier.add(new ArrayList<>());
            lighter.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            heavier.get(a).add(b);
            lighter.get(b).add(a);
        }

        // dfs로 탐색한 뒤, 각 무게가 (N+1)/2보다 크거나 같으면 정답인 수
        int mid = (N + 1) / 2, answer = 0;
        for (int i = 1; i <= N; i++) {
            int result = Math.max(dfs(heavier, i), dfs(lighter, i));
            if (result >= mid)
                answer++;
        }
        System.out.println(answer);

    }

    private static int dfs(List<List<Integer>> list, int src) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N + 1];
        stack.push(src);
        visited[src] = true;
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            for (int linked : list.get(pop)) {
                if (!visited[linked]) {
                    answer++;
                    visited[linked] = true;
                    stack.push(linked);
                }
            }
        }
        return answer;
    }
}
