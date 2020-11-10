package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int X;
    static int maxCnt = 0;
    static Cent[] cents = new Cent[4];
    static int[] count = new int[4];
    static int[] tmpCnt = new int[4];
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        cents[0] = new Cent(1, Integer.parseInt(st.nextToken()));
        cents[1] = new Cent(5, Integer.parseInt(st.nextToken()));
        cents[2] = new Cent(10, Integer.parseInt(st.nextToken()));
        cents[3] = new Cent(25, Integer.parseInt(st.nextToken()));

        memo = new int[4][X+1];
        solution(0, X, 0);
        System.out.println(Arrays.toString(count));
    }

    private static int solution(int idx, int remainVal, int cnt) {
        if (remainVal == 0) {
            return cnt;
        }
        if(idx  == 4) {
            return 0;
        }
        if(memo[idx][remainVal] != 0){
            return memo[idx][remainVal];
        }

        for (int i = 0; i < cents[idx].cnt; i++) {
            if(cents[idx].val * i > remainVal)
                continue;
            tmpCnt[idx] = i;
            int val = cents[idx].val * i;
            int result = solution(idx + 1, remainVal - val, cnt + i);
            if(result > maxCnt){
                maxCnt = result;
                count = tmpCnt.clone();
            }
        }
        return memo[idx][remainVal] = maxCnt;
    }

    static class Cent {
        int val, cnt;

        public Cent(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}