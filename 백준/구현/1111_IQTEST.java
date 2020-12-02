package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 1) {
            System.out.println("A");
            return;
        }
        int answer = Integer.MAX_VALUE;
        int a = 0;
        boolean flag = true;
        while (a <= 100) {
            if (isTrue(a)) {
                if (answer != Integer.MAX_VALUE) {
                    flag = false;
                    break;
                }
                answer = (arr[arr.length - 1] * a) + (arr[1] - (arr[0] * a));
            }
            if (isTrue(-a)) {
                if (answer != Integer.MAX_VALUE && a != 0) {
                    flag = false;
                    break;
                }
                answer = (arr[arr.length - 1] * a) + (arr[1] - (arr[0] * a));
            }
            a++;
        }
        if (!flag) {
            System.out.println("A");
        } else if (answer == Integer.MAX_VALUE) {
            System.out.println("B");
        } else
            System.out.println(answer);
    }

    private static boolean isTrue(int a) {
        int b = arr[1] - (arr[0] * a);
        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i] * a) + b != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
