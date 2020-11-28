/**
 일반적인 DP로는 문제를 못푸는 것 같다.
**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int MOD = 10007;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        System.out.println(solution(N));
    }

    private static int solution(int val) {
        if (memo[val] != 0)
            return memo[val];

        memo[val] = val;
        for (int i = 2; i <= val / 2; i++) {
            memo[val] = Math.max(memo[val], (solution(val - i) * solution(i)) % MOD);
        }

        return memo[val];
    }
}