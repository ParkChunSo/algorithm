import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static int N;
    static int[] left;
    static int[] right;
    static int[][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        left = new int[N];
        right = new int[N];
        memo = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            left[i] = sc.nextInt();
        }
        for(int i = 0 ; i < N ; i++){
            right[i] = sc.nextInt();
        }
        for(int i = 0 ; i < N ; i++)
            Arrays.fill(memo[i], -1);
        System.out.println(dp(0,0));
    }

    public static int dp(int leftIndex, int rightIndex){
        if(leftIndex == N|| rightIndex == N)
            return 0;

        if(memo[leftIndex][rightIndex] != -1) {
            return memo[leftIndex][rightIndex];
        }

        int max = -1;
        if(left[leftIndex] > right[rightIndex]){
            max = Math.max(max, dp(leftIndex, rightIndex+1) + right[rightIndex]);
        }
        max = Math.max(max, dp(leftIndex+1, rightIndex+1));
        max = Math.max(max, dp(leftIndex + 1, rightIndex));
        return memo[leftIndex][rightIndex] = max;
    }
}