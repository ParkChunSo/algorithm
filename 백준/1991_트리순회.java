import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cnt = Integer.parseInt(sc.nextLine());
        String[] tmp = sc.nextLine().split(" ");

        Tree tree = new Tree(tmp[0].charAt(0), tmp[1].charAt(0), tmp[2].charAt(0));
        for(int i = 0 ; i < cnt-1 ; i++){
            String[] nodeData = sc.nextLine().split(" ");
            tree.add(nodeData[0].charAt(0), nodeData[1].charAt(0), nodeData[2].charAt(0));
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
    }

    public static class Tree{
        Node root;

        public Tree(char data, char left, char right){
            this.root = new Node(data);

            if(left != '.'){
                this.root.left = new Node(left);
            }
            if(right != '.'){
                this.root.right = new Node(right);
            }
        }
        public void add(char data, char left, char right){
            next(root.left, data, left, right);
            next(root.right, data, left, right);
        }

        public void next(Node node, char data, char left, char right){
            if(node == null)
                return;

            if(node.data == data){
                if(left != '.'){
                    node.left = new Node(left);
                }
                if(right != '.'){
                    node.right = new Node(right);
                }
            }else{
                next(node.left, data, left, right);
                next(node.right, data, left, right);
            }
        }

        public void preOrder(Node node){
            System.out.print(node.data);
            if(node.left != null)
                preOrder(node.left);

            if(node.right != null)
                preOrder(node.right);

        }

        public void inOrder(Node node){
            if(node.left != null)
                inOrder(node.left);

            System.out.print(node.data);

            if(node.right != null)
                inOrder(node.right);
        }

        public void postOrder(Node node){
            if(node.left != null)
                postOrder(node.left);
            if(node.right != null)
                postOrder(node.right);
            System.out.print(node.data);
        }
    }

    public static class Node{
        char data;
        Node left;
        Node right;

        public Node(char data){
            this.data = data;
        }
    }
}
