import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[] item;
    static int[][] path;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        item = new int[N+1];
        path = new int[N+1][N+1];
        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < R ; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            path[src][dest] = val;
            path[dest][src] = val;
        }
        int answer = 0;
        for(int i = 1 ; i <= N ; i++){
            visited = new boolean[N+1];
            visited[i] = true;
            answer = Math.max(answer, dfs(i, 0) + item[i]);
        }
        System.out.println(answer);
    }

    static boolean[] visited;
    private static int dfs(int src, int d){
        int answer = 0;
        for(int i = 1 ; i <= N ; i++){
            if(path[src][i] == 0)
                continue;
            if(d + path[src][i] > M)
                continue;

            if(!visited[i]) {
                visited[i] = true;
                answer += dfs(i, d + path[src][i]) + item[i];
            }else if(visited[i] && d+ path[src][i] <= M){
                answer += dfs(i, d + path[src][i]);
            }
        }
        return answer;
    }
}