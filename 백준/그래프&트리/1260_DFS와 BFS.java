import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    int nodeCnt = sc.nextInt();
    int lineCnt = sc.nextInt();
    int root = sc.nextInt();
    int[] visit = new int[nodeCnt+1];

    for(int i = 0 ; i <= nodeCnt ; i++){
      list.add(new ArrayList<Integer>());
    }

    for(int i = 0 ; i < lineCnt ; i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      list.get(a).add(b);
      list.get(b).add(a);
    }

    //DFS
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    stack.push(root);
    while(!stack.empty()){
      int start = stack.pop();
      list.get(start).sort(Comparator.reverseOrder());
      for (int i : list.get(start)) {
        if (visit[i] != 1) {
          stack.push(i);
        }
      }
      if(visit[start] != 1)
        sb.append(start).append(" ");
      visit[start] = 1;
    }

    System.out.println(sb);

    //BFS
    sb = new StringBuilder();
    Arrays.fill(visit, -1);
    LinkedList<Integer> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      int start = queue.poll();
      list.get(start).sort(Comparator.naturalOrder());
      for (int i : list.get(start)) {
        if (visit[i] != 1) {
          queue.offer(i);
        }
      }
      if(visit[start] != 1)
        sb.append(start).append(" ");
      visit[start] = 1;
    }
    System.out.println(sb);
  }
}