import java.util.*;

public class Main{
    static int N;
    static ArrayList<ArrayList<Integer>> relation;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        relation = new ArrayList<>();

        for(int i = 0  ; i < N ; i++){
            ArrayList<Integer> list = new ArrayList<>();
            char[] chars = sc.nextLine().toCharArray();
            for(int j = 0 ; j < chars.length ; j++){
                if(chars[j] == 'Y')
                    list.add(j);
            }
            relation.add(list);
        }
        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            answer = Math.max(answer, bfs(i));
        }

        System.out.println(answer);
    }

    public static int bfs(int idx){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);

        int depth = 0, cnt = 0;
        boolean[] visited = new boolean[N];

        while(!queue.isEmpty() && depth < 2){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                int pop = queue.poll();
                ArrayList<Integer> list = relation.get(pop);
                for(int node : list){
                    if(!visited[node] && idx != node){
                        visited[node] = true;
                        queue.offer(node);
                        cnt++;
                    }
                }
            }
            depth++;
        }
        return cnt;
    }
}