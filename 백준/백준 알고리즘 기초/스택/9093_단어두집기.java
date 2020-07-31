package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static final String PUSH = "push";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T > 0){
            System.out.println(switchString(sc.nextLine().split(" ")));
            T--;
        }
    }

    private static String switchString(String[] nextLine) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(String s : nextLine){
            for(int i = 0 ; i < s.length() ; i++)
                stack.push(s.charAt(i));

            while(!stack.isEmpty())
                sb.append(stack.pop());

            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
