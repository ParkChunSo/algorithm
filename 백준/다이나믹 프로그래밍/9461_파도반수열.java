import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        long[] dp = new long[101];
        dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2; dp[5] = 2; dp[6] = 3; dp[7] = 4;
        StringBuilder sb = new StringBuilder();
        int index = 8;
        for(int i = 0 ; i < cnt ; i++){
            int input = sc.nextInt();
            if(index > input) {
                sb.append(dp[input]+"\n");
                continue;
            }

            for(int j = index ; j <= input ; j++){
                dp[j] = dp[j-1] + dp[j-5];
                index++;
            }
            sb.append(dp[input]+"\n");
        }
        System.out.println(sb);
    }
}
