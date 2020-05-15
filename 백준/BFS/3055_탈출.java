import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static char[][] map;
    static Queue<Pair> waterQueue = new LinkedList<>();
    static Queue<Pair> pathQueue = new LinkedList<>();

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    /**
     * 상하좌우로 이동 가능하다.
     * 물은 상하좌우로 턴마다 차오른다.
     * 물은 도착지역을 침범하지 못한다.
     * 물이 찰 예정인 곳은 갈 수 없다.
     * '.' 이동 가능 구역(물이 찰 예정인지 확인 필요)
     * '*' 물이 차있는 구역
     * 'X' 돌(이동 불가능)
     * 'D' 도착지역
     * 'S' 시작지역
     * 이동할 수 없으면 KAKTUS 출력
     */
    static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new char[sc.nextInt()][sc.nextInt()];
        sc.nextLine();

        Pair endPoint = new Pair(0, 0);

        for(int y = 0 ; y < map.length ; y++){
            String s = sc.nextLine();
            for(int x = 0 ; x < map[0].length ; x++){
                map[y][x] = s.charAt(x);
                if(map[y][x] == '*')
                    waterQueue.offer(new Pair(y, x));
                else if(map[y][x] == 'S')
                    pathQueue.offer(new Pair(y, x));
                else if(map[y][x] == 'D')
                    endPoint = new Pair(y, x);
            }
        }

        int answer = -1;
        boolean[][] visited = new boolean[map.length][map[0].length];
        boolean isArrived = false;
        while(!pathQueue.isEmpty()){
            answer++;
            int size = pathQueue.size();
            for(int cnt = 0 ; cnt < size ; cnt++) {
                Pair next = pathQueue.poll();

                if (next.y == endPoint.y && next.x == endPoint.x) {
                    isArrived = true;
                    break;
                }
                if (map[next.y][next.x] == '*')
                    continue;

                for (int i = 0; i < dy.length; i++) {
                    int y = next.y + dy[i];
                    int x = next.x + dx[i];
                    if (y >= 0 && y < map.length && x >= 0 && x < map[0].length
                            && map[y][x] != 'X' && map[y][x] != '*' && map[y][x] != 'S' && !visited[y][x]) {
                        pathQueue.offer(new Pair(y, x));
                        visited[y][x] = true;
                    }
                }
            }
            if(isArrived)
                break;
            setNewWaterArea();
        }

        if(isArrived)
            System.out.println(answer);
        else
            System.out.println("KAKTUS");
    }

    public static void setNewWaterArea(){
        int size = waterQueue.size();
        for(int cnt = 0 ; cnt < size ; cnt++){
            Pair poll = waterQueue.poll();

            for (int i = 0; i < dy.length; i++) {
                int y = poll.y + dy[i];
                int x = poll.x + dx[i];
                if (y >= 0 && y < map.length && x >= 0 && x < map[0].length
                        && map[y][x] != 'X' && map[y][x] != '*' && map[y][x] != 'D') {
                    waterQueue.offer(new Pair(y, x));
                    map[y][x] = '*';
                }
            }
        }
    }

}
