import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int B = sc.nextInt();
        boolean[] visited = new boolean[200001];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(B);
        visited[B] = true;
        boolean flag = false;
        int time = -1;
        while(!queue.isEmpty() && !flag){
            time++;
            int size =  queue.size();
            for(int i = 0 ; i < size ; i++){
                Integer poll = queue.poll();
                if(poll == C + (time * (time+1))/2) {
                    flag = true;
                    break;
                }
                int val = poll - 1;
                if(val >= 0 && val <= 200000 && !visited[val]) {
                    visited[val] = true;
                    queue.offer(val);
                }

                val = poll + 1;
                if(val >= 0 && val <= 200000 && !visited[val]) {
                    visited[val] = true;
                    queue.offer(val);
                }

                val = poll * 2;
                if(val >= 0 && val <= 200000 && !visited[val]) {
                    visited[val] = true;
                    queue.offer(val);
                }
            }
        }
        
        System.out.println(time);
    }
}