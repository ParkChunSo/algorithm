package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String N;
    static boolean[] error = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            error[Integer.parseInt(st.nextToken())] = true;

        int answer = Math.abs(Integer.parseInt(N) - 100);
        if (checkAllError()) {
            System.out.println(Integer.parseInt(N) - 100);
        } else {
            System.out.println(Math.min(answer, dfs(0)));
        }
    }

    private static boolean checkAllError() {
        for (boolean b : error) {
            if (!b)
                return false;
        }

        return true;
    }

    private static int dfs(int idx) {
        if (idx == N.length()) {
            return Math.abs(Integer.parseInt(sb.toString()) - Integer.parseInt(N)) + sb.length();
        }

        int num = N.charAt(idx) - '0';
        int answer = Integer.MAX_VALUE;
        if (error[num]) {
            int tmp = findBigNum(num);
            if (tmp != -1) {
                sb.append(tmp);
                answer = dfs(idx + 1);
                sb.deleteCharAt(sb.length() - 1);
            }

            tmp = findSmallIdx(num);
            if (tmp != -1) {
                sb.append(tmp);
                answer = Math.min(answer, dfs(idx + 1));
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(num);
            answer = dfs(idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        return answer;
    }

    private static int findBigNum(int num) {
        for (int i = num + 1; i < 10; i++) {
            if (!error[i])
                return i;
        }
        return -1;
    }

    private static int findSmallIdx(int num) {
        for (int i = num - 1; i >= 0; i--) {
            if (!error[i])
                return i;
        }
        return -1;
    }
}
