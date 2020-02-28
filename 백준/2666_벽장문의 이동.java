import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, moveCnt;
    static int[] wantedArr;
    static int[][][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        moveCnt = sc.nextInt();
        wantedArr = new int[moveCnt];
        for (int i = 0; i < moveCnt; i++) {
            wantedArr[i] = sc.nextInt() - 1;
        }
        memo = new int[moveCnt][N][N];
        for (int i = 0; i < moveCnt; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        System.out.println(solution(a, b, 0));
    }

    public static int solution(int a, int b, int idx) {
        if (idx == moveCnt)
            return 0;

        if (memo[idx][a][b] != -1) {
            return memo[idx][a][b];
        }

        int answer = Math.min(
                solution(wantedArr[idx], b, idx + 1) + Math.abs(a - wantedArr[idx])
                , solution(a, wantedArr[idx], idx + 1) + Math.abs(b - wantedArr[idx])
        );


        return memo[idx][a][b] = memo[idx][b][a] = answer;
    }
}