package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());;
        for(int i = 0 ; i < N ; i++){
            int key = Integer.parseInt(st.nextToken());
            map.putIfAbsent(key, 0);
            map.put(key, map.get(key) + 1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i< M ; i++){
            int key = Integer.parseInt(st.nextToken());
            if(map.get(key) == null){
                sb.append(0).append(" ");
                continue;
            }
            sb.append(map.get(key)).append(" ");
        }
        System.out.println(sb.toString());
    }
}