public long solution(int N) {
        long answer = 0;
        long[] memo = new long[81];
        memo[1] = 1;
        memo[2] = 1;
        for(int i = 3 ; i <= N ; i++)
            memo[i] = memo[i-1] + memo[i-2];
        answer = memo[N] * 2 + (memo[N] + memo[N-1]) * 2;
        return answer;
    }