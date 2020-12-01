package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
//        int answer = main.solution(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
        int answer = main.test(new int[]{2, 5, 3, 8, 1}, 3, 11);
        System.out.println(answer);
    }

    int[] arr;
    int k, t, answer = 0;

    public int test(int[] arr, int k, int t) {
        this.arr = arr;
        this.k = k;
        this.t = t;

        for (int i = 0; i <= arr.length - k; i++) {
            solution(i, arr[i], k - 2);
        }
        return answer;
    }

    private void solution(int idx, int sum, int depth) {
        if (depth < 0 && sum <= t) {
            answer++;
        }

        if (idx == arr.length)
            return;

        for (int i = idx + 1; i < arr.length; i++) {
            if (sum + arr[i] > t)
                continue;
            solution(i, sum + arr[i], depth - 1);
        }
    }
}
