import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static class Location{
        int y;
        int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine().trim());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0 ; i < N ; i++){
            String str = sc.nextLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        PriorityQueue<Integer> answer = new PriorityQueue<>();
        for(int y = 0 ; y < N ; y++){
            for(int x = 0; x < N ; x++){
                if(map[y][x] == 1 && !visited[y][x])
                    answer.offer(bfs(new Location(y, x)));
            }
        }
        System.out.println(answer.size());
        for(int tmp : answer){
            System.out.println(tmp);
        }
    }

    public static int bfs(Location location){
        Queue<Location> queue = new LinkedList<>();
        queue.offer(location);
        visited[location.y][location.x] = true;

        int cnt = 0;
        while(!queue.isEmpty()){
            Location poll = queue.poll();
            ++cnt;
            for(int i = 0 ; i < dy.length ; i++){
                int y = poll.y + dy[i];
                int x = poll.x + dx[i];
                if(y >= 0 && y < N && x >= 0 && x < N && map[y][x] == 1 && !visited[y][x]){
                    visited[y][x] = true;
                    queue.offer(new Location(y, x));
                }
            }
        }
        return cnt;
    }
}