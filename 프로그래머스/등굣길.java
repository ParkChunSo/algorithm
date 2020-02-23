import java.util.Arrays;

class Solution {
    int MOD = 1000000007;
    int[][] memo;
    int[][] puddles;
    int n, m;
    public int solution(int m, int n, int[][] puddles) {
        memo = new int[n][m];
        this.n = n;
        this.m = m;
        this.puddles = puddles;
        
        for(int i = 0 ; i < memo.length ; i++){
            Arrays.fill(memo[i], -1);
        }
        
        return getSolution(0, 0);
    }
    public int getSolution(int y, int x){
        if(y == n-1 && x == m-1)
            return 1;
        
        if(memo[y][x] != -1)
            return memo[y][x];
        
        int answer = 0;
        if(y+1 != n && canIGoThere(y+1, x)){
            answer += getSolution(y+1, x);
        }
        if(x+1 != m && canIGoThere(y, x+1)){
            answer += getSolution(y, x+1);
        }
        
        return memo[y][x] = (answer % MOD);
    }
    public boolean canIGoThere(int y, int x){
        for(int i = 0 ; i < puddles.length ; i++){
            if(x+1 == puddles[i][0] && y+1 == puddles[i][1])
                return false;
        }
        return true;
    }
}