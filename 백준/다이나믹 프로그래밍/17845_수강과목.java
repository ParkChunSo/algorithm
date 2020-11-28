package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] memo;
    static Subject[] subjects;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        subjects = new Subject[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            subjects[i] = new Subject(weight, time);
        }
        memo = new int[N+1];
        for(int i = 0 ; i < subjects.length ; i++){
            for(int t = N ; t >= subjects[i].time ; t--){
                memo[t] = Math.max(memo[t], memo[t-subjects[i].time] + subjects[i].weight);
            }
        }
        System.out.println(memo[N]);
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
