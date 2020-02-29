import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static final int MAX_INDEX = 501;
    static int[] nums = new int[MAX_INDEX], memo = new int[MAX_INDEX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Arrays.fill(nums, -1);
        Arrays.fill(memo, -1);

        for(int i = 0 ; i < N ; i++){
            nums[sc.nextInt()] = sc.nextInt();
        }
        int answer = -1;
        for(int i = 1 ; i < MAX_INDEX ; i++){
            if(nums[i] != -1)
                answer = Math.max(answer, solution(i) + 1);
        }
        System.out.println(N - answer);
    }

    public static int solution(int idx){
        if(memo[idx] != -1)
            return memo[idx];

        int answer = 0;
        for(int i = idx+1 ; i < MAX_INDEX ; i++){
            if(nums[i] != -1 && nums[i] > nums[idx])
                answer = Math.max(answer, solution(i) + 1);
        }

        return memo[idx] = answer;
    }
}