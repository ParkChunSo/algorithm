import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static int N;
    static int[] nums;
    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        nums = new int[N];
        memo = new int[N];

        for(int i = 0 ; i < N ; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.fill(memo, -1);

        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            answer = Math.max(answer , solution(i));
        }
        System.out.println(answer);
    }

    public static int solution(int idx){
        if(idx == N-1)
            return 1;

        if(memo[idx] != -1)
            return memo[idx];

        int answer = 1;
        for(int i = idx+1 ; i < N ; i++){
            if(nums[idx] >= nums[i])
                continue;
            answer = Math.max(answer, solution(i) + 1);
        }

        return memo[idx] = answer;
    }
}