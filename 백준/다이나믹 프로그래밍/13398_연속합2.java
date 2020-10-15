import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] memo;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        memo = new int[2][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i++){
            if(nums[i] <= 0){
                continue;
            }
            answer = Math.max(answer, solution(i, 1));
        }
        if(answer == 0 || answer == Integer.MIN_VALUE){
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i < N ; i++){
                if(max < nums[i])
                    max = nums[i];
            }
            answer = max;
        }
        System.out.println(answer);
    }

    private static int solution(int idx, int depth){
        if(idx == N)
            return 0;

        if(memo[depth][idx] != 0)
            return memo[depth][idx];

        int sum = 0;
        for(int i = idx ; i < N ; i++){
            if(nums[i] > 0){
                sum += nums[i];
                continue;
            }

            if(depth == 1){
                memo[depth][idx] = Math.max(solution(i+1, 0) + sum
                        , solution(i+1, 1) + sum + nums[i]);
            }else{
                memo[depth][idx] = Math.max(sum, solution(i+1, 0) + sum + nums[i]);
            }
            break;
        }

        if(memo[depth][idx] == 0){
            return memo[depth][idx] = sum;
        }else {
            return memo[depth][idx];
        }
    }
}