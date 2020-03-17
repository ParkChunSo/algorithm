import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        if (N > K) {
            System.out.println(N - K);
            return;
        }

        int location = K;
        int[] second = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(location);
        while (location != N && !queue.isEmpty()) {
            location = queue.poll();
            if (location+1 < 100001 && second[location + 1] == 0) {
                queue.offer(location + 1);
                second[location + 1] = second[location] + 1;
            }
            if (location > 0 && second[location - 1] == 0) {
                queue.offer(location - 1);
                second[location - 1] = second[location] + 1;
            }
            if (location % 2 == 0 && second[location / 2] == 0) {
                queue.offer(location / 2);
                second[location / 2] = second[location] + 1;
            }
        }
        System.out.println(second[N]);
    }
}