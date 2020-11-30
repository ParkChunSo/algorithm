import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final static int MIN_VAL = -3000000;
    private static int N;
    private static int[] stairs;
    private static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N];
        memo = new int[3][N];
        for(int i = 0 ; i < N ; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(Math.max(solution(1, 0), solution(1, 1)));
    }
    private static int solution(int cnt, int idx){
        if(idx >= N)
            return MIN_VAL;
        if(idx == N-1)
            return stairs[idx];
        if(memo[cnt][idx] != 0)
            return memo[cnt][idx];

        if(cnt == 2){
            return memo[cnt][idx] = solution(1, idx+2)+stairs[idx];
        }
        return memo[cnt][idx] = Math.max(solution(cnt+1, idx+1), solution(cnt, idx+2))+stairs[idx];
    }
}
