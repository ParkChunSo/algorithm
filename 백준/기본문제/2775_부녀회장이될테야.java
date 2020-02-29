import java.util.Scanner;

public class Main {
    static int[][] memo = new int[15][15];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1 ; i < 15 ; i++)
            memo[0][i] = i;
        for(int k =1 ; k < 15 ; k++){
            for(int n = 1 ; n < 15 ; n++){
                for(int i = 1 ; i <= n ; i++){
                    memo[k][n] += memo[k-1][i];
                }
            }
        }
        int T = sc.nextInt();
        while(T>0){
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(memo[k][n]);
            T--;
        }
    }
}