class Solution {
    int N, number;
    int MAX_CNT = 8, MAX_VAL = 1000000000;
    public int solution(int N, int number) {
        this.N = N;
        this.number = number;
        int answer = MAX_VAL;
        for(int i = 1; i <= MAX_CNT ; i++){
            int tmp = 0;
            for(int k = 1 ; k <= i ; k++){
                tmp = tmp*10 + N;
            }
            answer = Math.min(answer, dfs(i, tmp));
        }
        if(answer == MAX_VAL)
            return -1;
        return answer;
    }
    // 사칙연산을 할 때 N, NN, NNN.... 으로 할 수 있다. => for문 필요
    // 만약 사용한 N의 개수가 9 이상이 되면 안된다. return -1; => 몇개의 N을 사용했는지 파라미터 필요
    // 더하기 후 빼기, 곱하기 후 나누기는 의미가 없다. but 연산을 할 N이 다르면 가능(N -> NN) => 이전 연산이 무었인지 파라미터
    // 0에 나누거나 곱하는 것 또한 의미가 없다.
    //cnt: 사용한 N의 개수, val: 연산되어진 값
    public int dfs(int cnt, int val){
        if(cnt > MAX_CNT){
            return MAX_VAL;
        }
        if(val == number){
            return cnt;
        }
        int minCnt = MAX_VAL;
        int canUseCnt = MAX_CNT-cnt;
        for(int i = 1 ; i <= canUseCnt ; i++){
            int tmp = 0;
            for(int k = 1 ; k <= i ; k++){
                tmp = tmp*10 + N;
            }
            minCnt = Math.min(minCnt, dfs(cnt+i, val+tmp));
            minCnt = Math.min(minCnt, dfs(cnt+i, val-tmp));
            if(val != 0){
                minCnt = Math.min(minCnt, dfs(cnt+i, val*tmp));
                minCnt = Math.min(minCnt, dfs(cnt+i, val/tmp));
            }
        }
        return minCnt;
    }
}