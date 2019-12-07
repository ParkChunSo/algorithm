public class Solution {
    long[] memo = new long[2001];
    public long solution(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(memo[n] != 0)
            return memo[n];

        memo[n] = solution(n-1) + solution(n-2);
        return memo[n] % 1234567;
    }
}
