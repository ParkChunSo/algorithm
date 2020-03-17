import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    static class Pair{
        int y;
        int x;
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T >0) {
            int N = sc.nextInt();
            Pair src = new Pair(sc.nextInt(), sc.nextInt());
            Pair des = new Pair(sc.nextInt(), sc.nextInt());

            boolean[][] visited = new boolean[N][N];
            Queue<Pair> pairs = new LinkedList<>();
            pairs.offer(src);
            int depth = 0;
            boolean flag = true;
            while(!pairs.isEmpty() && flag){
                int size = pairs.size();
                for(int i = 0 ; i < size ; i++){
                    Pair pair = pairs.poll();
                    if(pair.y == des.y && pair.x == des.x){
                        flag = false;
                        break;
                    }

                    for(int k = 0 ; k < dy.length ; k++){
                        int y = pair.y + dy[k];
                        int x = pair.x + dx[k];
                        if(y >= 0 && y < N && x >= 0 && x < N && !visited[y][x]){
                            visited[y][x] = true;
                            pairs.offer(new Pair(y, x));
                        }
                    }
                }
                if(flag)
                    depth++;
            }

            System.out.println(depth);
            T--;
        }
    }
}