import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>>list = new ArrayList<>();

        int n = sc.nextInt();
        for(int i = 0 ; i <=n ; i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i = 1 ; i < n ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int[] visit = new int[n+1];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visit[1] = 1;
        while(!queue.isEmpty()){
            int start = queue.poll();
            for(int item : list.get(start)){
                if(visit[item] == 0) {
                    visit[item] = start;
                    queue.offer(item);
                }
            }
        }

        for(int i =2 ; i <= n ; i++){
            System.out.println(visit[i]);
        }
    }
}
