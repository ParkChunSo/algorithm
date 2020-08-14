import java.util.*;

public class Main {
    static final int VERTICAL = 0; // 수평
    static final int HORIZONTAL = 1; // 수직
    static final int DIAGONAL = 2; // 대각

    static int N;
    static int[][] map;
    static long[][][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new int[N][N];
        memo = new long[3][N][N]; // (y, x)에서 3개중 하나의 포메이션으로 있을 때, (N, N)까지

        for (int i = 0; i < N; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.println(dfs(VERTICAL, 0, 1));
    }

    private static long dfs(int position, int y, int x) {
        if (y == N - 1 && x == N - 1)
            return 1;

        if (memo[position][y][x] != 0)
            return memo[position][y][x];

        if (position == VERTICAL) {
            if (checkVerticalXY(y, x, N, map))
                memo[position][y][x] += dfs(VERTICAL, y, x + 1);
            if (checkDiagonalXY(y, x, N, map))
                memo[position][y][x] += dfs(DIAGONAL, y + 1, x + 1);
        } else if (position == HORIZONTAL) {
            if (checkHorizontalXY(y, x, N, map))
                memo[position][y][x] += dfs(HORIZONTAL, y + 1, x);
            if (checkDiagonalXY(y, x, N, map))
                memo[position][y][x] += dfs(DIAGONAL, y + 1, x + 1);
        } else {
            if (checkVerticalXY(y, x, N, map))
                memo[position][y][x] += dfs(VERTICAL, y, x + 1);
            if (checkHorizontalXY(y, x, N, map))
                memo[position][y][x] += dfs(HORIZONTAL, y + 1, x);
            if (checkDiagonalXY(y, x, N, map))
                memo[position][y][x] += dfs(DIAGONAL, y + 1, x + 1);
        }

        return memo[position][y][x];
    }

    private static boolean checkVerticalXY(int y, int x, int N, int[][] map) {
        return y < N && y >= 0
                && x + 1 < N && x + 1 >= 0
                && map[y][x + 1] != 1;
    }

    private static boolean checkHorizontalXY(int y, int x, int N, int[][] map) {
        return y + 1 < N && y + 1 >= 0
                && x < N && x >= 0
                && map[y + 1][x] != 1;
    }

    private static boolean checkDiagonalXY(int y, int x, int N, int[][] map) {
        return (y + 1 < N && y + 1 >= 0
                && x + 1 < N && x + 1 >= 0
                && map[y + 1][x + 1] != 1)
                && checkVerticalXY(y, x, N, map)
                && checkHorizontalXY(y, x, N, map);
    }
}