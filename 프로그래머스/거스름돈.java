class Solution {
    int N, MOD = 1000000007;
    int[] money;
    int[][] memo;
  public int solution(int n, int[] money) {
      this.N = n;
      this.money = money;
      memo = new int[money.length][n+1];
      
      return dp(0, 0);
  }
    
    public int dp(int idx, int n){
        if(n == N)
            return 1;
        
        if(memo[idx][n] != 0)
            return memo[idx][n];
        
        int answer = 0;
        for(int i = idx ; i< money.length ; i++){
            if(n + money[i] <= N)
                answer += dp(i, n + money[i]) % MOD;
        }
        
        return memo[idx][n] = answer;
    }
}