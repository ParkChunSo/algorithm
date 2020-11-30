package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <=N ; i++){
            String s = br.readLine();
            map.put(s, String.valueOf(i));
            map.put(String.valueOf(i), s);
        }
        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            sb.append(map.get(br.readLine())).append('\n');
        }
        System.out.println(sb.toString());
    }


}
