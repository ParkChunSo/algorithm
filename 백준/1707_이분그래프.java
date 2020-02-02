import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int BLUE = 1;
        final int RED = 2;
        int K = scanner.nextInt();
        while(K>0){
            int V = scanner.nextInt();
            int E = scanner.nextInt();

            ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
            for(int i = 0 ; i < V+1 ; i++){
                paths.add(new ArrayList<>());
            }

            for(int i = 0 ; i < E ; i++){
                int tmp1 = scanner.nextInt();
                int tmp2 = scanner.nextInt();
                paths.get(tmp1).add(tmp2);
                paths.get(tmp2).add(tmp1);
            }

            String answer = "YES";
            int[] color = new int[V + 1];
            int[] visit = new int[V + 1];
            for(int i = 1 ; i < V+1 ; i++) {
                if(answer.equals("NO"))
                    break;

                if(visit[i] == 1)
                    continue;

                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = BLUE;
                while (!queue.isEmpty() && answer.equals("YES")) {
                    int node = queue.poll();
                    visit[node] = 1;
                    int nextColor = color[node] == BLUE ? RED : BLUE;
                    ArrayList<Integer> arrayList = paths.get(node);
                    for (int child : arrayList) {
                        if (color[node] == color[child]) {
                            answer = "NO";
                            break;
                        }
                        if (visit[child] == 1)
                            continue;
                        color[child] = nextColor;
                        queue.offer(child);
                    }
                }
            }

            System.out.println(answer);
            K--;
        }
    }
}