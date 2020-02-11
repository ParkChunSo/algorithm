import java.util.*;

public class Main {
    static int[][] map;
    static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        map = new int[m][n];
        cache = new int[m][n];
        for(int i = 0 ; i < m ; i++)
            Arrays.fill(cache[i], -1);

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(0,0));
    }
    public static int solution(int m, int n){
        // base case
        if(m+1 == map.length && n+1 == map[0].length)
            return 1;

        if(cache[m][n] != -1)
            return cache[m][n];

        cache[m][n] = 0;
        // 상, 하, 좌, 우
        if(m-1 > -1 && map[m-1][n] < map[m][n]){
            cache[m][n] += solution(m-1, n);
        }
        if(m+1 < map.length && map[m+1][n] < map[m][n]){
            cache[m][n] += solution(m+1, n);
        }
        if(n-1 > -1 && map[m][n-1] < map[m][n]){
            cache[m][n] += solution(m, n-1);
        }
        if(n+1 < map[0].length && map[m][n+1] < map[m][n]){
            cache[m][n] += solution(m, n+1);
        }

        return cache[m][n];
    }
}