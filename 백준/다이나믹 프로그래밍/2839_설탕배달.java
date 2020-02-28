import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] memo;
    static final int MAX_VALUE = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memo = new int[N+1];
        Arrays.fill(memo, -1);
        int answer = solution(N);
        if(answer == MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    public static int solution(int target){
        if(target == 0)
            return 0;
        else if(target < 0)
            return MAX_VALUE;
        
        if(memo[target] != -1)
            return memo[target];
        
        int min = Math.min(solution(target - 3), solution(target - 5));
        if(min == MAX_VALUE)
            return memo[target] = MAX_VALUE;

        return memo[target] = min + 1;
    }
}