import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static int N;
    public static int[] P;
    public static int[] cache;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        P = new int[N+1];
        cache = new int[N+1];
        for(int i =1 ; i <= N ; i++)
            P[i] = sc.nextInt();
        Arrays.fill(cache, -1);
        System.out.println(dp(N));
    }
    public static int dp(int cnt){
        if(cnt == 0){
            return 0;
        }
        if(cache[cnt] != -1)
            return cache[cnt];

        int max = -1;
        for(int i = 1; i <= N ; i++ ){
            if(cnt - i < 0){
                break;
            }
            max = Math.max(max, dp(cnt - i) + P[i]);
        }

        return cache[cnt] = max;
    }
}