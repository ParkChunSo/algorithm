package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static PriorityQueue<Integer> craneQueue, boxQueue;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N][2];
        craneQueue = new PriorityQueue<>();
        boxQueue = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            craneQueue.offer(Integer.parseInt(st.nextToken()));
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxQueue.offer(Integer.parseInt(st.nextToken()));
        }
        br.close();

        int craneWeight = craneQueue.poll(), idx = 0;
        memo[idx][0]++;
        while (!boxQueue.isEmpty()) {
            int poll = boxQueue.poll();
            if (poll > craneWeight) {
                if(craneQueue.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                while (poll > craneQueue.peek()) {
                    craneQueue.poll();
                    memo[idx][0]++;
                }
                idx++;
                memo[idx][1]++;

                if(boxQueue.isEmpty()){
                    memo[idx][0] = craneQueue.size();
                }else {
                    craneWeight = craneQueue.poll();
                    memo[idx][0]++;
                }
                continue;
            }

            memo[idx][1]++;
        }


        int answer = 0;
        while (!check()) {
            //크레인 작업장 재배치
            checkCrane();

            //가장 작은 작업량을 가진 작업장이 걸리는 시간
            int minWorkTime = findMinWorkTime();

            //크레인 작업 시작
            work(minWorkTime);
            answer += minWorkTime;
        }

        System.out.println(answer);
    }

    private static boolean check(){
        for(int i = 0 ; i < N ; i++){
            if(memo[i][1] != 0)
                return false;
        }
        return true;
    }

    private static void work(int minute) {
        for(int i = 0 ; i < N ; i++){
            memo[i][1] -= memo[i][0] * minute;
            if(memo[i][1] < 0)
                memo[i][1] = 0;
        }
    }

    private static int findMinWorkTime() {
        int minWorkTime = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i++){
            if(memo[i][0] == 0)
                continue;

            int work = memo[i][1] / memo[i][0];
            if(work < minWorkTime){
                minWorkTime = work;
            }
        }

        if(minWorkTime == 0)
            return 1;

        return minWorkTime;
    }

    //오른쪽 부터(무거운거) 처리할 박스가 없는 크레인을 왼쪽으로 옮김
    //박스의 개수보다 크레인이 많으면 또 내림
    private static void checkCrane() {
        for (int i = N - 1; i > 0; i--) {
            if(memo[i][1] == 0 && memo[i][0] == 0)
                continue;

            if(memo[i][1] == 0){
                memo[i-1][0] += memo[i][0];
                memo[i][0] = 0;
            }

            if(memo[i][0] > memo[i][1]){
                    memo[i-1][0] += memo[i][0] - memo[i][1];
                memo[i][0] -= memo[i][0] - memo[i][1];
            }
        }
    }
}
