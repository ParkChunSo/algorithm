import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] indegree = new int[N+1];
        int[] costs = new int[N+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int res = Integer.parseInt(st.nextToken());
                if(res == -1)
                    break;
                list.get(res).add(i);
                indegree[i]++;
            }
        }
        int[] answer = solution(list, indegree, costs);
        for(int i = 1 ; i <= N ; i++)
            System.out.println(answer[i]);

        br.close();
    }

    private static int[] solution(List<List<Integer>> list, int[] indegree, int[] costs){
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[costs.length];
        for(int i = 1 ; i < indegree.length ; i++){
            if(indegree[i] == 0) {
                queue.offer(i);
                result[i] = costs[i];
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int linked : list.get(node)){
                result[linked] = Math.max(result[linked], result[node]+ costs[linked]);
                indegree[linked]--;
                if(indegree[linked] == 0)
                    queue.offer(linked);
            }
        }

        return result;
    }
}