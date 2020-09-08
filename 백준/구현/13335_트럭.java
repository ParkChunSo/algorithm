package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, w, L, currentWeight;
    static Queue<Integer> waitQueue = new LinkedList<>();
    static Queue<Truck> processQueue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            waitQueue.offer(Integer.parseInt(st.nextToken()));

        br.close();

        currentWeight = 0;
        int time = 0;
        while (!waitQueue.isEmpty()) {
            if (L < currentWeight + waitQueue.peek()
                    || processQueue.size() >= w) {
                time += firstSkip(); //제일 처음 다리에 진입한 트럭의 남은길이만큼 모두 이동;
                continue;
            }

            int truckWeight = waitQueue.poll();
            currentWeight += truckWeight;
            processQueue.offer(new Truck(truckWeight, w));
            spendTime();
            time++;
        }

        while (!processQueue.isEmpty()) {
            time += firstSkip();
        }
        System.out.println(time+1);
    }

    private static int firstSkip() {
        Truck first = processQueue.poll();
        currentWeight -= first.weight;

        int size = processQueue.size();
        for(int i = 0 ; i < size ; i++){
            Truck truck = processQueue.poll();
            truck.length -= first.length;
            processQueue.offer(truck);
        }

        return first.length;
    }

    private static void spendTime() {
        int size = processQueue.size();
        for(int i = 0 ; i < size ; i++){
            Truck truck = processQueue.poll();
            truck.length -= 1;
            processQueue.offer(truck);
        }

        if (!processQueue.isEmpty() && processQueue.peek().length == 0) {
            Truck truck = processQueue.poll();
            currentWeight -= truck.weight;
        }
    }

    public static class Truck {
        int weight;
        int length;

        public Truck(int weight, int length) {
            this.weight = weight;
            this.length = length;
        }
    }
}
