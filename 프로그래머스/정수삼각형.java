class Solution {
    int[][] triangle, memo;
    public int solution(int[][] triangle) {
        this.triangle = triangle;
        memo = new int[triangle.length][triangle.length];
        return dfs(0,0);
    }

    public int dfs(int y, int x){
        if(y == triangle.length-1)
            return triangle[y][x];
        if(memo[y][x] != 0)
            return memo[y][x];

        return memo[y][x] = Math.max(dfs(y+1, x) + triangle[y][x], dfs(y+1, x+1) + triangle[y][x]);
    }
}