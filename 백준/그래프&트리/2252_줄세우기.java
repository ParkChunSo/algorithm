import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++)
            list.add(new ArrayList<>());
        int[] indegree = new int[N+1];
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int res = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            list.get(res).add(dest);
            indegree[dest]++;
        }
        Queue<Integer> result = topologicalSort(list, indegree);
        while(!result.isEmpty()){
            System.out.print(result.poll()+" ");
        }
    }
    private static Queue<Integer> topologicalSort(List<List<Integer>> list, int[] indegree){
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for(int i = 1 ; i < list.size() ; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            result.offer(node);
            for (int linked: list.get(node)){
                indegree[linked]--;
                if(indegree[linked] == 0)
                    queue.offer(linked);
            }
        }
        return result;
    }
}