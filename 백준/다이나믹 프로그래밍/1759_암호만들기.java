package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] chars;
    static StringBuilder answer = new StringBuilder();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);

        int maxIdx = C - L;
        for(int i = 0 ; i <= maxIdx ; i++){
            sb.append(chars[i]);
            solution(i, 1);
            sb.deleteCharAt(sb.length()-1);
        }

        System.out.println(answer.toString());
    }

    public static void solution(int idx, int depth) {
        if (depth == L) {
            if (checkValidation())
                answer.append(sb.toString()).append("\n");
            return;
        }

        for (int i = idx+1; i < chars.length; i++) {
            sb.append(chars[i]);
            solution(i, depth+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    static char[] moum = {'a', 'e', 'i', 'o', 'u'};

    public static boolean checkValidation() {
        int moumCnt = 0;
        for (int i = 0; i < sb.length(); i++) {
            for (int j = 0; j < moum.length; j++) {
                if (moum[j] == sb.charAt(i)) {
                    moumCnt++;
                }
            }
        }
        return moumCnt > 0
                && sb.length() - moumCnt > 1;
    }
}
