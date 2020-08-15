import java.util.*;

public class Main {

    static int[] memo;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        arr = new int[N];
        memo = new int[N];
        String[] split = sc.nextLine().split(" ");
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(split[i]);

        int answer = -1;
        for(int i = 0 ; i < N ; i++)
            answer = Math.max(answer, longestSubArr(i));
        System.out.println(answer);
    }

    private static int longestSubArr(int idx){
        if(idx == arr.length - 1)
            return 1;

        if(memo[idx] != 0)
            return memo[idx];

        int answer = -1;
        for(int i = idx+1 ; i < arr.length ; i++){
            if(arr[idx] >= arr[i]){
                continue;
            }
            answer = Math.max(answer, longestSubArr(i) + 1);
        }

        return memo[idx] = answer;
    }
}