package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    private static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            if(s.equals("*"))
                break;
            int idx = 0;
            boolean flag = true;
            while(++idx < s.length()){
                initList();
                if(!isSurprise(idx, s)){
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println(s+ " is surprising.");
            else
                System.out.println(s+ " is NOT surprising.");
        }

    }

    private static void initList() {
        list = new ArrayList<>();
        for(int i = 0 ; i < 26 ; i++){
            list.add(new ArrayList<>());
        }
    }

    private static boolean isSurprise(int idx, String s){
        for(int i = 0 ; i <s.length()-idx ; i++){
            int c1 = s.charAt(i) - 'A';
            int c2 = s.charAt(i + idx) - 'A';
            if(list.get(c1).contains(c2))
                return false;
            list.get(c1).add(c2);
        }
        return true;
    }
}
