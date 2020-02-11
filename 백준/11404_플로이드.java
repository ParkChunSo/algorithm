import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] distance = new int[n+1][n+1];
        for(int i = 0 ; i < distance.length ; i++){
            Arrays.fill(distance[i], 1000000);
            distance[i][i] = 0;
        }
        for(int i = 0 ; i < m ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            distance[start][end] = Math.min(distance[start][end], weight);
        }
        
        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1; j <= n ; j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        for(int i = 1 ; i <= n; i++){
            for(int j = 1; j <=n ; j++){
                System.out.print(distance[i][j]+" ");
            }
            if(i != n)
                System.out.println("");
        }
    }
}