import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static int[][] cache;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        cache = new int[N+1][K+1];
        for(int i = 0 ; i <= N ; i++){
            Arrays.fill(cache[i], -1);
        }
//        cache = new int[K+1][N+1];
        int solution = solution(N, K);
        System.out.println(solution);
    }

    public static int solution(int N, int K){
        if(N == 0 && K == 0)
            return 1;

        if(K == 0)
            return 0;

        if(cache[N][K] != -1)
            return cache[N][K];

        int cnt = 0;
        for(int i = 0 ; i <= N ; i++){
            cnt += solution(N-i, K-1);
        }
        return cache[N][K] = cnt % 1000000000;
    }

    public static int solution2(int N, int K){
        for(int i=0;i<=N;i++) {
            cache[1][i] = 1;
        }

        for(int i=1;i<=K;i++) {

            for(int j=0;j<=N;j++) {

                for(int l=0;l<=j;l++) {
                    cache[i][j] += cache[i-1][j-l];
                    cache[i][j] %= 1000000000;
                }

            }

        }
        return cache[K][N];
    }

}