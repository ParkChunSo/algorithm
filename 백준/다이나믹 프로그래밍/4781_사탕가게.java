import java.util.Scanner;

public class Main{
    static int N;
    static double totalCash;
    static int[] cal;
    static double[] price;
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            N = sc.nextInt();
            if(N == 0)
                break;
            totalCash = sc.nextDouble();

            cal = new int[N];
            price = new double[N];
            memo = new int[N];

            for(int i = 0 ; i < N ; i++){
                cal[i] = sc.nextInt();
                price[i] = sc.nextDouble();
            }
            
            System.out.println(dp(0, 0));
        }
    }

    public static int dp(int idx, double cash){
        if(memo[idx] != 0)
            return memo[idx];

        int answer = 0;
        for(int i = idx ; i < N ; i++){
            if(price[i] + cash <= totalCash){
                answer = Math.max(answer, dp(i, price[i] + cash) + cal[i]);
            }
        }

        return memo[idx] = answer;
    }
}