final static int MOD = 1000000007;
    public static int ways(int total, int k) {
        // Write your code here
        int[] memo = new int[total+1];
        memo[0] = 1;
        for(int i = 1; i <= k; i++) {
            for(int j = i; j <= total; j++) {
                memo[j] += memo[j - i];
                memo[j] %= MOD;
            }
        }
        return memo[total];
    }