import java.util.*;

public class Main {

    static int[][][] memo;
    static int T, W;
    static int[] input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        W = sc.nextInt();
        input = new int[T];
        memo = new int[T][W+1][2];
        for(int i = 0 ; i < T ; i++){
            input[i] = sc.nextInt() - 1;
        }
        System.out.println(Math.max(dp(0, W, 0), dp(0, W - 1, 1)));
    }

    /**
     *
     * @param t: 초
     * @param w: 움직일 수 있는 횟수
     * @param now: 현재 위치한 나무
     * @return 최대 받은 자두의 개수
     */
    public static int dp(int t, int w, int now){
        if(t == T-1){
            return input[t] == now ? 1 : 0;
        }
        if(memo[t][w][now] != 0)
            return memo[t][w][now];

        //now에 그대로 있을건지, 다른 나무로 갈건지 두가지 중 max를 담는다.
        if(w > 0)
            memo[t][w][now] += Math.max(dp(t+1, w, now), dp(t+1, w-1, now == 0 ? 1 : 0));
        else
            memo[t][w][now] += dp(t+1, w, now);

        return memo[t][w][now] += input[t] == now ? 1 : 0;
    }
}