package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int DEFAULT_K_CNT = 5;
    static int N, K;
    static String[] arr;
    static char[] alpha;
    static boolean[] memo = new boolean[26];

    private static boolean init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(K < 5) {
            System.out.println(0);
            return false;
        }
        arr = new String[N];
        alpha = new char[K];
        alpha[0] = 'a';
        alpha[1] = 'n';
        alpha[2] = 't';
        alpha[3] = 'i';
        alpha[4] = 'c';
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            arr[i] = s.substring(4, s.length() - 4);
            for(int k = 0 ; k < arr[i].length() ; k++){
                set.add(arr[i].charAt(k));
                memo[arr[i].charAt(k) - 'a'] = true;
            }
        }

        if(set.size() <= K - DEFAULT_K_CNT){
            System.out.println(N);
            return false;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        if(!init())
            return;

        int answer = 0;
        for(int i = 0 ; i < memo.length ; i++){
            if(!memo[i] || checkDefaultChar(i))
                continue;
            alpha[DEFAULT_K_CNT] = (char)('a' + i);
            answer = Math.max(answer, solution(i, DEFAULT_K_CNT+1));
        }
        System.out.println(answer);
    }

    private static int solution(int idx, int depth){
        if(depth == K){
            return match();
        }

        int answer = 0;
        for(int i = idx+1 ; i < memo.length ; i++){
            if(!memo[i] || checkDefaultChar(i)){
                continue;
            }
            alpha[depth] = (char)('a' + i);
            answer = Math.max(answer, solution(i, depth+1));
        }

        return answer;
    }

    private static boolean checkDefaultChar(int i) {
        return i+'a' == 'a' || i+'a' == 'n'
                || i + 'a' == 't' || i + 'a' == 'i'
                || i + 'a' == 'c';
    }

    private static int match(){
        int cnt = 0;
        for(String s : arr){
            boolean flag = true;
            for(int idx = 0 ; idx < s.length() ; idx++) {
                if(!contains(s.charAt(idx))){
                    flag = false;
                    break;
                }
            }
            if(flag)
                cnt++;
        }
        return cnt;
    }

    private static boolean contains(char c){
        for (char value : alpha) {
            if (value == c)
                return true;
        }
        return false;
    }
}