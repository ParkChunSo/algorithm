package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<People> queue = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            queue.offer(new People(i, height, weight));
        }
        int[] rateArr = new int[N];
        People before = queue.poll();
        rateArr[before.idx] = 1;
        int rate = 2;
        while(!queue.isEmpty()){
            People next = queue.poll();
            if(next.height < before.height && next.weight < before.weight){
                rateArr[next.idx] = rate;
                before = next;
            }else {
                rateArr[next.idx] = rateArr[before.idx];
            }
            rate++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : rateArr){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static class People implements Comparable<People> {
        int idx;
        int height;
        int weight;

        public People(int idx, int height, int weight) {
            this.idx = idx;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(People next) {
            if(next.height > this.height && next.weight > this.weight){
                return 1;
            }else if(next.height < this.height && next.weight < this.weight){
                return -1;
            }else {
                return 0;
            }
        }
    }
}
