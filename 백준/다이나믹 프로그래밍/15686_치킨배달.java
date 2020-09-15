package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Pair> houses;
    static List<Pair> chickens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == 1)
                    houses.add(new Pair(i, j));
                else if(val == 2)
                    chickens.add(new Pair(i, j));
            }
        }

        int answer = Integer.MAX_VALUE;
        int[] choice = new int[M];
        for(int i = 0 ; i <= chickens.size()-M ; i++){
            choice[0] = i;
            answer = Math.min(answer, solution(i, 1, choice));
        }
        System.out.println(answer);
    }

    public static int solution(int idx, int cnt, int[] choice){
        if(cnt == M){
            return chickenDistance(choice);
        }

        int answer = Integer.MAX_VALUE;
        for(int i = idx+1 ; i < chickens.size() ; i++){
            choice[cnt] = i;
            answer = Math.min(answer, solution(i, cnt+1, choice));
            choice[cnt] = -1;
        }

        return answer;
    }

    private static int chickenDistance(int[] choice){
        int answer = 0;
        for(Pair house : houses){
            int min = Integer.MAX_VALUE;
            for(int c : choice){
                int val = Math.abs(chickens.get(c).y - house.y)
                        + Math.abs(chickens.get(c).x - house.x);
                min = Math.min(min, val);
            }
            answer += min;
        }
        return answer;
    }

    public static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
