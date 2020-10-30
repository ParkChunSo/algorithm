import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, S, M;
    static int[] arr;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memo = new int[N][M+1];
        for(int i = 0 ; i < N ; i++)
            Arrays.fill(memo[i], -2);

        st = new StringTokenizer(br.readLine());
        arr= new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = -1;
        if(S - arr[0] >= 0){
            answer = solution(1, S - arr[0]);
        }
        if(S + arr[0] <= M){
            answer = Math.max(answer, solution(1, S+arr[0]));
        }
        System.out.println(answer);
    }

    private static int solution(int idx, int volume){
        if(idx == N){
            return volume;
        }

        if(memo[idx][volume] != -2)
            return memo[idx][volume];

        memo[idx][volume] = -1;
        if(volume - arr[idx] >= 0){
            memo[idx][volume] = solution(idx + 1, volume - arr[idx]);
        }
        if(volume + arr[idx] <= M){
            memo[idx][volume] = Math.max(memo[idx][volume]
                    , solution(idx+1, volume+arr[idx]));
        }

        return memo[idx][volume];
    }
}