import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map, memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 1;
        while(true){
            N = sc.nextInt();
            if(N == 0)
                break;
            map = new int[N][3];
            memo = new int[N][3];
            for(int i = 0 ; i < N ; i++){
                map[i][0] = sc.nextInt();
                map[i][1] = sc.nextInt();
                map[i][2] = sc.nextInt();
            }
            for(int i = 0 ; i < N ; i++){
                Arrays.fill(memo[i], -1);
            }

            System.out.println(cnt + ". " + solution(0, 1));
            cnt++;
        }
    }

    public static int solution(int depth, int idx) {
        if(depth == N)
            return 1000000000;
        if(depth == N-1 && idx == 1)
            return map[depth][idx];
        if(memo[depth][idx] != -1)
            return memo[depth][idx];
        int answer = 1000000000;
        if(idx > 0){
            answer = Math.min(answer, solution(depth+1, idx-1) + map[depth][idx]);
        }
        if(idx < 2){
            answer = Math.min(answer, solution(depth, idx+1) + map[depth][idx]);
            answer = Math.min(answer, solution(depth+1, idx+1) + map[depth][idx]);
        }
        answer = Math.min(answer, solution(depth+1, idx) + map[depth][idx]);

        return memo[depth][idx] = answer;
    }
}