package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static final String PUSH = "push";
    public static final String POP = "pop";
    public static final String SIZE = "size";
    public static final String EMPTY = "empty";
    public static final String TOP = "top";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        while(N > 0){
            String[] s = sc.nextLine().split(" ");
            switch (s[0]){
                case PUSH:
                    stack.push(Integer.parseInt(s[1]));
                    break;

                case POP:
                    if(stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.pop());
                    break;

                case SIZE:
                    System.out.println(stack.size());
                    break;

                case EMPTY:
                    if(stack.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;

                case TOP:
                    if(stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.peek());
                    break;
            }
            N--;
        }
    }
}
