class Solution {
    static int N, MOD = 1000000007;
    static int[] memo;
  public int solution(int n) {
      this.N = n;
      memo = new int[N+1];
      memo[1] = 1;
      memo[2] = 2;
      
      return dp(N);
  }
    public int dp(int idx){
        if(memo[idx] != 0)
            return memo[idx];
        
        return memo[idx] = (dp(idx-1) + dp(idx-2)) % MOD;
    }
}