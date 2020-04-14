import java.util.*;

public class Main {
    static int[] nums;
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        memo = new int[input.length()];
        nums = new int[input.length()];
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = input.charAt(i) - '0';
        }

        System.out.println(dp(0));
    }
    public static int dp(int idx){
        if(memo[idx] != 0)
            return memo[idx];

        int max = 1;
        for(int i = idx ; i < nums.length-1 ; i++){
            if(Math.abs(nums[i] - nums[i+1]) == 1)
                max = Math.max(max, dp(i+1) + 1);
        }

        return max;
    }
}