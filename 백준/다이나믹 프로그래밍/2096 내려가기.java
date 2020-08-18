import java.util.*;

public class Main {
    static int N;
    static int[][] memoMax;
    static int[][] memoMin;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        memoMax = new int[N][3];
        memoMin = new int[N][3];
        map = new int[N][3];

        for(int i = 0 ; i< N ; i++){
            String[] tmp = sc.nextLine().split(" ");
            for(int j = 0 ; j < tmp.length ; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int maxVal = -1, minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < 3 ; i++){
            maxVal = Math.max(maxVal, solutionMax(0, i));
            minVal = Math.min(minVal, solutionMin(0, i));
        }
        System.out.println(maxVal+" "+minVal);
    }
    static int[] dx = {-1, 0, 1};
    private static int solutionMax(int y, int x){
        if(y == N-1)
            return map[y][x];

        if(memoMax[y][x] != 0)
            return memoMax[y][x];

        for (int j : dx) {
            int newX = x + j;
            if (newX < 3 && newX >= 0)
                memoMax[y][x] = Math.max(memoMax[y][x], solutionMax(y + 1, newX) + map[y][x]);
        }
        return memoMax[y][x];
    }
    private static int solutionMin(int y, int x){
        if(y == N-1)
            return map[y][x];

        if(memoMin[y][x] != 0)
            return memoMin[y][x];

        memoMin[y][x] = Integer.MAX_VALUE;
        for (int j : dx) {
            int newX = x + j;
            if (newX < 3 && newX >= 0)
                memoMin[y][x] = Math.min(memoMin[y][x], solutionMin(y + 1, newX) + map[y][x]);
        }
        return memoMin[y][x];
    }
}
