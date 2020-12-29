package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 마지막날부터 풀 수 있는 문제들을 나열.
    // 가능한 모든 문제를 우선순위 큐에 저장(컵라면 수를 기준)
    // 가장 컵라면을 많이주는 문제를 해결
    private static int N;
    private static List<Problem> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Problem(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        Collections.sort(list);

        int listIdx = 0;
        long answer = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int d = N ; d > 0 ; d--){
            while(listIdx < N && list.get(listIdx).deadline == d) {
                queue.offer(list.get(listIdx).cupNoodle);
                listIdx++;
            }

            if(!queue.isEmpty())
                answer += queue.poll();
        }
        System.out.println(answer);
    }

    private static class Problem implements Comparable<Problem>{
        int deadline;
        long cupNoodle;

        public Problem(int deadline, long cupNoodle) {
            this.deadline = deadline;
            this.cupNoodle = cupNoodle;
        }

        @Override
        public int compareTo(Problem o) {
            if(deadline > o.deadline)
                return -1;
            else
                return 1;
        }
    }
}