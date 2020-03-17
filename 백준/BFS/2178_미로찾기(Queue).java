import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            String str = sc.nextLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        Queue<Integer> queueY = new LinkedList<>();
        Queue<Integer> queueX = new LinkedList<>();

        queueY.offer(0);
        queueX.offer(0);
        while(!queueY.isEmpty() && !queueX.isEmpty()){
            Integer y = queueY.poll();
            Integer x = queueX.poll();
            visited[y][x] = true;
            for(int i = 0 ; i < dy.length ; i++){
                int _y = y + dy[i];
                int _x = x + dx[i];
                if(_y >= 0 && _y < N && _x >= 0 && _x < M && map[_y][_x] == 1 && !visited[_y][_x]){
                    queueY.offer(_y);
                    queueX.offer(_x);
                    map[_y][_x] = map[y][x] + 1;
                }
            }
        }
        System.out.println(map[N-1][M-1]);
    }
}