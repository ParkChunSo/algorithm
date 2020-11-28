package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] memo;
    static Subject[] subjects;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        subjects = new Subject[K];
        memo = new int[K][N+1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            subjects[i] = new Subject(weight, time);
        }

        int max = 0;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].time > N)
                continue;
            max = Math.max(max, solution(i, N - subjects[i].time) + subjects[i].weight);
        }
        System.out.println(max);
    }

    // i번째 수업을 들었을 때 얻을 수 있는 최대 중요도
    private static int solution(int idx, int time) {
        if (idx == subjects.length)
            return 0;
        if(memo[idx][time] != 0)
            return memo[idx][time];

        for (int i = idx + 1; i < subjects.length; i++) {
            if (subjects[i].time > time)
                continue;
            memo[idx][time] = Math.max(memo[idx][time], solution(i, time - subjects[i].time) + subjects[i].weight);
        }
        return memo[idx][time];
    }

    static class Subject {
        int weight;
        int time;

        public Subject(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}