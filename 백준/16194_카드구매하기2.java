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

        int min = 1000000000;
        for(int i = 1; i <= N ; i++ ){
            if(cnt - i < 0){
                break;
            }
            min = Math.min(min, dp(cnt - i) + P[i]);
        }

        return cache[cnt] = min;
    }
}