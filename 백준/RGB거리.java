import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] memo = new int[N][3];
        int[][] rgb = new int[N][3];
        for(int i = 0 ; i < rgb.length ; i++){
            rgb[i][0] = sc.nextInt();
            rgb[i][1] = sc.nextInt();
            rgb[i][2] = sc.nextInt();
        }

        memo[0][0] = rgb[0][0];
        memo[0][1] = rgb[0][1];
        memo[0][2] = rgb[0][2];
        for(int i = 1 ; i < N ; i++){
            memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + rgb[i][0];
            memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + rgb[i][1];
            memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + rgb[i][2];
        }
        int answer = Math.min(memo[N-1][0], Math.min(memo[N-1][1], memo[N-1][2]));
        System.out.println(answer);
    }
}