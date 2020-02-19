import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static int[][] deli;
    public static int[][] dp;
    public static int N;
    public static int M;
    public static int K;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();

        deli = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            int s = scan.nextInt(); //출발 도시
            int d = scan.nextInt(); //도착 도시
            int v = scan.nextInt(); //기내식 가치

            //도시 번호가 증가하는 것 중
            if (s < d) {
                deli[s][d] = Math.max(deli[s][d], v); //기내식 가치 큰 것만 골라서 저장
            }
        }

        dp = new int[N + 1][M + 1]; //동적계획법 이용하기 위해, dp[i][j] : j개 도시 찍고 i 도시에 온 경우 최대 기내식 가치 저장
        for (int i = 0; i <= N; i++)
            Arrays.fill(dp[i], -1);

        dp[1][1] = 0; //출발지 기내식 총합을 0으로 초기화
        for (int i = 1; i < N; i++) {
            int res = Math.min(i, M - 1); //1개 ~ M개의 도시를 방문해야하기 때문에
            for (int j = 1; j <= res; j++) {
                if (dp[i][j] != -1) {
                    for (int k = i + 1; k <= N; k++) {
                        if (deli[i][k] != 0) //i 도시에서 k 도시로 가는 항공로가 없는 경우
                            dp[k][j + 1] = Math.max(dp[k][j + 1], dp[i][j] + deli[i][k]);
                    }
                }
            }
            for(int q = 1 ; q < dp.length ; q++){
                for(int p = 1 ; p < dp[q].length ; p++){
                    System.out.print(dp[q][p]+ " ");
                }
                System.out.println("");
            }
            System.out.println("");
        }

        int max = 0;
        for (int i = 1; i <= M; i++)
            max = Math.max(max, dp[N][i]);
        System.out.print(max);
    }
}