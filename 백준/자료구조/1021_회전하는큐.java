import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] quests;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        quests = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            quests[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        System.out.println(solution(0));
    }

    public static int solution(int idx) {
        if (idx == quests.length) {
            return 0;
        }
        int left = 0;
        for (int integer : queue) {
            if (integer == quests[idx]) {
                break;
            }
            left++;
        }
        int right = queue.size() - left;
        rotate(left);
        if (left <= right)
            return solution(idx + 1) + left;
        else
            return solution(idx + 1) + right;
    }

    private static void rotate(int cnt) {
        for (int i = 0; i < cnt; i++) {
            queue.offer(queue.poll());
        }
        queue.poll();
    }
}