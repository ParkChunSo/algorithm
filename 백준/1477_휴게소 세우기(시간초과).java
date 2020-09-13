import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L;
    static int[] distance;
    static int[] check;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        check = new int[N + 1];
        distance = new int[N + 1];
        memo = new int[N + 1][M + 1];

        PriorityQueue<Integer> point = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            point.offer(Integer.parseInt(st.nextToken()));
        }
        if (point.isEmpty()) {
            return;
        }
        br.close();

        int i = 1, prePoint = point.poll();
        distance[0] = prePoint;
        while (!point.isEmpty()) {
            int poll = point.poll();
            distance[i] = poll - prePoint;
            prePoint = poll;
            if (point.isEmpty())
                distance[N] = L - poll;
            i++;
        }

        System.out.println(dfs(0, M));
    }

    // idx구역에서부터 num개의 휴개소를 지어야할
    // 때 각 휴계소까지의 거리 중 최대 거리
    private static int dfs(int idx, int num) {
        if (idx == N) {
            return findMaxDistance();
        }

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i <= num; i++) {
            check[idx] = i;
            minVal = Math.min(minVal, dfs(idx+1, num - i));
        }

        return minVal;
    }

    private static int findMaxDistance(){
        int max = 0;
        for(int i = 0 ; i < check.length ; i++){
            max = Math.max(max, findDistance(i, check[i]));
        }
        return max;
    }

    private static int findDistance(int idx, int num) {
        if (num == 0)
            return distance[idx];

        int d = distance[idx] / (num + 1);
        if (distance[idx] % (num + 1) != 0)
            return d + 1;

        return d;
    }
}
