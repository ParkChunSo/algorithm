import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        int[][] memo = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j <= i ; j++){
                map[i][j] = sc.nextInt();
            }
        }
        memo[0][0] = map[0][0];
        for(int i = 1; i < N ; i++){
            for(int j = 0; j <=i ; j++){
                if(j == 0)
                    memo[i][j] = memo[i-1][j] + map[i][j];
                else if(j == i)
                    memo[i][j] = memo[i-1][j-1] + map[i][j];
                else
                    memo[i][j] = Math.max(memo[i-1][j], memo[i-1][j-1]) + map[i][j];
            }
        }
        int max = -1;
        for(int i = 0 ; i < N ;i++){
            max = Math.max(max, memo[N-1][i]);
        }
        System.out.println(max);
    }
}