import java.util.*;

public class Main {
    static int N;
    static long[][] memo;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        memo = new long[N][N];
        map = new int[N][N];

        for(int i = 0 ; i< N ; i++){
            String[] tmp = sc.nextLine().split(" ");
            for(int j = 0 ; j < tmp.length ; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        System.out.println(solution(0, 0));

    }

    // y, x 에서 N, N까지 갈 수 있는 경로의 개수
    private static long solution(int y, int x){
        if(y == N-1 && x == N-1)
            return 1L;

        if(map[y][x] == 0)
            return 0L;

        if(memo[y][x] != 0)
            return memo[y][x];
        if(validateXY(y, x + map[y][x]))
            memo[y][x] += solution(y, x + map[y][x]);
        if(validateXY(y + map[y][x], x))
            memo[y][x] += solution(y + map[y][x], x);
        return memo[y][x];
    }
    
    private static boolean validateXY(int y, int x){
        return y >= 0 && y < N
                && x >= 0 && x < N;
    }
}
