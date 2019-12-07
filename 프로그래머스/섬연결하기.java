import java.util.ArrayList;

public class Main {
    static int[] visit;
    static ArrayList<ArrayList<Node>> path;
    public static void main(String[] args) {
        int[][] cost = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
        int answer = solution(4, cost);
        System.out.println(answer);
    }

    public static int solution(int n, int[][] costs) {
        path = new ArrayList<>();
        visit = new int[n];

        for (int i = 0; i < n; i++)
            path.add(new ArrayList<>());

        for (int[] tmp : costs) {
            path.get(tmp[0]).add(new Node(tmp[1], tmp[2]));
            path.get(tmp[1]).add(new Node(tmp[0], tmp[2]));
        }

        int minCost = 999999999;
        for(int i = 0 ; i < n ; i++){
            visit[i] = 1;
            minCost = Math.min(minCost, findOptimalPath(i));
            visit[i] = 0;
        }

        return minCost;
    }

    public static int findOptimalPath(int nodeIdx) {
        ArrayList<Node> nodes = path.get(nodeIdx);
        nodes.sort((node1, node2) -> {
            if(node1.cost > node2.cost)
                return 1;
            else if(node1.cost == node2.cost)
                return 0;
            else
                return -1;
        });

        int minCost = 999999999;
        for (Node node : nodes) {
            if (visit[node.endPoint] == 1)
                continue;
            visit[node.endPoint] = 1;
            minCost = Math.min(minCost, findOptimalPath(node.endPoint) + node.cost);
            visit[node.endPoint] = 0;
        }
        if(minCost == 999999999)
            minCost = 0;
        return minCost;
    }

    public static class Node {
        int endPoint;
        int cost;

        Node(int endPoint, int cost) {
            this.endPoint = endPoint;
            this.cost = cost;
        }
    }
}
