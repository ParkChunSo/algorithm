import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map, memo;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        memo = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], -1);
        }

        int answer = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, solution(i, j));
            }
        }
        System.out.println(answer+1);
    }

    private static int solution(int y, int x) {

        if (memo[y][x] != -1)
            return memo[y][x];

        int answer = 0;
        for (int i = 0; i < dx.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (checkValidXY(ny, nx, map[y][x])) {
                answer = Math.max(answer, solution(ny, nx)+1);
            }
        }

        return memo[y][x] = answer;
    }
    private static boolean checkValidXY (int y, int x, int val){
        return y < N && y >= 0
                && x < N && x >= 0
                && map[y][x] > val;
    }
}