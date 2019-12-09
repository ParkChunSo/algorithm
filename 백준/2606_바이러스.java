import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> network = new ArrayList<>();
        int n = scanner.nextInt();
        int[] visit = new int[n+1];
        for(int i = 0 ; i < n+1 ; i++)
            network.add(new ArrayList<>());

        int lineCnt = scanner.nextInt();
        for(int i = 0 ; i < lineCnt ; i++){
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();

            network.get(node1).add(node2);
            network.get(node2).add(node1);
        }

        Stack<Integer> dfs = new Stack<>();
        int cnt = -1;
        dfs.push(1);
        visit[1] = 1;
        while(!dfs.empty()){
            int start = dfs.pop();
            cnt++;
            ArrayList<Integer> linkedNodes = network.get(start);
            for(Integer tmp : linkedNodes){
                if(visit[tmp] != 1) {
                    dfs.add(tmp);
                    visit[tmp] = 1;
                }
            }
        }
        System.out.println(cnt);
    }
}