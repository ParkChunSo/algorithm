package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final static int PLUS = 0;
    final static int MINUS = 1;
    final static int MULTIPLE = 2;
    final static int DIVIDE = 3;

    static int N;
    static int[] nums;
    static int[] operations;
    static int[] operationCnt = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        operations = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        operationCnt[PLUS] = Integer.parseInt(st.nextToken());
        operationCnt[MINUS] = Integer.parseInt(st.nextToken());
        operationCnt[MULTIPLE] = Integer.parseInt(st.nextToken());
        operationCnt[DIVIDE] = Integer.parseInt(st.nextToken());

        System.out.println(solutionMax(0));
        System.out.println(solutionMin(0));
    }

    private static int solutionMax(int idx) {
        if (idx == N - 1) {
            return solve();
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            if (operationCnt[i] <= 0) {
                continue;
            }
            operationCnt[i]--;
            operations[idx] = i;
            answer = Math.max(answer, solutionMax(idx + 1));
            operationCnt[i]++;
        }
        return answer;
    }

    private static int solutionMin(int idx) {
        if (idx == N - 1) {
            return solve();
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (operationCnt[i] <= 0) {
                continue;
            }
            operationCnt[i]--;
            operations[idx] = i;
            answer = Math.min(answer, solutionMin(idx + 1));
            operationCnt[i]++;
        }
        return answer;
    }

    private static int solve() {
        int answer = nums[0];
        for (int i = 0; i < N - 1; i++) {
            switch (operations[i]) {
                case PLUS:
                    answer += nums[i + 1];
                    break;
                case MINUS:
                    answer -= nums[i + 1];
                    break;
                case MULTIPLE:
                    answer *= nums[i + 1];
                    break;
                case DIVIDE:
                    answer /= nums[i + 1];
                    break;
            }
        }
        return answer;
    }
}