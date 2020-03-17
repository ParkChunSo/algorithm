import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Location{
        int y;
        int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;
    static int[][] map, memo;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N][M];
        memo = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int y = 0 ; y < N ; y++){
            for(int x = 0 ; x < M ; x++){
                if(map[y][x] == 1) {
                    visited = new boolean[N][M];
                    bfs(new Location(y, x));
                }
            }
        }
        int answer = -1;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 0 && memo[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if(answer < memo[i][j])
                    answer = memo[i][j];
            }
        }
        System.out.println(answer);
    }

    public static void bfs(Location location){
        Queue<Location> queue = new LinkedList<>();
        queue.offer(location);
        visited[location.y][location.x] = true;

        while(!queue.isEmpty()){
            Location poll = queue.poll();

            for(int i = 0 ; i < dy.length ; i++){
                int y = poll.y + dy[i];
                int x = poll.x + dx[i];
                if(y >= 0 && y < N && x >= 0  && x < M && !visited[y][x] && map[y][x] == 0){
                    if(memo[y][x] != 0 && memo[y][x] < memo[poll.y][poll.x] + 1)
                        continue;
                    queue.offer(new Location(y, x));
                    visited[y][x] = true;
                    memo[y][x] = memo[poll.y][poll.x] + 1;
                }
            }
        }
    }
}