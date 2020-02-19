import java.util.Scanner;

public class Main{
    public static long[] cache;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M+1];
        int[] input = new int[M];
        int longestPartCnt = 0;

        if(M != 0) {
            for(int i = 0 ; i < M ; i++){
                input[i] = sc.nextInt();
            }
            arr[0] = input[0] - 1;
            for (int i = 1; i < M; i++) {
                arr[i] = input[i] - input[i - 1] - 1;
            }
            arr[M] = N - input[M - 1];
            for(int i = 0 ; i < arr.length ; i++){
                longestPartCnt = Math.max(longestPartCnt, arr[i]);
            }
        } else{
          longestPartCnt = N;
          arr[0] = N;
        }
        cache = new long[longestPartCnt + 1];
        cache[1] = 1; cache[2] = 2; cache[3] = 3;
        for(int i = 4 ; i <= longestPartCnt ; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        long answer = 1;

        for(int tmp : arr){
            answer *= cache[tmp];
        }
        System.out.println(answer);
    }
}