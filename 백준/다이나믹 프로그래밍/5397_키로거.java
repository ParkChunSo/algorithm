package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            LinkedList<Character> list = new LinkedList<>();
            int offset = 0;
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '<') {
                    offset = offset > 0 ? offset - 1 : 0;
                } else if (str.charAt(i) == '>') {
                    offset = offset < list.size() ? offset + 1 : offset;
                } else if (str.charAt(i) == '-') {
                    if(offset == 0)
                        continue;
                    if (offset == list.size()) {
                        offset--;
                    }
                    list.remove(offset);
                } else {
                    if(offset == str.length()){
                        list.add(str.charAt(i));
                        offset++;
                        continue;
                    }
                    list.add(offset, str.charAt(i));
                    offset++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char c : list)
                sb.append(c);
            System.out.println(sb.toString());
        }
    }
}