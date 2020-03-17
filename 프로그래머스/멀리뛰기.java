import java.util.*;

class Solution {
    int N;
    long MOD = 1234567;
    long[] memo;

    public long solution(int n) {
        if (n == 1)
            return 1;

        this.N = n;
        memo = new long[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        return dp(N);
    }

    public long dp(int n) {
        if (memo[n] != 0)
            return memo[n];

        memo[n] = (dp(n - 1) + dp(n - 2)) % MOD;

        return memo[n];
    }

    public long bfs(int n) {
        long answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (poll == N) {
                answer++;
                continue;
            }

            if (poll + 1 <= N)
                queue.offer(poll + 1);

            if (poll + 2 <= N)
                queue.offer(poll + 2);
        }
        return answer % MOD;
    }
}