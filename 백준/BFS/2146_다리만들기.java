import java.util.*;

public class Main {
    final static int SEA = 0;
    final static int LAND = 1;

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int y = 0 ; y <N ; y++){
            String[] s = sc.nextLine().split(" ");
            for(int x = 0 ; x < N ; x++){
                map[y][x] = Integer.parseInt(s[x]);
            }
        }

        // 엣지를 찾는 작업
        int landNum = 2; //섬들간 엣지를 다른 번호로 주기위해
        for(int y = 0 ; y <N ; y++){
            for(int x = 0 ; x < N ; x++){
                if(map[y][x] != SEA && !visited[y][x]){
                    markEdge(y, x, landNum);
                    landNum++;
                }
            }
        }

        //각 엣지의 가장 가까운 다른 섬 엣지를 찾는 작업
        int answer = Integer.MAX_VALUE;
        for(int y = 0 ; y <N ; y++){
            for(int x = 0 ; x < N ; x++){
                if(map[y][x] != SEA && map[y][x] != LAND){
                    answer = Math.min(answer, findMinDistance(y, x));
                }
            }
        }

        System.out.println(answer);
    }

    
    // y, x부터 연결된 섬의 끝부분들을 섬의 num으로 변환하는 메소드
    private static void markEdge(int y, int x, int landNum){
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(y, x));
        visited[y][x] = true;

        while(!queue.isEmpty()){
            Location location = queue.poll();
            for(int i = 0 ; i < dy.length ; i++){
                int _y = location.y + dy[i];
                int _x = location.x + dx[i];
                if(checkValidXY(_y, _x, N, visited)){
                    if(map[_y][_x] == SEA){
                        map[location.y][location.x] = landNum;
                        continue;
                    }
                    visited[_y][_x] = true;
                    queue.offer(new Location(_y, _x));
                }
            }
        }
    }
    
    private static boolean checkValidXY(int y, int x, int N, boolean[][] visited){
        return y < N && y >=0
                && x < N && x >= 0
                && !visited[y][x];
    }

    //y, x 엣지에서 가장 가까운 다른 섬의 엣지를 찾는 메소드
    private static int findMinDistance(int y, int x){
        int landNum = map[y][x];
        boolean[][] visited = new boolean[N][N];

        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(y, x));
        visited[y][x] = true;


        int distance = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            distance++;
            for(int k = 0 ; k < size && !queue.isEmpty(); k++) {
                Location location = queue.poll();
                for (int i = 0; i < dy.length; i++) {
                    int _y = location.y + dy[i];
                    int _x = location.x + dx[i];
                    if (checkValidXY(_y, _x, N, visited) && map[_y][_x] != landNum && map[_y][_x] != LAND) {
                        if(map[_y][_x] != SEA){
                            queue.clear();
                            break;
                        }
                        visited[_y][_x] = true;
                        queue.offer(new Location(_y, _x));
                    }
                }
            }
        }
        return distance;
    }

    static class Location{
        int y;
        int x;
        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}