import java.util.*;

public class Main {
    static int[][] map;
    static int V, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp1 = sc.nextLine().split(" ");
        V = Integer.parseInt(tmp1[0]);
        int E = Integer.parseInt(tmp1[1]);
        K = Integer.parseInt(sc.nextLine());

        map = new int[V + 1][V + 1];
        while (E-- > 0) {
            String[] tmp2 = sc.nextLine().split(" ");
            int src = Integer.parseInt(tmp2[0]);
            int dest = Integer.parseInt(tmp2[1]);
            int w = Integer.parseInt(tmp2[2]);
            if (map[src][dest] != 0)
                map[src][dest] = Math.min(map[src][dest], w);
            else
                map[src][dest] = w;
        }

        int[] distance = dijkstra(K);
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i < distance.length ; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(distance[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int[] dijkstra(int start) {
        int[] distance = new int[V + 1];
        boolean[] visited = new boolean[V + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        visited[start] = true;

        for (int i = 1; i < V + 1; i++) {
            if (i != start && map[start][i] != 0)
                distance[i] = map[start][i];
        }

        for (int n = 0; n < V - 1; n++) {
            int minVal = Integer.MAX_VALUE;
            int minIdx = 1;
            for(int i = 1 ; i < distance.length ; i++){
                if(!visited[i] && distance[i] < minVal){
                    minIdx = i;
                    minVal = distance[i];
                }
            }

            visited[minIdx] = true;
            for(int i = 1; i < V+1 ; i++){
                if(map[minIdx][i] != 0 && distance[i] > distance[minIdx] + map[minIdx][i])
                    distance[i] = distance[minIdx] + map[minIdx][i];
            }
        }

        return distance;
    }
}