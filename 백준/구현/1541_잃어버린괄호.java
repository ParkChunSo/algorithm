package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer> nums = new ArrayList<>();
    private static List<Character> operators = new ArrayList<>();

    private static int answer = 0;

    // +이면 그냥 더하고 - 이면서 다음 연산자가 +이면 빼야하는 괄호(더함)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        split(br.readLine());

        answer = nums.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '+') {
                answer += nums.get(i + 1);
            } else if (i + 1 < operators.size() && operators.get(i + 1) == '+') {
                i = takeBracket(i + 1) - 1;
            } else {
                answer -= nums.get(i + 1);
            }
        }
        System.out.println(answer);
    }

    private static int takeBracket(int start) {
        int diff = nums.get(start);
        for (int i = start; i < operators.size(); i++) {
            if (operators.get(i) != '+') {
                answer -= diff;
                return i;
            }
            diff += nums.get(i + 1);
        }
        answer -= diff;
        return operators.size();
    }

    private static void split(String readLine) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < readLine.length(); i++) {
            if (readLine.charAt(i) == '-' || readLine.charAt(i) == '+') {
                operators.add(readLine.charAt(i));
                nums.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
            } else {
                sb.append(readLine.charAt(i));
            }
        }
        nums.add(Integer.parseInt(sb.toString()));
    }


}
