import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;
    static long[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        memo = new long[N][21];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            Arrays.fill(memo[i], -1);
        }
        System.out.println(dp(0, 0));
    }

    public static long dp(int idx, int val) {
        if (idx == N - 1 && val == arr[idx]) {
            return 1;
        } else if (idx == N - 1) {
            return 0;
        }

        if (memo[idx][val] != -1)
            return memo[idx][val];

        long cnt = 0;
        int sum = val + arr[idx], dif = val - arr[idx];
        if (isRange(sum))
            cnt += dp(idx + 1, sum);
        if (isRange(dif))
            cnt += dp(idx + 1, dif);

        return memo[idx][val] = cnt;
    }

    public static boolean isRange(int val) {
        return val <= 20 && val >= 0;
    }
}
