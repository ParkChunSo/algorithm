package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        boolean[][] memo = palindrome(arr);

        int M = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            String[] s1 = sc.nextLine().split(" ");
            int start = Integer.parseInt(s1[0]) - 1;
            int end = Integer.parseInt(s1[1]) - 1;

            if (memo[start][end])
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean[][] palindrome(int[] arr) {
        int N = arr.length;
        boolean[][] memo = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            memo[i][i] = true;
        }
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1])
                memo[i][i + 1] = true;
        }
        for (int length = 3; length <= N; length++) {
            for (int idx = 0; idx <= N - length; idx++) {
                int next = idx + length - 1;
                if (arr[idx] == arr[next]
                        && memo[idx + 1][next - 1])
                    memo[idx][next] = true;
            }
        }
        return memo;
    }
}