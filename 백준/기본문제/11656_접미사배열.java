import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        PriorityQueue<String> queue = new PriorityQueue<>();
        for(int i = 0 ; i < s.length() ; i++){
            queue.offer(s.substring(i));
        }

        while(!queue.isEmpty())
            System.out.println(queue.poll());
    }
}