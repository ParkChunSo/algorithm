/*
1 2 3 4 5 6
(             )
(       )
(  )
*/
public int solution(int n) {
        int[] memo = new int[n+1];
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;

        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 5;
        for(int i = 4 ; i <= n ; i++){
            int left = 0, right = i * 2, length = i*2;
            while(left < right){
                memo[i] += memo[(right - left - 1) / 2] * memo[(length - right) / 2];
                right-=2;
            }
        }
        return memo[n];
    }