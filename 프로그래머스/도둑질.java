package com.company;

class Solution {
    int[][] memo;
    int[] money;

    public int solution(int[] money) {
        if(money.length == 3)
            return Math.max(money[0], Math.max(money[1], money[2]));

        this.money = money;
        this.memo = new int[2][money.length];
        memo[0][money.length-1] = money[money.length-1];
        memo[1][money.length-1] = 0;
        memo[0][money.length-2] = money[money.length-2];
        memo[1][money.length-2] = money[money.length-2];

        return Math.max(solution1(1, 0), solution1(0, 1));
    }

    /**
     * idx번째에서 얻을 수 있는 최대 돈
     */
    private int solution1(int first, int idx){
        if(idx == money.length-1
                || memo[first][idx] != 0) {
            return memo[first][idx];
        }

        int answer = -1;
        for(int i = idx+2 ; i < money.length ; i++){
            answer = Math.max(answer, solution1(first, i) + money[idx]);
        }

        return memo[first][idx] = answer;
    }
}