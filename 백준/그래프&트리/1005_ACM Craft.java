import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N, K, W;
    static int[] cost, indegree;
    static List<List<Integer>> list;
    public static void main (String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cost = new int[N+1];
            indegree = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= N ; i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList<>();
            for(int i = 0 ; i <= N ; i++){
                list.add(new ArrayList());
            }
            for(int i = 0 ; i < K ; i++){
                st = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                indegree[dest]++;
                list.get(src).add(dest);
            }
            W = Integer.parseInt(br.readLine());

            System.out.println(solution());
        }
    }
    private static int solution(){
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                result[i] = cost[i];
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node == W)
                break;
            for(int linked : list.get(node)){
                result[linked] = Math.max(result[linked], result[node] + cost[linked]);
                indegree[linked]--;
                if(indegree[linked] == 0)
                    queue.offer(linked);
            }
        }
        return result[W];
    }
}