import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> relationship = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            relationship.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++){
            int friend1 = sc.nextInt();
            int friend2 = sc.nextInt();
            relationship.get(friend1).add(friend2);
            relationship.get(friend2).add(friend1);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> invited = new TreeSet<>();
        ArrayList<Integer> list = relationship.get(1);
        invited.addAll(list);
        for(int i : list){
            queue.offer(i);
        }
        while(!queue.isEmpty()){
            int N = queue.poll();
            invited.addAll(relationship.get(N));
        }

	// 상근이 제외
        System.out.println(invited.size()-1);
    }
}