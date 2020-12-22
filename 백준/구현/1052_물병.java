package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int val = N, cnt = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while(val > 1){
            if(val % 2 != 0)
                queue.offer((int) Math.pow(2, cnt));
            val /= 2;
            cnt++;
        }
        queue.offer((int) Math.pow(2, cnt));

        if(queue.size() <= K){
            System.out.println(0);
            return;
        }

        int answer = 0;
        while(queue.size() > K){
            int poll = queue.poll();
            answer += queue.peek() - poll;
            queue.offer(queue.peek());
            while(queue.size() > 1){
                int i = queue.poll();
                if(i != queue.peek()) {
                    queue.offer(i);
                    break;
                }
                queue.offer(queue.poll() * 2);
            }
        }

        System.out.println(answer);
    }
}
