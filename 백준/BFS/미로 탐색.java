import java.util.*;

public class Main {

    static int[][] map, memo;
    static boolean[][] visited;
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        memo = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            String str = sc.nextLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int y, int x){
        if(y == N-1 && x == M-1)
            return 1;
        if(memo[y][x] != 0){
            return memo[y][x];
        }

        int answer = 1000000000;
        if(y > 0 && !visited[y-1][x] && map[y-1][x] == 1) {
            visited[y-1][x] = true;
            answer = Math.min(answer, bfs(y - 1, x) + 1);
            visited[y-1][x] = false;
        }
        if(y < N-1 && !visited[y+1][x] && map[y+1][x] == 1) {
            visited[y+1][x] = true;
            answer = Math.min(answer, bfs(y + 1, x) + 1);
            visited[y+1][x] = false;
        }
        if(x > 0 && !visited[y][x-1] && map[y][x-1] == 1) {
            visited[y][x-1] = true;
            answer = Math.min(answer, bfs(y , x-1) + 1);
            visited[y][x-1] = false;
        }
        if(x < M-1 && !visited[y][x+1] && map[y][x+1] == 1) {
            visited[y][x+1] = true;
            answer = Math.min(answer, bfs(y , x+1) + 1);
            visited[y][x+1] = false;
        }

        return memo[y][x] = answer;
    }
}