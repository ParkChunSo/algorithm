import java.util.*;

public class Main {

  static int n;
  static int[] T;
  static int[] P;
  static int[] dp;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    T = new int[n];
    P = new int[n];
    dp = new int[n];
    Arrays.fill(dp, -1);

    for(int i = 0 ; i < n ; i++){
      T[i] = sc.nextInt();
      P[i] = sc.nextInt();
    }
    System.out.println(solution(0));
  }

  public static int solution(int day){
    if(day == n)
      return 0;

    if(dp[day] != -1)
      return dp[day];

    if(day == n-1 && T[day] == 1)
      return P[day];

    int maxValue = 0;
    for(int i = day ; i < n ; i++){
      if(i + T[i] <= n){
        maxValue = Math.max(maxValue, solution(i+ T[i]) + P[i]);
      }
    }

    return dp[day] = maxValue;
  }
}