package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static ArrayList<Integer> kcmDec;
    static ArrayList<Integer> ntopiaDec;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        kcmDec = new ArrayList<>();
        ntopiaDec = new ArrayList<>();
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        boolean answer = solution(0, N - 1, 1);
        if(answer)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean solution(int startIdx, int endIdx, int turn) {
        //홀수 하나남거나 고를 수 없을 때
        //짝수(ntopia 차례)이면 kcm이 승리
        if (startIdx >= endIdx) {
            return turn % 2 == 0;
        }

        if (arr[startIdx] % 2 == 0) {
            if (turn % 2 == 0) {
                ntopiaDec.add(arr[startIdx]);
            } else {
                kcmDec.add(arr[startIdx]);
            }
            return solution(startIdx + 1, endIdx, turn + 1);
        } else if (startIdx + 1 <= endIdx
                && (arr[startIdx] + arr[startIdx + 1]) % 2 == 0) {
            if (turn % 2 == 0) {
                ntopiaDec.add(arr[startIdx]);
                ntopiaDec.add(arr[startIdx + 1]);
            } else {
                kcmDec.add(arr[startIdx]);
                kcmDec.add(arr[startIdx + 1]);
            }
            return solution(startIdx + 2, endIdx, turn + 1);
        } else if (arr[endIdx] % 2 == 0) {
            if (turn % 2 == 0) {
                ntopiaDec.add(arr[endIdx]);
            } else {
                kcmDec.add(arr[endIdx]);
            }
            return solution(startIdx, endIdx - 1, turn + 1);
        } else if (endIdx - 1 >= startIdx
                && (arr[endIdx - 1] + arr[endIdx]) % 2 == 0) {
            if (turn % 2 == 0) {
                ntopiaDec.add(arr[endIdx]);
                ntopiaDec.add(arr[endIdx - 1]);
            } else {
                kcmDec.add(arr[endIdx]);
                kcmDec.add(arr[endIdx - 1]);
            }
            return solution(startIdx, endIdx - 2, turn + 1);
        } else {
            return turn % 2 == 0;
        }
    }

}
