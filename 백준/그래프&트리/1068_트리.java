import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] parents = new int[N];
        int rootVal = 0;
        for(int i = 0 ; i < N ; i++){
            parents[i] = Integer.parseInt(st.nextToken());
            if(parents[i] == -1){
                rootVal = i;
            }
        }

        Tree tree = new Tree(rootVal);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(rootVal);
        while(!queue.isEmpty()){
            int parent = queue.poll();
            for(int i = 0 ; i < N ; i++){
                if(parents[i] == parent){
                    tree.insert(tree.root, parent, i);
                    queue.offer(i);
                }
            }
        }
        int removeIdx = Integer.parseInt(br.readLine());
        if(removeIdx == rootVal){
            System.out.println(0);
            return;
        }

        tree.remove(tree.root, removeIdx);
        int answer = tree.findLeafNode(tree.root);
        System.out.println(answer);
    }

    static class Tree{
        Node root;

        public Tree(int v) {
            root = new Node(v);
        }

        public boolean insert(Node node, int parentVal, int val){
            if(node.v == parentVal){
                node.child.add(new Node(val));
                return true;
            }
            for(Node n : node.child){
                if(insert(n, parentVal, val))
                    return true;
            }
            return false;
        }

        public void remove(Node node, int val) {
            for(int i = 0 ; i < node.child.size() ; i++){
                if(node.child.get(i).v == val){
                    node.child.remove(i);
                }else{
                    remove(node.child.get(i), val);
                }
            }
        }

        public int findLeafNode(Node node) {
            if(node.child.size() == 0)
                return 1;
            int cnt = 0;
            for(Node n : node.child){
                cnt += findLeafNode(n);
            }
            return cnt;
        }
    }

    static class Node{
        int v;
        List<Node> child;

        public Node(int v) {
            this.v = v;
            child = new ArrayList<>();
        }
    }
}