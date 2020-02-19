import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int[][] memo = new int[n][m];
        int answer = 0;

        for(int i = 0 ; i < n ; i++){
            String s = sc.next();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = s.charAt(j) - '0';
                if(map[i][j] == 1){
                    memo[i][j] = map[i][j];
                    answer = 1;
                }

            }
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 1; j < m ; j++){
                if(map[i][j] == 1 && map[i-1][j] == 1
                    && map[i-1][j-1] == 1 && map[i][j-1] == 1){
                    memo[i][j] = Math.min(memo[i-1][j], memo[i-1][j-1]);
                    memo[i][j] = Math.min(memo[i][j], memo[i][j-1]) + 1;
                }
                answer = Math.max(answer, memo[i][j]);
            }
        }
        System.out.println(answer*answer);
    }
}