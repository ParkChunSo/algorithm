import java.util.*;

public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 3;
        int solution = solution(n);
        System.out.println(solution);
    }

    public static int solution(int n){
        if(memo[n] != 0)
            return memo[n];
        return memo[n] = (solution(n-1) + solution(n-2) * 2) % 10007;
    }
}